package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Staff;

public class StaffDao {
	//基本信息录入
	public int add(Connection con,Staff staff)throws Exception{
		String sql="insert into db_user2021_205.staff_information (staff_name,staff_id,gender,departid,postid,phone) values(?,?,?,?,?,?)";//11个问号
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, staff.getStaff_name());
		pstmt.setString(2, staff.getStaff_id());
		pstmt.setString(3, staff.getGender());
		pstmt.setInt(4, staff.getDepartid());
		pstmt.setInt(5, staff.getPostid());
		pstmt.setString(6, staff.getPhone());
		return pstmt.executeUpdate();
	}
	
	
	//员工基本信息查询
	public ResultSet list(Connection con,Staff staff )throws Exception{
		StringBuffer strb=new StringBuffer("select * from db_user2021_205.staff_information si,department d,post p where si.departid=d.depart_id AND si.postid=p.post_id");
		if(staff.getStaff_name()!=null)
		{
			strb.append(" and si.staff_name like '%"+staff.getStaff_name()+"%'");
		}
		if(staff.getStaff_id()!=null)
		{
			strb.append(" and si.staff_id like '%"+staff.getStaff_id()+"%'");
		}
		if(staff.getDepartid()!=null&& staff.getDepartid()!=-1)
		{
			strb.append(" and si.departid ="+staff.getDepartid());
		}
		if(staff.getPostid()!=null&& staff.getPostid()!=-1)
		{
			strb.append(" and si.postid ="+staff.getPostid());
		}
		PreparedStatement pstmt=con.prepareStatement(strb.toString());
		return pstmt.executeQuery();
		}
	
	//员工信息删除
	public int delete(Connection con, String staff_id)throws Exception{
		String sql="delete from db_user2021_205.staff_information where staff_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, staff_id);
		return pstmt.executeUpdate();
	}
	
	//员工信息修改
	public int update(Connection con, Staff staff) throws Exception {
	    String sql = "UPDATE db_user2021_205.staff_information SET staff_name=?, staff_id=?, gender=?, departid=?, postid=?, phone=? WHERE id=?";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.setString(1, staff.getStaff_name());
	    pstmt.setString(2, staff.getStaff_id());
	    pstmt.setString(3, staff.getGender());
	    pstmt.setInt(4, staff.getDepartid());
	    pstmt.setInt(5, staff.getPostid());
	    pstmt.setString(6, staff.getPhone());
	    pstmt.setInt(7, staff.getId());
	    return pstmt.executeUpdate();
	}
	
}
