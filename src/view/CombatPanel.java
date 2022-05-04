package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.CombatCommand;

/**
 * CombatPanel will be the main panel that will control the text that is
 * displayed to the console during the game. It contains a JTextArea that will
 * allow the user the interact with the game world. It has a null layout which
 * allows for the individual components to be added where I see fit. It observes
 * model.MudWorld and is contained in the MudFrame.
 * 
 * @author Matt Turner, Ross Bottorf, Zach Boe, Jonathan Perrie
 * 
 */
@SuppressWarnings("serial")
public class CombatPanel extends JPanel implements GameObserver {
	private JTextArea worldText;
	private JScrollPane allTextPane;
	private JTextField textField;

	/**
	 * CombatPanel constructor will initiate all of the swing components. It
	 * will set a size of each and set the location relative to where it needs
	 * to be positioned on the panel. The null layout allows for the location to
	 * be set. The panel's color will be set to black to give the illusion of a
	 * real console.
	 */
	public CombatPanel(JTextField field) {
		this.setLayout(null);
		this.setTextField(field);
		this.setSize(new Dimension(700, 830));
		this.setLocation(new Point(15, 50));
		
		worldText = new JTextArea();
		worldText.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		worldText.setEditable(false);
		worldText.setLineWrap(true);
		worldText.setWrapStyleWord(true);
		worldText.setSize(new Dimension(550, 830));
		worldText.setBackground(new Color (72, 60, 50));
		
		allTextPane = new JScrollPane(worldText);
		allTextPane.setSize(new Dimension(700, 830));
		JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {

            @Override
            public boolean isVisible() {
                return false;
            }
        };
		allTextPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		allTextPane.setVerticalScrollBar(scrollBar);
		allTextPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		allTextPane.setBackground(new Color (72, 60, 50));
		allTextPane.setBorder(null);

		for (int i = 0; i < 2; i++)
			worldText.append("\n");

		worldText.setCaretPosition(worldText.getText().length());
		this.add(allTextPane);
	}
	
	/**
	 * The method sets the JTextfield textField instance variable of the class.
	 */
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	/**
	 * This method returns the JTextField textField instance variable of the
	 * class.
	 * 
	 * @return - The JTextField textField instance variable of the class.
	 */
	public JTextField getTextField() {
		return this.textField;
	}

	@Override
	public void combat(CombatCommand combatCommand) {
		String temp = ((model.CombatCommand) combatCommand).getText();
		worldText.setForeground(Color.white);
		worldText.append(temp + "\n");
		worldText.setCaretPosition(worldText.getText().length() - 1);
		repaint();
	}

	@Override
	public void image(String id) {}

	@Override
	public void deleteButton() {}
}
