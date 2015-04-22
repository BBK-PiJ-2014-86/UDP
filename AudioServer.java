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
	
	private static boolean switchIfFirst = true; // this variable will act as a 'switch' to identify if first.
	private boolean isFirst; // variable to capture if the socket / thread is first
	private Socket socket; 
	
	public AudioServer (Socket socket) {
		this.socket = socket;
		
		// check if switchIfFirst is true - if so this will be the thread handling the first client request
		if (switchIfFirst) {
			isFirst = true;
			switchIfFirst = false;
		} else {
			isFirst = false;
		}
		
	}
	
	public void run () {

		 try  {
		
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
	 

