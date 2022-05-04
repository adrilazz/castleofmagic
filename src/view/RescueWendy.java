package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List; 
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class RescueWendy extends JDialog implements Runnable{
	List<JButton> _lst;
	Thread _thread;
	Set<Integer> _introducedInput;
	Set<Integer> _trueInput;
	JLabel _label, _label2, _label3;
	JButton _submitButton;
	MUDFrame _dadFrame;
	int _sleepTime;
	
	public RescueWendy(MUDFrame f, String str, int size, int sleepTime) {
		super(f, str);
		_lst = new ArrayList<>();
		_introducedInput = new HashSet<>();
		_dadFrame = f;
		_sleepTime = sleepTime;
		init(size);
		setVisible(true);
		_thread = new Thread(this);
		_thread.start();
	}
		
	void init(int n) {
		JPanel bigPanel = new JPanel();
		bigPanel.setLayout(new BorderLayout());
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		topPanel.setBackground(new Color(72, 60, 50));
		topPanel.setForeground(Color.white);
		topPanel.add(new JLabel(" "));
		_label = new JLabel(" Memorize what you see. ");
		_label.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		_label.setForeground(Color.white);		
		topPanel.add(_label);
		_label2 = new JLabel(" Select all the Kamek cards. ");
		_label2.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		_label2.setForeground(Color.white);
		topPanel.add(_label2);
		_label3 = new JLabel(" But don't hit Wendy! ");
		_label3.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		_label3.setForeground(Color.white);
		topPanel.add(_label3);
		topPanel.add(new JLabel(" "));
		bigPanel.add(topPanel, BorderLayout.PAGE_START);
		
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		centerPanel.setBackground(new Color(72, 60, 50));
		
		for (int i = 0; i < n * n; i++)
		{
			JButton b0 = newButton();
			centerPanel.add(b0);
		}
		activateAllButtons(true);
		bigPanel.add(centerPanel, BorderLayout.CENTER);
		
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
		bottomPanel.setBackground(new Color(72, 60, 50));
		
		_submitButton = new JButton();
		
		 ImageIcon imageIcon = new ImageIcon("res/media/buttonSubmit.jpg"); 
		 Image image = imageIcon.getImage();  
		 Image newimg = image.getScaledInstance(200, 50, Image.SCALE_SMOOTH);  
		 imageIcon = new ImageIcon(newimg);  
		 _submitButton.setIcon(imageIcon);
		 
		_submitButton.setSize(new Dimension(200, 50));
		_submitButton.setBackground(null);
		_submitButton.setBorder(null);
		_submitButton.addActionListener( (e) -> {
			checkIfCorrect();
		});
		bottomPanel.add(_submitButton);
		
		JPanel bPanel = new JPanel();
		bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
		bPanel.setBackground(new Color(72, 60, 50));
		bPanel.add(new JLabel("                     "));
		bPanel.add(bottomPanel);
		bPanel.add(new JLabel("                     "));
		bPanel.add(new JLabel("                     "));
		
		bigPanel.add(bPanel, BorderLayout.SOUTH);
		
		setResizable(false);
		pack();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(n * 115 + 50, n * 116 + 95 + 130));
		setLocation(new Point(700, 120));
		setContentPane(bigPanel);
	}
	
	JButton newButton() {
		JButton ret = new JButton();
		ret.setBackground(null);
		ret.setMaximumSize(new Dimension(100, 100));
		ret.setIcon(new ImageIcon("res/media/buttonEmpty.png"));
		ret.setBorder(null);
		_lst.add(ret);
		
		return ret;
	}

	//1 only resets input, 2 relaunches the thread
	void reset(int option) {	
		
		for (JButton jB : _lst)
			jB.setEnabled(true);
		
		_introducedInput = new HashSet<>();
		
		if (option == 2)
		{
			_thread = new Thread(this);
			_thread.start();
		}
	}

	@Override
	public void run() {
		activateAllButtons(false);
		_submitButton.setEnabled(false);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		_trueInput = _puzzleGenerator();
		
		for (JButton b : _lst)
		{
			if (_trueInput.contains(_lst.indexOf(b)))
				b.setIcon(new ImageIcon("res/media/buttonKamek.png"));
			else
				b.setIcon(new ImageIcon("res/media/buttonWendy.png"));
		}
		
		try {
			Thread.sleep(_sleepTime);
		} catch (InterruptedException e) {}
		
		for (JButton b : _lst)
			b.setIcon(new ImageIcon("res/media/buttonEmpty.png"));
		
		_submitButton.setEnabled(true);
		activateAllButtons(true);
	}
	
	abstract Set<Integer> _puzzleGenerator();

	void activateAllButtons(boolean b) {
		for (JButton but : _lst)
		{
			if (!b)
				but.removeActionListener(but.getActionListeners()[0]);
			else 
			{
				but.addActionListener((e) -> {
					_introducedInput.add(_lst.indexOf(but));
					but.setEnabled(false);
				});
			}
		}
	}
	
	void checkIfCorrect()
	{
		if (_introducedInput.equals(_trueInput))
			correct();
		else
			incorrect();
	}
	
	abstract void correct();
	
	void incorrect() {
		_label.setText("You failed! Try again");
		_label2.setText(" ");
		_label3.setText(" ");
		reset(2);
	}
}