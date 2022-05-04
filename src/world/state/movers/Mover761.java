package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover761 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover761() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover761();
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
				((Room) mobile.getLocation()).sendToRoom("Gunter: Who's there? Not the twins again, please!");
				Thread.sleep(2500);
				((Room) mobile.getLocation()).sendToRoom("Gunter: Oh you're not them. Please help! Uncuff me!");
				Thread.sleep(2000);
	
				((Room) mobile.getLocation()).movePlayerTo(762);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
