package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.User;

public class UserDao {
	public User login(Connection con,User user)throws Exception{
		User resultUser=null;
		String sql="select* from db_user2021_205.user where username=? and password=? and power=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getPower());
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()) {
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("username"));
			resultUser.setPassword(rs.getString("password"));
			resultUser.setPower(rs.getString("power"));
			
		}
		return resultUser;
	}
	
	//用户注册
	public int addUser(Connection con,User user)throws Exception{
		String sql="insert into db_user2021_205.user (username,password,power) values (?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, "员工");
		
		return pstmt.executeUpdate();
	}
	
}
