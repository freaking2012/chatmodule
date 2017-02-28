package com.eventmate.ChatModule.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.eventmate.ChatModule.dao.UserDao;
import com.eventmate.ChatModule.domain.UserDo;

@Path("/")
public class ChatController {

	UserDao userDao = new UserDao();
	
	@POST
	@Path("/user")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UserDo addUser(UserDo userDo) {
		System.out.println("creating user with name: "+userDo.getName()+" and emailId: "+userDo.getEmailId());
		return userDao.addUser(userDo);
	}
	
	@POST
	@Path("/login")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public UserDo login(UserDo userDo)
	{
		System.out.println("Got User with email id: "+userDo.getEmailId());
		UserDo dbUserDo = userDao.getUserDoByEmailIdAndPassword(userDo);
		return dbUserDo;
	}
	
	
	
	
	/*@GET @Path("{emailId}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UserDo findById(@PathParam("emailId") String emailId) {
		System.out.println("findByEmailId " + emailId);
		return null;
	}*/
}
