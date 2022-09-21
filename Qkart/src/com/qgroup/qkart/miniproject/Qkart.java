package com.qgroup.qkart.miniproject;

import java.util.Scanner;

public class Qkart {
	private static int cat;
	public static String uname;
	static Scanner s = new Scanner(System.in);
	static CartBuy cb = new CartBuy();// create object of a class having cart and buy method
	static Admin a = new Admin();
	public static int productid;

	public static void main(String[] args) {
		System.out.println("welcome to GIT part");
		Qkart.t1();
		Qkart.t2();
		Qkart.t3();
		Qkart.t4();
		s.close();
	}

	public static void t1() {
		try {
			System.out.println("\t\t\t*****   Hello, Welcome to Qkart   *****\n\n");
			System.out.println("\t\t\t\t\tPlease Select....\n\t\t 1.Login\t\t 2.Register\t\t 3.Admin");// user input
																										// login
																										// or
																										// registration
			cat = s.nextInt();

			if (cat == 1) {
				uname = cb.loginCheck();

			} else if (cat == 2) {
				System.out.println("\n\t.............Please provide below details to Register...............");
				cb.register();
				uname = cb.loginCheck();
			} else if (cat == 3) {
				a.adminLogin();
				// call admin method or class
			} else {
				System.out.println("\nPlease Try Again");
				System.exit(0);
				//Qkart.t1();
			}
		} catch (Exception e) {
			System.out.println("Pleaes Enter Correct Input and Try Again");
			System.exit(0);
		}

	}

	public static void t2() {
		try {
			System.out.println(
					"\nSelect Categories to Explore... \n" + "1. Mobiles \n2. Sports \n3. Camera \n4. Smart Watches");
			int cat = s.nextInt();
			if (cat == 1 || cat == 2 || cat == 3 || cat == 4) {
				cb.allProduct(cat);// call method

				System.out.println("\n\nPlease Enter Product ID to see the Product Details... ");// ask user if he want
																									// to
																									// see
																									// the product in
																									// details
				cat = s.nextInt();// taking user input
				int pid = cb.singleProduct(cat);// calling single product detail method to show product on screen
				productid = pid;
			} else {
				System.out.println("\nTry Again with Enter Correct Input");
				//Qkart.t1();
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Pleaes Enter Correct Input and Try Again");
			//Qkart.t1();
			System.exit(0);
		}
	}

	public static void t3() {
		try {
			System.out.println(
					"\n\nPlease Press... 	\n	1.Continue Shopping \n	2. Add to Cart \n	3. Buy Now \n	4. Back");
			cat = s.nextInt();// taking user input
			if (cat == 1) {
				Qkart.t1();
			} else if (cat == 2) {
				cb.checkQue(productid);
				Qkart.t5();
			} else if (cat == 3) {
				cb.buy1(uname, productid);
			} else if (cat == 4) {
				Qkart.t2();
				Qkart.t3();
			} else {
				System.out.println("\nPlease Try with Correct Input");
				System.exit(0);
				//Qkart.t3();
			}
		} catch (Exception e) {
			System.out.println("Pleaes Enter Correct Input and Try Again");
			//Qkart.t3();
			System.exit(0);
		}
	}

	public static void t4() {
		try {
			System.out.println("\nDo you Want to Continue Shopping...\n 1. Yes \n 2. No");
			cat = s.nextInt();
			if (cat == 1) {
				Qkart.t2();
				Qkart.t3();
			} else if (cat == 2) {

				System.out.println("\nThanks for Shopping");
				System.exit(0);
			} else {
				System.out.println("\nPlease Try Again");
				System.exit(0);
				//Qkart.t5();
			}
		} catch (Exception e) {
			System.out.println("Pleaes Enter Correct Input and Try Again");
			//Qkart.t4();
			System.exit(0);
		}
	}

	public static void t5() {
		try {
			System.out.println("\nDo you Want to Continue Shopping...\n 1. Yes \n 2. No");
			cat = s.nextInt();
			if (cat == 1) {
				Qkart.t2();
				Qkart.t3();
			} else {
				cb.buy(uname);
				System.out.println("\nThanks for Shopping");
				System.exit(0);
			}

		} catch (Exception e) {
			System.out.println("Pleaes Enter Correct Input and Try Again");
			//Qkart.t2();
			System.exit(0);
		}
	}
}
