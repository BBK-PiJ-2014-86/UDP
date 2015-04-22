package UDP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Andrean Georgiev, 13013741
 * 
 * This class will listen to connection request and creates separate threads that will be handled through the class AudioServer
 *
 */

public class AudioServerLaunch {
	
	private static final int PORT = 12321; // server will listen on randomly selected port which is > 1024
	private static ServerSocket server;
	
	public static void main (String [] args) {
		
		while (true) {
			
			try {
				server = new ServerSocket (PORT);
				Socket socket = server.accept();
				
				

			} catch (IOException e) {
				System.out.println("Server could not connect. Port is in use.");
				e.printStackTrace();
			}
			 
		}
	 }
}
	 