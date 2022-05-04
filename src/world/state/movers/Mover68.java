package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover68 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover68() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover68();
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
				((Room) mobile.getLocation()).sendToRoom("The sound of the waves is so relaxing... Oh, somebody left a paper here... There's nothing written...");
				Thread.sleep(3000); 
				((Room) mobile.getLocation()).sendToRoom("Anyways, I should go somewhere else.");
				
				while (((Room) mobile.getLocation()).isPlayerInRoom()){
					Thread.sleep(1000); 
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
