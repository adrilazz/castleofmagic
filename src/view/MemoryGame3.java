package view;

@SuppressWarnings("serial")
public class MemoryGame3 extends MemoryGame {
	
	public MemoryGame3(MUDFrame f) {
		super(f, "Elden & Sheldon Card Challenge - Level 3", 9);
	}

	void correct() {
		_label.setText("Correct pattern!!");
		_dadFrame.sendCommand("up");
		setVisible(false);
		_dadFrame.enableBar(true);
	}
}