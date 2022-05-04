package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover925 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover925() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover925();
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
				
				Thread.sleep(800); 
				((Room) mobile.getLocation()).movePlayerTo(926);
			
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
