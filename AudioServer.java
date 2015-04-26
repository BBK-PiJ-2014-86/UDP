package UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
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
	private DatagramSocket udpSocket;
	private DatagramPacket udpPacket;
	private int udpPacketPort; 
	private InetAddress udpPacketInetAddress;
	
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

		out.println(isFirst);
		
		/* need to find a way to get the size of the file to be transmitted and create an array of the
		 * appropriate size
		 */
		String sizeOfFile = null;
		try {
			sizeOfFile = in.readLine();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
		int size = Integer.parseInt(sizeOfFile);
		
		try {
			byte [] buf = new byte [size];
			udpPacket = new DatagramPacket(buf, buf.length);
			udpSocket = new DatagramSocket (13131);
			udpSocket.receive(udpPacket);
		} catch (SocketException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}



}
	 

