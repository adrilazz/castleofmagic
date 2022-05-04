package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover755 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover755() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover755();
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
				
				((Room) mobile.getLocation()).sendToRoom("");
				((Room) mobile.getLocation()).sendToRoom("Elden & Sheldon: You shall pass.");
				Thread.sleep(15000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
