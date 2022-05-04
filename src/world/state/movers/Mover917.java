package world.state.movers;

import world.Room;
import world.World;
import world.state.State4Mobile;

public class Mover917 extends Mover {

	private static final long serialVersionUID = -264938416479419232L;

	public Mover917() {
		super();
	}

	@Override
	public State4Mobile cloneState4Mobile() {

		return new Mover917();
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
				((Room) mobile.getLocation()).sendToRoom("Wendy: Woaah! You've won against Kamek!");
				Thread.sleep(3500); 
				((Room) mobile.getLocation()).sendToRoom("You: Yes! And I am here to rescue you, so let's get out of h... ");
				Thread.sleep(3500); 
				((Room) mobile.getLocation()).sendToRoom("Wendy: Hahahahahaha. To rescue me! You are so funny Mr. Knighty");
				Thread.sleep(3500);
				((Room) mobile.getLocation()).sendToRoom("You: ...?");
				Thread.sleep(2000);
				((Room) mobile.getLocation()).sendToRoom("Wendy: It was me who wanted to come here...");
				Thread.sleep(3000);
				((Room) mobile.getLocation()).sendToRoom("Wendy: I love playing Magic Cards, and everybody knows that the Castle of Magic is where the best Card Players are...");
				Thread.sleep(5000);
				((Room) mobile.getLocation()).sendToRoom("Wendy: I am good at playing, but Kamek is too much for me... Well that's why he's one of the best... And you defeated him!");
				Thread.sleep(5000);
				((Room) mobile.getLocation()).sendToRoom("You: But... My dream... Your father... We thought you were in danger!!");
				Thread.sleep(4000);
				((Room) mobile.getLocation()).sendToRoom("Wendy: Bah! My father worries too much. He has to understand that I am no longer a kid. I'll be 12 this month!! ");
				Thread.sleep(4500);
				((Room) mobile.getLocation()).sendToRoom("You: ...");
				Thread.sleep(2000);
				((Room) mobile.getLocation()).sendToRoom("Wendy: But please Mr Knighty, teach me how to play Magic Cards... Please Please Please...");
				Thread.sleep(4000);
				
				((Room) mobile.getLocation()).movePlayerTo(918);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}
