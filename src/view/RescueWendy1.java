package view;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@SuppressWarnings("serial")
public class RescueWendy1 extends RescueWendy {
	
	public RescueWendy1(MUDFrame f) {
		super(f, "Kamek Card Challenge - Level 1", 3, 2000);
	}

	Set<Integer> _puzzleGenerator() {
		Set<Integer> ret = new HashSet<>();
		Random r = new Random();
		int adder = r.nextInt(3);
		
		for (int i = 0; i < adder + 3; i++)
			ret.add(r.nextInt(9));
		
		return ret;
	}
	
	void correct()
	{
		setVisible(false);
		new RescueWendy2(_dadFrame);
	}
}