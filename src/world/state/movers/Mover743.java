package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover743 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover743() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover743();
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
				((Room) mobile.getLocation()).sendToRoom("Elden: Stand back!");
				Thread.sleep(2500);
				((Room) mobile.getLocation()).sendToRoom("Elden: Beat us in a game of Magic Cards to go upstairs.");
				Thread.sleep(3500);
				((Room) mobile.getLocation()).movePlayerTo(744);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
