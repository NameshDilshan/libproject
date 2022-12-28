/**
 * 
 */
package com.library.student.datasource;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentlibrary", "root", "mysql");
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("select * from book");
//			while (rs.next())
//				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
//			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

}
