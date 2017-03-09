package com.eventmate.ChatModule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eventmate.ChatModule.domain.UserDo;
import com.eventmate.ChatModule.utility.ConnectionHelper;

public class UserDao {
	
	 public UserDo getUserDoByEmailIdAndPassword(UserDo userDo) {
	    	String sql = "SELECT * FROM useraccount WHERE email_id = ? and password = ?";
	        UserDo dbUserDo = null;
	        Connection c = null;
	        try {
	            c = ConnectionHelper.getPostGreConnection();
	            PreparedStatement ps = c.prepareStatement(sql);
	            ps.setString(1, userDo.getEmailId());
	            ps.setString(2, userDo.getPassword());
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	            	dbUserDo = processRow(rs);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return dbUserDo;
	    }
	 
	 public UserDo getUserDoById(Integer id) {
		 String sql = "SELECT * FROM useraccount WHERE id = ?";
		 UserDo dbUserDo = null;
		 Connection c = null;
		 try {
			 c = ConnectionHelper.getPostGreConnection();
			 PreparedStatement ps = c.prepareStatement(sql);
			 ps.setInt(1, id);
			 ResultSet rs = ps.executeQuery();
			 if (rs.next()) {
				 dbUserDo = processRow(rs);
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new RuntimeException(e);
		 } finally {
			 ConnectionHelper.close(c);
		 }
		 return dbUserDo;
	 }
	 
	 public List<UserDo> getOtherUsers(Integer id) {
	        List<UserDo> list = new ArrayList<UserDo>();
	        Connection c = null;
	    	String sql = "SELECT * FROM useraccount WHERE id != ? ORDER BY name";
	        try {
	            c = ConnectionHelper.getPostGreConnection();
	            PreparedStatement ps = c.prepareStatement(sql);
				 ps.setInt(1, id);
				 ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(processRow(rs));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return list;
	    }
	
	 public UserDo addUser(UserDo userDo) {
	        Connection c = null;
	        PreparedStatement ps = null;
	        try {
	            c = ConnectionHelper.getPostGreConnection();
	            ps = c.prepareStatement("INSERT INTO useraccount (name, email_id,password, phone_number,is_logged_in) VALUES ( ?,?, ?, ?,?)",
	                new String[] { "id" });
	            ps.setString(1, userDo.getName());
	            ps.setString(2, userDo.getEmailId());
	            ps.setString(3, userDo.getPassword());
	            ps.setString(4, userDo.getPhoneNumber());
	            ps.setInt(5, userDo.isLoggedIn());
	            ps.executeUpdate();
	            ResultSet rs = ps.getGeneratedKeys();
	            rs.next();
	            // Update the id in the returned object. This is important as this value must be returned to the client.
	            int id = rs.getInt(1);
	            userDo.setId(id);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return userDo;
	    }
	
	protected UserDo processRow(ResultSet rs) throws SQLException {
		UserDo userDo = new UserDo();
        userDo.setId(rs.getInt("id"));
        userDo.setName(rs.getString("name"));
        userDo.setEmailId(rs.getString("email_id"));
        userDo.setPhoneNumber(rs.getString("phone_number"));
        return userDo;
    }
	
}
