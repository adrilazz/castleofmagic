package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class MemoryGame extends JDialog implements Runnable{
	List<JButton> _lst;
	Thread _thread;
	JButton _restartButton;
	List<Integer> _introducedOrder;
	List<Integer> _trueOrder;
	int _buttonsPressed;
	JLabel _label, _label2;
	MUDFrame _dadFrame;
	
	public MemoryGame(MUDFrame f, String name, int n) {
		super(f, name);
		_lst = new ArrayList<>();
		_introducedOrder = new ArrayList<>();
		_trueOrder = _puzzleGenerator(n);
		_buttonsPressed = 0;
		init();
		setVisible(true);
		_dadFrame = f;
		_thread = new Thread(this);
		_thread.start();
	}
	
	List<Integer> _puzzleGenerator(int n)
	{
		ArrayList<Integer> a = new ArrayList<>();
		Random r = new Random();
		for (int i = 0; i < n; i++)
			a.add(r.nextInt(6));
		return a;
	}
	
	JButton newButton() {
		JButton ret = new JButton();
		ret.setBackground(null);
		ret.setMaximumSize(new Dimension(100, 100));
		ret.setIcon(new ImageIcon("res/media/buttonTwin1.png"));
		ret.setBorder(null);
		_lst.add(ret);
		
		return ret;
	}

	void incorrect() {
		_label.setText(" ");
		_label2.setText("                   Wrong order. Try again.");
		reset();
	}

	void reset() {	
		_thread = new Thread(this);
		
		for (JButton jB : _lst)
			jB.setEnabled(true);
		
		_introducedOrder = new ArrayList<>();
		_buttonsPressed = 0;
		_thread.start();
	}

	@Override
	public void run() {
		enableAllButtons(false);
		_restartButton.setEnabled(false);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		JButton b1;
		
		for (Integer i : _trueOrder)
		{
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {}
			b1 = _lst.get(i);
			b1.setIcon(new ImageIcon("res/media/buttonTwin2.png"));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			b1.setIcon(new ImageIcon("res/media/buttonTwin1.png"));
		}
		_restartButton.setEnabled(true);
		enableAllButtons(true);

	}
	
	//0 if wrong, 1 if incomplete, 2 if correct
	int checkIfDone()
	{
		if (_buttonsPressed == _trueOrder.size())
		{
			if (_introducedOrder.equals(_trueOrder))
				return 2;
			else 
				return 0;
		}
		return 1;
	}
	
	void enableAllButtons(boolean b) {
		for (JButton but : _lst)
		{
			if (!b)
				but.removeActionListener(but.getActionListeners()[0]);
			else 
			{
				but.addActionListener((e) -> {
					_introducedOrder.add(_lst.indexOf(but));
					_buttonsPressed++;
					int c = checkIfDone();
					if (c == 0)
						incorrect();
					if (c == 2)
						correct();
				});
			}
		}
	}

	void init() {
		JPanel bigPanel = new JPanel();
		bigPanel.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		topPanel.setBackground(new Color(72, 60, 50));
		topPanel.setForeground(Color.white);
		topPanel.add(new JLabel("       "));
		topPanel.add(new JLabel("       "));
		_label = new JLabel("      Memorize the order in which Sheldon Cards appear. ");
		_label.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		_label.setForeground(Color.white);
		topPanel.add(_label);
		topPanel.add(new JLabel("       "));
		_label2 = new JLabel("               Then select the cards in order.");
		_label2.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		_label2.setForeground(Color.white);
		topPanel.add(_label2);
		bigPanel.add(topPanel, BorderLayout.PAGE_START);
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
		centerPanel.setBackground(new Color(72, 60, 50));
		
		for (int i = 0; i < 6; i++)
		{
			JButton b0 = newButton();
			centerPanel.add(b0);
		}
		enableAllButtons(true);
		bigPanel.add(centerPanel, BorderLayout.CENTER);
		
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
		bottomPanel.setBackground(new Color(72, 60, 50));
		
		_restartButton = new JButton();
		
		ImageIcon imageIcon = new ImageIcon("res/media/repeat.jpg"); 
		 Image image = imageIcon.getImage();  
		 Image newimg = image.getScaledInstance(200, 50, Image.SCALE_SMOOTH);  
		 imageIcon = new ImageIcon(newimg);  
		 _restartButton.setIcon(imageIcon);
		
		 _restartButton.setSize(new Dimension(200, 50));
		 _restartButton.setBackground(null);
		_restartButton.setBorder(null);
		_restartButton.addActionListener( (e) -> {
			reset();
		});
		bottomPanel.add(_restartButton);
		
		JPanel bPanel = new JPanel();
		bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
		bPanel.setBackground(new Color(72, 60, 50));
		bPanel.add(new JLabel("                     "));
		bPanel.add(bottomPanel);
		bPanel.add(new JLabel("                     "));
		bPanel.add(new JLabel("                     "));
		
		bigPanel.add(bPanel, BorderLayout.PAGE_END);
		
		setResizable(false);
		pack();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(630, 400));
		setLocation(new Point(700, 300));
		setContentPane(bigPanel);
	}
	
	abstract void correct();
}
