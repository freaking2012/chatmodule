package com.eventmate.ChatModule.domain;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerDo {

	// The server socket.
	  private static ServerSocket serverSocket = null;
	  // The client socket.
	  private static Socket clientSocket = null;
	  
	// This chat server can accept up to maxClientsCount clients' connections.
	  private static final int maxClientsCount = 10;
	  private static final clientThread[] threads = new clientThread[maxClientsCount];
	  private static final int PORT_NUMBER = 9999;
	  
	  public static void main(String[] args)
	  {
		  try {
			serverSocket = new ServerSocket(PORT_NUMBER);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  /*
		     * Create a client socket for each connection and pass it to a new client
		     * thread.
		     */
		  
	  }

	
	
}

class clientThread extends Thread{
	
}
