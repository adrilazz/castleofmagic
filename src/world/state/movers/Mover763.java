package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover763 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover763() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover763();
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
				((Room) mobile.getLocation()).movePlayerTo(764);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
