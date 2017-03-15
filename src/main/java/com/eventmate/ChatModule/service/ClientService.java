package com.eventmate.ChatModule.service;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientService implements Runnable{

	// The client socket
	private static Socket clientSocket = null;
	// The output stream
	private static PrintStream os = null;
	// The input stream
	private static DataInputStream is = null;

	private static BufferedReader inputLine = null;
	private static boolean closed = false;

	private static final int PORT_NUMBER = 9999;
	private static String HOST_ADDRESS = "172.20.10.10"; 
	

	public void createClient()
	{
		try {
			clientSocket = new Socket(HOST_ADDRESS, PORT_NUMBER);
			inputLine = new BufferedReader(new InputStreamReader(System.in));
			os = new PrintStream(clientSocket.getOutputStream());
			is = new DataInputStream(clientSocket.getInputStream());
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + HOST_ADDRESS);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to the host "
					+ HOST_ADDRESS);
		}

		if (clientSocket != null && os != null && is != null) {
			try {

				/* Create a thread to read from the server. */
				new Thread(new ClientService()).start();
				
				/*
				 * Close the output stream, close the input stream, close the socket.
				 */
				os.close();
				is.close();
				clientSocket.close();
			} catch (IOException e) {
				System.err.println("IOException:  " + e);
			}
		}
	}


	public void run() {
		/*
		 * Keep on reading from the socket till we receive "Bye" from the
		 * server. Once we received that then we want to break.
		 */
		String responseLine;
		try {
			while ((responseLine = is.readLine()) != null) {
				System.out.println(responseLine);
				if (responseLine.indexOf("*** Bye") != -1)
					break;
			}
			closed = true;
		} catch (IOException e) {
			System.err.println("IOException:  " + e);
		}
	}

}
