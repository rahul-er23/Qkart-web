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
			pstate = con.prepareStatement("select Quantity from productdetails where ProductID=" + p );
			//select Quantity from minip.productdetails where ProductID=101;

			pro=pstate.executeQuery();
			while (pro.next()) {
				check = pro.getInt(1);
			}
			if (check <= 0) {
				System.out.println("\nProduct Out Of Stock, Please Try Some Other Product");
			} else {
				cart(p);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cart(int p) {
		try {

			pstate = con.prepareStatement("insert into cart values (" + p + ")");
			// INSERT INTO minip.cart VALUES (104);
			int check1 = pstate.executeUpdate();

			System.out.println("Product Added to Cart");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buy(String uname) {

		try {
			// System.out.println("*******Your Product Details******");

			List<Integer> l = new ArrayList<Integer>();
			// l.add(111);
			pstate = con.prepareStatement("select Id from cart");
			pro = pstate.executeQuery();

			while (pro.next()) {
				l.add(pro.getInt(1));
			}
			//System.out.println(l);
			for (Integer i : l) {

				pstate = con.prepareStatement("insert into purchasedetails (UserId,UserName,EmailId,PhNo) "
						+ "select UserId,UserName,EmailId,PhNo from userdetails where UserName='" + uname + "'");

				int check = pstate.executeUpdate();
				//System.out.println("Insert " + check);

				pstate = con.prepareStatement("select max(Sr) from purchasedetails");
				pro = pstate.executeQuery();
				while (pro.next()) {
					i2 = pro.getInt(1);
					//System.out.println("got SR " + i2);
				}
				pstate = con.prepareStatement(
						"select Name,Price,ProductID,Category from productdetails where ProductID='" + i + "'");
				pro = pstate.executeQuery();
				//System.out.println("execute ");
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
				//System.out.println("update " + check1);

				pstate = con.prepareStatement("select Quantity from productdetails where ProductID='" + i + "'");
				pro = pstate.executeQuery();
				//System.out.println("got quantity ");
				while (pro.next()) {
					i1 = pro.getInt(1);
					//System.out.println("got quantity " + i1);
					i1 = i1 - 1;
				}

				// update minip.productdetails set Quantity=10 where ProductID=101;
				pstate = con.prepareStatement("update productdetails set Quantity=? where ProductID='" + i + "'");
				pstate.setInt(1, i1);
				int check2 = pstate.executeUpdate();
				//System.out.println("update quantity" + i1);

				pstate = con.prepareStatement("delete from cart;");
				int check3 = pstate.executeUpdate();
				//System.out.println("Delete successfully");

			}
			System.out.println("\n\nYour Order has been Placed Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void main(String[] args) { CartBuy ct = new CartBuy();
	 * 
	 * ct.cart(106); }
	 */

	public void buy1(String uname, int pid2) {

		try {

			pstate = con.prepareStatement("insert into purchasedetails (UserId,UserName,EmailId,PhNo) "
					+ "select UserId,UserName,EmailId,PhNo from userdetails where UserName='" + uname + "'");
			int check = pstate.executeUpdate();
			// System.out.println("Insert " + check);

			pstate = con.prepareStatement("select max(Sr) from purchasedetails");
			pro = pstate.executeQuery();
			while (pro.next()) {
				i2 = pro.getInt(1);
				// System.out.println("got SR " + i2);
			}

			pstate = con.prepareStatement(
					"select Name,Price,ProductID,Category from productdetails where ProductID='" + pid2 + "'");
			pro = pstate.executeQuery();
			// System.out.println("execute ");
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
			// System.out.println("update " + check1);

			pstate = con.prepareStatement("select Quantity from productdetails where ProductID='" + pid2 + "'");
			pro = pstate.executeQuery();
			// System.out.println("got quantity ");
			while (pro.next()) {
				i1 = pro.getInt(1);
				// System.out.println("got quantity "+i1);
				i1 = i1 - 1;
			}

			pstate = con.prepareStatement("update productdetails set Quantity=? where ProductID='" + pid2 + "'");
			pstate.setInt(1, i1);
			int check2 = pstate.executeUpdate();
			// System.out.println("update quantity" + i1);

			pstate = con.prepareStatement("delete from cart;");
			int check3 = pstate.executeUpdate();
			// System.out.println("Delete successfully");

			System.out.println("\n\nYour Order has been Placed Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}