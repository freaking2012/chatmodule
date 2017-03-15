package com.eventmate.ChatModule.utility;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import com.eventmate.ChatModule.domain.ServerDo;

public class ContextListener implements javax.servlet.ServletContextListener{

	ServerDo server;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		server = new ServerDo();
		
	}
	
		@Override
		public void contextDestroyed(ServletContextEvent arg0) {
			
			
		}


	
}
