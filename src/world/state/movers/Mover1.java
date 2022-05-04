package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover1 extends Mover {

	private static final long serialVersionUID = 1L;

	public Mover1() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover1();
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (World.getInstance().getLockObject()) {
					while (World.getInstance().threadsLocked()) {
						try {
							World.getInstance().getLockObject().wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				while (!((Room) mobile.getLocation()).isPlayerInRoom()){
					Thread.sleep(100); 
				}
	
				Thread.sleep(1000);
				
				((Room) mobile.getLocation()).movePlayerTo(2);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
