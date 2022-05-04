package view;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@SuppressWarnings("serial")
public class RescueWendy3 extends RescueWendy {
	
	public RescueWendy3(MUDFrame f) {
		super(f, "Kamek Card Challenge - Level 3", 5, 1500);
	}

	Set<Integer> _puzzleGenerator() {
		Set<Integer> ret = new HashSet<>();
		Random r = new Random();
		int adder = r.nextInt(9);
		
		for (int i = 0; i < adder + 11; i++)
			ret.add(r.nextInt(25));
		
		return ret;
	}
	
	void correct()
	{
		setVisible(false);
		new RescueWendy4(_dadFrame);
	}
}