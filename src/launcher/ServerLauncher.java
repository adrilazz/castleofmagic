package launcher;

import server.MudServer;

public class ServerLauncher {
	
	private static final int LISTENER_PORT = 4000;

	public static void main(String[] args) {
		try {
			MudServer mudServer = new MudServer(LISTENER_PORT);
			mudServer.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
