package view;

@SuppressWarnings("serial")
public class MemoryGame2 extends MemoryGame {
	
	public MemoryGame2(MUDFrame f) {
		super(f, "Elden & Sheldon Card Challenge - Level 2", 7);
	}
	
	void correct() {
		_label.setText("Correct pattern!!");
		setVisible(false);
		new MemoryGame3(_dadFrame);
	}
}
