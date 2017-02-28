package com.eventmate.ChatModule.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

import com.eventmate.ChatModule.domain.Server;


public class ServerService extends Thread{

	private Socket socket;
    private int clientNumber;
    
	public ServerService(Socket socket,int clientNumber)
	{
		this.socket = socket;
		this.clientNumber = clientNumber;
	}
	
	 public void run() {
	        try {
	        	
	        	PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	        	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        	
	        	System.out.println("Map is");
	        	for(Map.Entry<Integer, ServerService> entry: Server.userMap.entrySet())
	        	{
	        		System.out.println(entry.getKey()+" "+entry.getValue());
	        	}
	        	out.println("Hello, you are client #" + clientNumber + ".");
	        	out.println("Please enter client number with whom you want to chat: ");
	        	Integer receiverNo = Integer.parseInt(in.readLine());
	        	System.out.println("receiver: "+receiverNo+" sender: "+clientNumber);
	        	if(Server.userMap.containsKey(receiverNo)&&receiverNo!=clientNumber)
	            {
	        	ServerService receiver = Server.userMap.get(receiverNo);
	        	PrintWriter receiverOut = new PrintWriter(receiver.socket.getOutputStream(), true);
	            
	            
	            	receiverOut.println("Hi "+receiverNo+". This is "+clientNumber);
	            while (true) {
	                String input = in.readLine();
	                receiverOut.println("You said: "+input);
	            }
	            }
	            else
	            {
	            	out.println("There is no one with name");
	            }
	            
	        } catch (Exception e) {
	            System.out.println(e.toString());
	        }

	    }
}
