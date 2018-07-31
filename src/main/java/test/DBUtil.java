package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getMSSQLCon(String host){
		try {
			if(host == null){
				host = "10.4.170.50";
			}
			String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			String url="jdbc:sqlserver://"+host+":1433;DatabaseName=BUA;dbusername=dbo";
			String user="sit";
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user,user);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Connection getCon(){
		try {
			String driver="oracle.jdbc.driver.OracleDriver";
			//String url="jdbc:oracle:thin:@10.21.200.161:1521:ORCL";
			String url = "jdbc:oracle:thin:@hq-t-oracledb.noahgrouptest.com.local:1521:uat";
			String user="ocuat";
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user,user);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void releaseCon(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		String host = null;
		if(args.length>0){
			host = args[0];
			System.out.println(host);
		}
		Connection con = DBUtil.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("select * from BUA_V_USER");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(host+" xxx "+rs.getString("USER_ID"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.releaseCon(con);
		}
		
	}
}
