package view;

@SuppressWarnings("serial")
public class MemoryGame1 extends MemoryGame {
	
	public MemoryGame1(MUDFrame f) {
		super(f, "Elden & Sheldon Card Challenge - Level 1", 5);
	}
	
	void correct() {
		_label.setText("Correct pattern!!");
		setVisible(false);
		new MemoryGame2(_dadFrame);
	}
}
