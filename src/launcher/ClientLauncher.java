package launcher;

import javax.swing.JOptionPane;

import view.MUDFrame;

public class ClientLauncher {

	public static void main(String[] args) {
		try {
			MUDFrame frame = new MUDFrame();
			if (frame.init() != true) {
				JOptionPane.showMessageDialog(null, "Couldn't connect to server");
				System.exit(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}