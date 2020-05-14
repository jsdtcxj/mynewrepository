package com.chs.springboot.springTransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
			// here sonoo is database name, root is username and password
			String sql = "INSERT INTO customer " + "VALUES (1, 'Tom')";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			
			sql = "INSERT INTO customer " + "VALUES (2, 'This is not allowed by now, try later!!!')";
			stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
