package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover11 extends Mover {

	private static final long serialVersionUID = 1L;

	public Mover11() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover11();
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
				((Room) mobile.getLocation()).sendToRoom("You: What a dream... Wait where am I? I can't remember anything...");
				Thread.sleep(3500);
				((Room) mobile.getLocation()).sendToRoom("Well, you REMEMBER an advice somebody told you NOT TO FORGET: Type 'commands' whenever you feel lost");
				Thread.sleep(4000);
				
				((Room) mobile.getLocation()).movePlayerTo(12);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
