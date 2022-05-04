package view;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@SuppressWarnings("serial")
public class RescueWendy4 extends RescueWendy {
	
	public RescueWendy4(MUDFrame f) {
		super(f, "Kamek Card Challenge - Level 4", 6, 2500);
	}

	Set<Integer> _puzzleGenerator() {
		Set<Integer> ret = new HashSet<>();
		Random r = new Random();
		int adder = r.nextInt(14);
		
		for (int i = 0; i < adder + 11; i++)
			ret.add(r.nextInt(36));
		
		return ret;
	}
	
	void correct()
	{
		setVisible(false);
		_dadFrame.sendCommand("up");
		_dadFrame.enableBar(true);
	}
}
