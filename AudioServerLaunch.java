package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class AudioServerLaunch {
	
	private static final int PORT = 12321; // server will listen on randomly selected port which is > 1024
	private static boolean first = true; // this variable will act as a 'switch' to identify if first.
	
	public static void main (String [] args) {

		 try  {
			 
		       ServerSocket server = new ServerSocket (PORT);
			   Socket socket = server.accept();
			   PrintWriter out = new PrintWriter (socket.getOutputStream());
			   BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			   assignUniqueId();
			 
 
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
	 