package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Post;

public class PostDao {
	//岗位添加
	public int add(Connection con,Post post)throws Exception{
		String sql="Insert into db_user2021_205.post (post_name,post_salary) values(?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, post.getPost_name());
		pstmt.setString(2, post.getPost_salary());
		return pstmt.executeUpdate();
	}
	
	
	//查询岗位
	public ResultSet list(Connection con,Post post)throws Exception{
		StringBuffer stub=new StringBuffer("select* from db_user2021_205.post");
		if(post.getPost_name()!=null){
			stub.append(" and post_name like '%"+post.getPost_name()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(stub.toString().replace("and", "where"));
		return pstmt.executeQuery();
	}
	
	//删除岗位
	public int delete(Connection con,String post_id)throws Exception{
		String sql="delete from db_user2021_205.post where post_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, post_id);
		return pstmt.executeUpdate();
	}
		
	//修改岗位
	public int update(Connection con,Post post)throws Exception{
		String sql="update db_user2021_205.post set post_name=?,post_salary=? where post_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, post.getPost_name());
		pstmt.setString(2,post.getPost_salary());
		pstmt.setInt(3, post.getPost_id());
		return pstmt.executeUpdate();
	}
}
