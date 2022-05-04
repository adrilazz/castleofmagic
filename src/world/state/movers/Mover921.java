package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover921 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover921() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover921();
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
				((Room) mobile.getLocation()).sendToRoom("Kamek: Well, congratulations, knight, you won and I lost.");
				Thread.sleep(4000); 
				((Room) mobile.getLocation()).sendToRoom("You: Thanks. But are you sure you didn't hurt Wendy?");
				Thread.sleep(4000); 
				((Room) mobile.getLocation()).sendToRoom("Kamek: Of course not! She came here to play Magic Cards. She is good but still has a lot to learn...");
				Thread.sleep(4500);
				((Room) mobile.getLocation()).sendToRoom("Kamek: Maybe you could teach her. Please, stay here a little more time. We would be pleased to have a player like you in the Castle.");
				Thread.sleep(5000);
				((Room) mobile.getLocation()).sendToRoom("You: Well, I guess I could stay here for a while... Until I recover my memory... Woah, I am exhausted... What a journey...");
				Thread.sleep(5000);
				
				((Room) mobile.getLocation()).movePlayerTo(922);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
