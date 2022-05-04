package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover55 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover55() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover55();
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
				((Room) mobile.getLocation()).sendToRoom("Roy: Welcome to the tavern! What brings you here young knight?");
				Thread.sleep(2500); 
				((Room) mobile.getLocation()).sendToRoom("You: I'm looking for a girl that has been kidnaped, do you have any idea of where could I find her?");
				Thread.sleep(3500); 
				((Room) mobile.getLocation()).sendToRoom("Roy: I'm afraid I cannot help you, but this is not a big town, go outside and look over there...");
				Thread.sleep(3500); 
				((Room) mobile.getLocation()).sendToRoom("Roy: The Bridge is to the west, the Shipyard to the south and the Market to the east. Visit those places first...");
				Thread.sleep(3500);
				((Room) mobile.getLocation()).sendToRoom("Roy: And let me give you an advice: 'Pay attention to what you see'");
				Thread.sleep(3500);
				((Room) mobile.getLocation()).sendToRoom("You: Thank you!");
				
				while (((Room) mobile.getLocation()).isPlayerInRoom()){
					Thread.sleep(1000); 
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
