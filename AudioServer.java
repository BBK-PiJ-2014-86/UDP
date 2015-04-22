package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Andrean Georgiev, 13013741
 
 *This class handles TCP connection on server side in a client-server architecture. 
 *
 */

public class AudioServer implements Runnable {
	
	private static boolean first = true; // this variable will act as a 'switch' to identify if first.
	
	public void run () {

		 try  {
		 
		       ServerSocket server = new ServerSocket (PORT);
			   Socket socket = server.accept();
			   PrintWriter out = new PrintWriter (socket.getOutputStream());
			   BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
			 
			 assignUniqueId();
			 
			if(checkIfFirst()) {
				StreamFromFirstClient();
			} else {
				StreamToRestOfClients();
			}
			 
			 
			 
			 
		 } catch (IOException e) {
			e.printStackTrace();
		}
		
		
	 }

	private void StreamToRestOfClients() {
	
		
	}

	private void StreamFromFirstClient() {

		
	}

	private static int assignUniqueId() {
		
		
		return 0;
		
		
	}

	private static boolean checkIfFirst() {
		
		
		return first;
		
		
	}

	}
	 

