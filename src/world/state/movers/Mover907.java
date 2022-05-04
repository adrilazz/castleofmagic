package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover907 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover907() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover907();
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
					Thread.sleep(500); 
				}
				
				Thread.sleep(500); 
				((Room) mobile.getLocation()).movePlayerTo(910);
			
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
