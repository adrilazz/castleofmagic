package view;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@SuppressWarnings("serial")
public class RescueWendy2 extends RescueWendy {
	
	public RescueWendy2(MUDFrame f) {
		super(f, "Kamek Card Challenge - Level 2", 4, 250);
	}

	Set<Integer> _puzzleGenerator() {
		Set<Integer> ret = new HashSet<>();
		Random r = new Random();
		int adder = r.nextInt(6);
		
		for (int i = 0; i < adder + 7; i++)
			ret.add(r.nextInt(16));
		
		return ret;
	}
	
	void correct()
	{
		setVisible(false);
		new RescueWendy3(_dadFrame);
	}
}