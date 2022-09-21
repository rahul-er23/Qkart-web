package com.qgroup.qkart.miniproject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginRegister {

	PreparedStatement pstate = null;
	ResultSet pro = null;
	ResultSet pro1 = null;
	Scanner s1 = new Scanner(System.in);
	Validation v = new Validation();
	String username2;
	String password2;

	DbConnect db = new DbConnect();
	Connection con = db.getConnectionDetails();

	public void register() {
		try {
			String username1 = v.usercheck();

			System.out.println("\nPlease Enter Password: ");
			String password = s1.next();

			System.out.println("\nPlease Enter Email-Id: ");
			String email = s1.next();

			System.out.println("\nPlease Enter Mobile Number: ");
			long mobno = s1.nextLong();

			System.out.println("\nPlease Enter City Name: ");
			String city = s1.next();

			pstate = con.prepareStatement(
					"INSERT INTO userdetails (UserName,Password,City,EmailId,PhNo)VALUES (?,?,?,?,?)");

			pstate.setString(1, username1);
			pstate.setString(2, password);
			pstate.setString(3, city);
			pstate.setString(4, email);
			pstate.setLong(5, mobno);
			int ch = pstate.executeUpdate();
			System.out.println("\n\t\t\tRegistration Successfully Completed.....\n\t	Please Login Now");
			// login();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public String loginCheck() {
				
		for(int i=1;i<=3;i++) {
		System.out.println("Enter Username: ");
		username2 = s1.next();

		System.out.println("Enter Password: ");
		password2 = s1.next();
		
		if(login(username2,password2)){
			break;
		}else {	
			System.out.println("Incorrect Username or Password, Please Try again!!!\n\n");	
			if(i==3) {
				System.exit(0);
			}
		}
		}
		return username2;	
	}
	
	
	public boolean login(String username,String password) {

		try {
			
			pstate = con.prepareStatement(
					"select UserName,Password from userdetails");
			pro = pstate.executeQuery();
			//System.out.println("passvalidate"+username2);
			while (pro.next()) {
				//user2=pro.getString(1);
				//pass2=pro.getString(2);
				
				if ((username.equals(pro.getString(1)))&& (password.equals(pro.getString(2)))) {
					System.out.println("\nLogin Successful");
					return true;
				}
			}
			
			pstate = con.prepareStatement("delete from cart;");
			int check = pstate.executeUpdate();
			// System.out.println("Delete successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}