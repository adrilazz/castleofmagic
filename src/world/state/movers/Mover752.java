package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover752 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover752() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover752();
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
				((Room) mobile.getLocation()).sendToRoom("They keys Gunter gave you open the chest and...");
				Thread.sleep(2000);
				((Room) mobile.getLocation()).sendToRoom("");
				((Room) mobile.getLocation()).sendToRoom("You found 'Gunter's Card Deck'");
				
				while (((Room) mobile.getLocation()).isPlayerInRoom()){
					Thread.sleep(1000); 
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
