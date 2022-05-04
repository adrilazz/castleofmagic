package model;

import java.util.ArrayList;
import java.util.List;

import server.*;
import view.GameObserver;
import world.*;

/**
 * MudModel is a singleton. It is used for the two panels, CombatPanel and
 * ChatPanel, to observe. When a command is sent through the GUI this model will
 * be used to send the action. This action will either be a game action(attack,
 * look..) or a chat command that will either send it to all players or one
 * player. This class will eventually be used when we implement more advanced
 * features, like allowing users to save or print their game text and chat text.
 * It receives text from the network.Client when the network.Client receives a
 * message.
 * 
 * @author Matt Turner, Ross Bottorf, Zach Boe, Jonathan Perrine
 * 
 */
public class MudModel {

	private static MudModel model;
	private List<GameObserver> obs;

	// This private constructor along with the private static MudModel variable
	// and public static MudModle method allows MudModel to exist as a singleton
	private MudModel() {
		obs = new ArrayList<>();
	}

	/**
	 * This method returns the instance of the MudModel.
	 * 
	 * @return - The MudModel instance.
	 */
	public static MudModel getMudModel() {
		if (model == null)
			model = new MudModel();
		return model;
	}

	/**
	 * addText method will add text to the end of the text model string and
	 * notify observers.
	 * 
	 * @param text
	 *            String to add to end of text
	 */
	public void addText(String text) {
		for (GameObserver o : obs)
			o.combat(new CombatCommand(text));
	}
	
	public void changeImage(String id) {	
		for (GameObserver o : obs)
			o.image(id);
	}
	
	public void rmButton() {	
		for (GameObserver o : obs)
			o.deleteButton();
	}

	public void addObserver(GameObserver o) {
		obs.add(o);
	}
}
