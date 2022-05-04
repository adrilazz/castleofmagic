package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.CombatCommand;
import model.MudModel;

@SuppressWarnings("serial")
public class GameDialog extends JDialog implements GameObserver{

	JButton parentB;
	
	public GameDialog(MUDFrame f, JButton j) {
		super(f, "New Game");
		parentB = j;
		init();
		MudModel.getMudModel().addObserver(this);
	}
	
	public void init() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.setBackground(new Color(72, 60, 50));
		
		JLabel l = new JLabel(" Your Name: ");
		l.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		l.setForeground(Color.white);
		mainPanel.add(l);
		
		JTextField nameField = new JTextField();
		nameField.setMaximumSize(new Dimension(200, 20));
		nameField.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		mainPanel.add(nameField);
		
		JLabel espacio = new JLabel(" ");
		espacio.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		mainPanel.add(espacio);

		JButton ok = new JButton();
		ok.addActionListener( (e) -> {
			String s = nameField.getText();
			parentB.setEnabled(true);
			if (!s.equals(""))
			{
				((MUDFrame) getParent()).sendCommand(s);
				setVisible(false);
			}
		});
		ok.setIcon(new ImageIcon("res/media/play.jpg"));
		ok.setMaximumSize(new Dimension(100, 25));
		mainPanel.add(ok);
		
		pack();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(new Dimension(460, 230));
		setLocation(new Point(1110, 600));
		setContentPane(mainPanel);
	}

	@Override
	public void combat(CombatCommand combatCommand) {}

	@Override
	public void image(String id) {}

	@Override
	public void deleteButton() {
		((MUDFrame) getParent()).hideNewGameButton(parentB);
	}
	
}
