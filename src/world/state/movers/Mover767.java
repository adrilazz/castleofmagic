package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover767 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover767() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover767();
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
				((Room) mobile.getLocation()).sendToRoom("Gunter: Thanks buddy. I heard a young girl was kidnapped and came to rescue her but...");
				Thread.sleep(4000);
				((Room) mobile.getLocation()).sendToRoom("Gunter: I lost in the card game and the twins locked me up... They are crazy");
				Thread.sleep(4000);
				((Room) mobile.getLocation()).sendToRoom("You: Wait, did you play with them? So I guess you have cards");
				Thread.sleep(4000);
				((Room) mobile.getLocation()).sendToRoom("Gunter: Of course I have! But they took my card deck away... I don't know where it is... ");
				Thread.sleep(4000);
				((Room) mobile.getLocation()).sendToRoom("Gunter: Wait, take these keys, they might be useful... And thank you!");
				Thread.sleep(3000);
				((Room) mobile.getLocation()).movePlayerTo(768);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
