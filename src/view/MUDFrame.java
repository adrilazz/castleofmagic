package view;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;
import model.*;

/**
 * MUDFrame is contains the main visual display for the user. It will contain a
 * main combat window that will be used for playing in the game. There is a chat
 * tab that will be used to show only the chat between players. It will send all
 * entered text to the server and based on what command was used the proper
 * command will be called. The text will be displayed using ANSI coloring to
 * help distinguish between items, exits and so on.
 * 
 * @author Matt Turner, Ross Bottorf, Zach Boe, Jonathan Perrie
 * 
 */
@SuppressWarnings("serial")
public class MUDFrame extends JFrame {

	private CombatPanel comPanel;
	private RoomPicture pic;
	private JMenuBar menuBar;
	private JMenu mainFile;
	private JMenuItem exitMenuItem;
	private JMenuItem aboutMenuItem;
	private network.Client client;
	private JTextField textField;

	/**
	 * MUDFrame constructor is empty.
	 */
	public MUDFrame() {
	}

	/**
	 * The main method that will start the MUD. It will create a new MUDFrame
	 * and ask for a IP and port to connect to the server.
	 * 
	 * @param args
	 */
	/*public static void main(String[] args) {
		MUDFrame frame = new MUDFrame();
		if (frame.init() != true) {
			JOptionPane.showMessageDialog(null, "Couldn't connect to server");
			System.exit(1);
		}
	}*/

	/*
	 * This method initializes the mud frame components.
	 */
	public boolean init() {

		//this.client = new network.Client("150.135.1.17", 4000);

		this.client = new network.Client("localhost", 4000);

		if ((this.client != null) && this.client.connect()) {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("Castle of Magic");
			ImageIcon icon = new ImageIcon("res/media/tower.png");
			this.setIconImage(icon.getImage());
			setPreferredSize(new Dimension(1920, 1000));
			setLocation(0, 20);

			getContentPane().setBackground(new Color(72, 60, 50));
			setLayout(null);

			menuBar = new JMenuBar();
			mainFile = new JMenu("File");
			exitMenuItem = new JMenuItem("Exit");
			aboutMenuItem = new JMenuItem("About");
			mainFile.add(aboutMenuItem);
			mainFile.add(exitMenuItem);
			exitMenuItem.addActionListener(new ExitListener());
			aboutMenuItem.addActionListener(new AboutListener());
			menuBar.add(mainFile);
			setJMenuBar(menuBar); 
           
			// Construct chat panel text field and button
			textField = new JTextField();
			textField.addKeyListener(new EnterListener());
			textField.setSize(new Dimension(1830, 20));
			textField.setLocation(new Point(15, 900));
			textField.setFont(new Font("Lucida Console", Font.PLAIN, 16));
			textField.setVisible(false);
			add(textField);
			
			JButton newGameBut = new JButton();
			newGameBut.addActionListener( (e) -> {
				GameDialog d = new GameDialog(this, newGameBut);
				d.setVisible(true);
				newGameBut.setEnabled(false);
			});
			newGameBut.setIcon(new ImageIcon("res/media/button.png"));
			newGameBut.setSize(new Dimension(409, 107));
			newGameBut.setLocation(new Point(1130, 565));
			newGameBut.setFont(new Font("Lucida Console", Font.PLAIN, 16));
			add(newGameBut);

			comPanel = new CombatPanel(textField);
			add(comPanel);
			
			pic = new RoomPicture("res/media/HomeMenu.jpg", this);
			add(pic);
			
			StdAudio.loopInBackground("res/media/homeTheme.wav");

			MudModel.getMudModel().addObserver(comPanel);
			MudModel.getMudModel().addObserver(pic);
			
			setResizable(false);

			pack();
			setVisible(true);

			client.start();
			return true;
		} 
		else
			return false;
	}

	/*
	 * AboutListener the the ActionListener the the About menu item. it will
	 * display the programmers names and a short description of the program.
	 */
	private class AboutListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String about = "Castle of Magic" 
							 + "\n\n Authors: Aya, Miguel, Lamice, Pablo, Marcos & Adrian ";
			JOptionPane.showMessageDialog(null, about);
		}

	}

	/*
	 * ExitListener is the ActionListener for the Exit menu item. It will simple
	 * call System.exit(0) which will exit out of the current program.
	 */
	private class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}

	/*
	 * This method sends text commands to the network.client.
	 */
	private void sendCommand() {
		String temp = comPanel.getTextField().getText();
		client.sendCommand(temp);
		comPanel.getTextField().setText("");
		if (temp.equalsIgnoreCase("quit")) {
			System.exit(0);
		}
	}
	
	void sendCommand(String s) {
		client.sendCommand(s);
	}
	
	void hideNewGameButton(JButton j) {
		remove(j);
	}

	public void enableBar(boolean b) {
		if (b)
		{
			textField.setVisible(true);
			textField.requestFocusInWindow();
		}
		else 
			textField.setVisible(false);
	}
	
	/*
	 * EnterListener is the KeyListener that waits for the Enter key to be
	 * pressed. This Listener will perform the exact same operation as the
	 * ButtonListener for the Enter button on the panel. It will take the
	 * command and execute it, clear the field and reset the focus back to the
	 * field.
	 */
	private class EnterListener implements KeyListener {
		public void keyTyped(KeyEvent e) {
		}

		public void keyPressed(KeyEvent e) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER)
				sendCommand();
			else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_KP_UP)
				sendCommand("north");
			else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_KP_DOWN)
				sendCommand("south");
			else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_KP_LEFT)
				sendCommand("west");
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_KP_RIGHT)
				sendCommand("east");
			else if (e.getKeyCode() == KeyEvent.VK_SHIFT)
				sendCommand("interact");
		}

		public void keyReleased(KeyEvent e) {

		}
	}
}
