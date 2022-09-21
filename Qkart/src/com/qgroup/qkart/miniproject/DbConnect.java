package com.qgroup.qkart.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {	

		Connection con = null;

		public Connection getConnectionDetails() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minip", "root", "PassWord@23");
			} catch (Exception e) {
				System.out.println("Please check MySql Connection");
			}
			return con;
		}
	}
