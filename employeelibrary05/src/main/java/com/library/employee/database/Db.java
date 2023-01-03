package com.library.employee.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db {

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeelibrary04", "root", "mysql"); 
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
