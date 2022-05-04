package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover744 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover744() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover744();
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
				((Room) mobile.getLocation()).sendToRoom("Sheldon: Well said brother. Now let me see your card deck.");
				Thread.sleep(3500);
				((Room) mobile.getLocation()).sendToRoom("You: ...");
				Thread.sleep(2000);
				((Room) mobile.getLocation()).sendToRoom("Sheldon: You don't have a single card!? GO AWAY! Come back when you have a deck");
				Thread.sleep(4000);
				((Room) mobile.getLocation()).movePlayerTo(745);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
