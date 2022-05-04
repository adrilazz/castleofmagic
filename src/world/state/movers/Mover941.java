package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover941 extends Mover {

	private static final long serialVersionUID = 1L;

	public Mover941() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover941();
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
				((Room) mobile.getLocation()).sendToRoom("Kamek: Let's play again! Wendy, make sure you pay attention.");
				Thread.sleep(500); 
				((Room) mobile.getLocation()).sendToRoom("Press 'SHIFT' to play Kamek's challenge again");
				
				while (((Room) mobile.getLocation()).isPlayerInRoom()){
					Thread.sleep(1000); 
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
