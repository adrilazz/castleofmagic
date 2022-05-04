package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover753 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover753() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover753();
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
				((Room) mobile.getLocation()).sendToRoom("Elden: Oh, I see you have a deck, now we can play! ");
				Thread.sleep(1500);
				((Room) mobile.getLocation()).sendToRoom("(Press 'SHIFT' to play a Magic Card Game with the twins)");
				Thread.sleep(15000);
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
