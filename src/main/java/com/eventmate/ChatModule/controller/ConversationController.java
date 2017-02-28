package com.eventmate.ChatModule.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.eventmate.ChatModule.dao.UserDao;
import com.eventmate.ChatModule.domain.ConversationDo;
import com.eventmate.ChatModule.domain.UserDo;

@Path("/converse")
public class ConversationController {

	UserDao userDao = new UserDao();
	
	@GET @Path("currentuser/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public UserDo getUserDoById(@PathParam("id") Integer id) {
		System.out.println("getUserDoById " + id);
		return userDao.getUserDoById(id);
	}
	
	@GET @Path("otherusers/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<UserDo> getOtherUsers(@PathParam("id") Integer id) {
		System.out.println("getUserDo where id not equal to: " + id);
		return userDao.getOtherUsers(id);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void sendMessage(ConversationDo conversationDo) {
		System.out.println("creating wine");
		//conversationService.sendMessage(conversationDo.getMessage(),conversationDo.getCurrentUser(),conversationDo.getOtherUsers());
	}
}
