package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover911 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover911() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover911();
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
				((Room) mobile.getLocation()).sendToRoom("Kamek: Congratulations. Few people manage to reach here...");
				Thread.sleep(3500); 
				((Room) mobile.getLocation()).sendToRoom("Kamek: Hmmm... Maybe you can entertain me for a while...");
				Thread.sleep(3500); 
				((Room) mobile.getLocation()).sendToRoom("You: I'm here to rescue Wendy! Did you hurt her!?");
				Thread.sleep(3500);
				((Room) mobile.getLocation()).sendToRoom("Kamek: Shhh. Play. Now. ");
				Thread.sleep(3000);
				((Room) mobile.getLocation()).movePlayerTo(912);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
