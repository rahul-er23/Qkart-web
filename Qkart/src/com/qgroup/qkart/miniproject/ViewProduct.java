package com.qgroup.qkart.miniproject;

public class ViewProduct extends LoginRegister {

	public void allProduct(int id) {
		System.out.println("\nAll Product");

		try {
			if (id == 1) {
				pstate = con.prepareStatement("select * from productdetails where Category ='Mobiles'");
			} else if (id == 2) {
				pstate = con.prepareStatement("select * from productdetails where Category ='Sports'");
			} else if (id == 3) {
				pstate = con.prepareStatement("select * from productdetails where Category ='Camera'");
			} else if (id == 4) {
				pstate = con.prepareStatement("select * from productdetails where Category ='Smart Watches'");
			} else {
				System.out.println("Invalid input");
			}

			pro = pstate.executeQuery();
			while (pro.next()) {
				System.out.println("\nProduct ID: " + pro.getInt(1) + "\nName: " + pro.getString(3) + "\nPrice: "
						+ pro.getString(4));
				System.out.println(
						"=========================================================================================");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int singleProduct(int id) {

		try {
			pstate = con.prepareStatement("select * from productdetails where ProductID=" + id);
			pro = pstate.executeQuery();
			System.out.printf("%-12s%-30s%-35s%-18s%-15s\n\n","User ID","Product Name","Discription","Price","Available Quantity");
			while (pro.next()) {
			System.out.printf("%-12s%-30.30s%-35.30s%-18s%-15s\n",pro.getInt(1),pro.getString(3),pro.getString(2),pro.getString(4),pro.getString(5));
				//System.out.println("\nProduct ID: " + pro.getInt(1) + "\nName: " + pro.getString(3) + "\nDescription: "
					//	+ pro.getString(2) + "\nPrice: " + pro.getString(4) + "\nAvailable Quantity: " + pro.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// finally{
		// return id;
		// }
		return id;
	}
}
