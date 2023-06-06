package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private String JDBC_DRIVER = "com.huawei.opengauss.jdbc.Driver";//驱动器名称
	private String DB_URL = "jdbc:opengauss://110.41.126.115:8000/CQU_DB2021?ApplicationName=app1";//数据库地址
	// 数据库的用户名与密码，需要根据自己的设置
	private String USER = "db_user2021_205";//用户名
	private String PASS = "db_user@123";//密码
	//获取数据库连接
	public Connection getCon()throws Exception{
		Class.forName(JDBC_DRIVER);
		Connection con=DriverManager.getConnection(DB_URL,USER,PASS);
		return con;
	}
	//关闭数据库
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	public static void main(String[] args) {
		DBUtil dbUtil=new DBUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	
	}
}
