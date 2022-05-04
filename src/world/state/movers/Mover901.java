package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover901 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover901() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover901();
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
				((Room) mobile.getLocation()).sendToRoom("You: This is the place I saw in my dream...");
				Thread.sleep(2500); 
				((Room) mobile.getLocation()).sendToRoom("You: Wait, Wendy is over there!");
				Thread.sleep(2500);
				((Room) mobile.getLocation()).movePlayerTo(902);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
