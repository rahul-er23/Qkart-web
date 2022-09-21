package com.qgroup.qkart.miniproject;

import java.util.ArrayList;
import java.util.List;

public class CartBuy extends ViewProduct {

	String s2;
	String s3;
	int check;
	int i3;
	int i2;
	int i1;
	String s4;

	public void checkQue(int p) {

		try {
			pstate = con.prepareStatement("select Quantity from productdetails where ProductID=" + p);
			pro = pstate.executeQuery();
			while (pro.next()) {
				check = pro.getInt(1);
			}
			if (check <= 0) {
				System.out.println("\nProduct Out Of Stock, Please Try Some Other Product");
			} else {
				cart(p);
			}
		} catch (Exception e) {
			System.out.println("Unexpected Input provided, Please Try Again");
			System.exit(0);
		}
	}

	public void cart(int p) {
		try {

			pstate = con.prepareStatement("insert into cart values (" + p + ")");
			int check1 = pstate.executeUpdate();

			System.out.println("Product Added to Cart");
		} catch (Exception e) {
			System.out.println("Unexpected Input provided, Please Try Again");
			System.exit(0);
		}
	}

	public void buy(String uname) {

		try {
			List<Integer> l = new ArrayList<Integer>();
			pstate = con.prepareStatement("select Id from cart");
			pro = pstate.executeQuery();

			while (pro.next()) {
				l.add(pro.getInt(1));
			}
			for (Integer i : l) {

				pstate = con.prepareStatement("insert into purchasedetails (UserId,UserName,EmailId,PhNo) "
						+ "select UserId,UserName,EmailId,PhNo from userdetails where UserName='" + uname + "'");
				int check = pstate.executeUpdate();

				pstate = con.prepareStatement("select max(Sr) from purchasedetails");
				pro = pstate.executeQuery();
				while (pro.next()) {
					i2 = pro.getInt(1);
				}

				pstate = con.prepareStatement(
						"select Name,Price,ProductID,Category from productdetails where ProductID='" + i + "'");
				pro = pstate.executeQuery();
				while (pro.next()) {
					s2 = pro.getString(1);
					s3 = pro.getString(2);
					i3 = pro.getInt(3);
					s4 = pro.getString(4);
				}

				pstate = con.prepareStatement(
						"update purchasedetails set Name=?,Price=?,ProductID=?,Category=? where Sr='" + i2 + "'");
				pstate.setString(1, s2);
				pstate.setString(2, s3);
				pstate.setInt(3, i3);
				pstate.setString(4, s4);
				int check1 = pstate.executeUpdate();

				pstate = con.prepareStatement("select Quantity from productdetails where ProductID='" + i + "'");
				pro = pstate.executeQuery();
				while (pro.next()) {
					i1 = pro.getInt(1);
					i1 = i1 - 1;
				}

				pstate = con.prepareStatement("update productdetails set Quantity=? where ProductID='" + i + "'");
				pstate.setInt(1, i1);
				int check2 = pstate.executeUpdate();

				pstate = con.prepareStatement("delete from cart;");
				int check3 = pstate.executeUpdate();

			}
			System.out.println("\n\nYour Order has been Placed Successfully");
		} catch (Exception e) {
			System.out.println("Unexpected Input provided, Please Try Again");
			System.exit(0);
		}
	}

	public void buy1(String uname, int pid2) {

		try {
			pstate = con.prepareStatement("insert into purchasedetails (UserId,UserName,EmailId,PhNo) "
					+ "select UserId,UserName,EmailId,PhNo from userdetails where UserName='" + uname + "'");
			int check = pstate.executeUpdate();

			pstate = con.prepareStatement("select max(Sr) from purchasedetails");
			pro = pstate.executeQuery();
			while (pro.next()) {
				i2 = pro.getInt(1);
			}

			pstate = con.prepareStatement(
					"select Name,Price,ProductID,Category from productdetails where ProductID='" + pid2 + "'");
			pro = pstate.executeQuery();
			while (pro.next()) {
				s2 = pro.getString(1);
				s3 = pro.getString(2);
				i3 = pro.getInt(3);
				s4 = pro.getString(4);
			}

			pstate = con.prepareStatement(
					"update purchasedetails set Name=?,Price=?,ProductID=?,Category=? where Sr='" + i2 + "'");
			pstate.setString(1, s2);
			pstate.setString(2, s3);
			pstate.setInt(3, i3);
			pstate.setString(4, s4);
			int check1 = pstate.executeUpdate();

			pstate = con.prepareStatement("select Quantity from productdetails where ProductID='" + pid2 + "'");
			pro = pstate.executeQuery();
			while (pro.next()) {
				i1 = pro.getInt(1);
				i1 = i1 - 1;
			}

			pstate = con.prepareStatement("update productdetails set Quantity=? where ProductID='" + pid2 + "'");
			pstate.setInt(1, i1);
			int check2 = pstate.executeUpdate();

			pstate = con.prepareStatement("delete from cart;");
			int check3 = pstate.executeUpdate();

			System.out.println("\n\nYour Order has been Placed Successfully");
		} catch (Exception e) {
			System.out.println("Unexpected Input provided, Please Try Again");
			System.exit(0);
		}
	}
}