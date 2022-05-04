package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover870 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover870() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover870();
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
					Thread.sleep(1000); 
				}
				
				Thread.sleep(1000);
				((Room) mobile.getLocation()).movePlayerTo(871);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
