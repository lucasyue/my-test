package test.sqllite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Testor {
	public static void main(String[] args) {
		try {
			testSqlite();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void testSqlite() throws ClassNotFoundException {
		// load the sqlite-JDBC driver using the current class loader
		Class.forName("org.sqlite.JDBC");
		Connection connection = null;
		try {
			// create a database connection
			// connection =
			// DriverManager.getConnection("jdbc:sqlite:sample.db");
			// F:\projects\zhongwaiyun
			connection = DriverManager
					.getConnection("jdbc:sqlite:F:/projects/zhongwaiyun/settings.db");
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.
			ResultSet rs = statement
					.executeQuery("select * from sftpconnector_files");
			while (rs.next()) {
				// read the result set
				System.out.println("status = " + rs.getString("status"));
				System.out.println("filename = " + rs.getString("filename"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// connection close failed.
				System.err.println(e);
			}
		}
	}

}
