package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover69 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover69() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover69();
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
				((Room) mobile.getLocation()).sendToRoom("A crowded market... Why is that woman selling so many scissors?...");
				Thread.sleep(3000); 
				((Room) mobile.getLocation()).sendToRoom("Well, I don't have time to go shopping.");

				while (((Room) mobile.getLocation()).isPlayerInRoom()){
					Thread.sleep(1000); 
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
