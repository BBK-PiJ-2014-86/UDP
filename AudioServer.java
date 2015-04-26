package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Andrean Georgiev, 13013741
 *This class handles TCP connection on server side in a client-server architecture. 
 *
 */

public class AudioServer implements Runnable {
	
	private static boolean switchIfFirst = true; // this variable will act as a 'switch' to identify if first and is static to the class
	private boolean isFirst; // variable to capture if the socket / thread is first
	private Socket socket; 
	private PrintWriter out; // output to socket
	private BufferedReader in;// input to socket
	private static Set <Integer> uniqueIdList = new HashSet<Integer>();; // set to hold Ids
	private static int idTrack=0;
	private Integer id;
	
	/**
	 * The constructor creates an AudioServer with passed Socket as an object parameter. It sets the field isFirst to true or false
	 * depending on whether the thread / client request is first
	 * @param socket
	 */
	
	public AudioServer (Socket socket) {
		this.socket = socket;
		
		// check if switchIfFirst is true - if so this will be the thread handling the first client request
		if (switchIfFirst) {
			isFirst = true;
			switchIfFirst = false;
		} else {
			isFirst = false;
		}
		
		// assign id to audioserver
		
		id = idTrack;
		idTrack++;
		uniqueIdList.add(id);
		
	}
	
	public void run () {

		 try  {
			   out = new PrintWriter (socket.getOutputStream());
			   in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  
			   out.println(id);
			   
			   if (isFirst) { 
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
		
		id = idTrack;
		idTrack++;
		
		return 0;
		
		
	}



}
	 

