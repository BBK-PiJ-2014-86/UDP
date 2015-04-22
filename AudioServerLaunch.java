package UDP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
	private static ExecutorService executor;
	
	public static void main (String [] args) {
		
		executor = Executors.newCachedThreadPool();
		
		try {
		server = new ServerSocket (PORT);
		
		while (true) {
			
			try {
				
				Socket socket = server.accept();
				executor.execute(new AudioServer(socket));

			} catch (IOException e) {
				
				e.printStackTrace();
			}
			 
		}
	 } catch (Exception e) {
		 e.printStackTrace();
		 System.out.println("Server could not connect. Port is in use.");
	 }
	}
}
	 