package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class StateRuth extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public StateRuth() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new StateRuth();
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
				((Room) mobile.getLocation()).sendToRoom("Ruth: Who dares approach the castle?");
				Thread.sleep(3000);
				((Room) mobile.getLocation()).sendToRoom("You: I'm looking for a young girl, I think she could be here...");
				Thread.sleep(3000);
				((Room) mobile.getLocation()).sendToRoom("Ruth: If you want to get inside you will have to beat me in my favorite game");
				Thread.sleep(3800);
				((Room) mobile.getLocation()).sendToRoom("You: What game?");
				Thread.sleep(2500);
				((Room) mobile.getLocation()).sendToRoom("Ruth: The game has already started, it's your turn");
				Thread.sleep(3000);
				((Room) mobile.getLocation()).sendToRoom("You: ...?");
				
				
				((Room) mobile.getLocation()).movePlayerTo(732);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
