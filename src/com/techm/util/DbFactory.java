package com.techm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbFactory {

	public static Connection getConnection() {
		Connection	con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
	con=DriverManager.getConnection("jdbc:oracle:thin:@172.16.156.152:1521:orcl","user3","techm123");
		return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
