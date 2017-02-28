package com.eventmate.ChatModule.utility;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import com.eventmate.ChatModule.domain.Server;

public class ContextListener implements javax.servlet.ServletContextListener{

	Server server;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			server = new Server();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		@Override
		public void contextDestroyed(ServletContextEvent arg0) {
			try {
				server.closeServer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}


	
}
