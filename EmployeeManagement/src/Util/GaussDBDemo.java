package Util;

import java.sql.*;

public class GaussDBDemo{
static final String JDBC_DRIVER = "com.huawei.opengauss.jdbc.Driver";
static final String DB_URL = "jdbc:opengauss://110.41.126.115:8000/CQU_DB2021?ApplicationName=app1";
// 数据库的用户名与密码，需要根据自己的设置
static final String USER = "db_user2021_205";
static final String PASS = "db_user@123";
public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    try{
        // 注册 JDBC 驱动
        Class.forName(JDBC_DRIVER);
        // 打开链接
        System.out.println("连接数据库...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        // 执行查询
        System.out.println(" 实例化 Statement 对象...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT id, username, power FROM db_user2021_205.user";
        ResultSet rs = stmt.executeQuery(sql);
        // 展开结果集数据库
        while(rs.next()){
            // 通过字段检索
            Integer id = rs.getInt("id");
            String username = rs.getString("username");
            String power = rs.getString("power");
            // 输出数据
            System.out.print("ID: " + id);
            System.out.print(", 账号: " + username);
            System.out.print(", 权限: " + power);
            System.out.print("\n");
        }
        
        // 完成后关闭
        rs.close();
        stmt.close();
        conn.close();
    }catch(SQLException se){
        // 处理 JDBC 错误
        se.printStackTrace();
    }catch(Exception e){
        // 处理 Class.forName 错误
        e.printStackTrace();
    }finally{
        // 关闭资源
        try{
            if(stmt!=null) stmt.close();
        }catch(SQLException se2){
        }// 什么都不做
        try{
            if(conn!=null) conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
    System.out.println("Goodbye!");
    }
}
