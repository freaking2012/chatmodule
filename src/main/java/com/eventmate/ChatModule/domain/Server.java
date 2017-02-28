package com.eventmate.ChatModule.domain;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

import com.eventmate.ChatModule.service.ServerService;


public class Server {

	public static Map<Integer,ServerService> userMap;
	public static ServerSocket listener;
	
	public Server() throws IOException
	{
		listener = new ServerSocket(9999);
		userMap = new HashMap<Integer,ServerService>();
			int clientNumber=0;
		while(true)
		{
			ServerService serverService = new ServerService(listener.accept(),clientNumber);
			userMap.put(clientNumber,serverService);
			clientNumber++;
			serverService.start();
		}
	}
	
	public void closeServer() throws IOException
	{
		listener.close();
	}
	
	
}
