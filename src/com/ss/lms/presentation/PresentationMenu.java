/**
 * 
 */
package com.ss.lms.presentation;


import java.util.Scanner;

/**
 * @author sj
 *
 */
public class PresentationMenu {
//
	/**
	 * @param args
	 */
    private static Scanner scanner = new Scanner( System.in );
    static PresentationLibrarian libMenu;
    static PresentationAdmin adminMenu;
    static PresentationBorrower borrowerMenu;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		startMenu();
	}
//
	public static void startMenu() {
		while(true) {
			System.out.println("Welcome to the GCIT Library Management System. Which category of a user are you?");
			System.out.println("1. Librarian");
			System.out.println("2. Administrator");
			System.out.println("3. Borrower");
			System.out.println("4. Quit");
			System.out.println("Enter your selection:");
			boolean check = false;
			while(check == false) {
				String input = scanner.nextLine();
				
				switch(input) {
				case "1":
					libMenu = new PresentationLibrarian();
					//libMenu.start();
					check = true;
					break;
				case "2":
					adminMenu = new PresentationAdmin();
					//adminMenu.start();
					check = true;
					break;
				case "3":
					borrowerMenu = new PresentationBorrower();
					//borrowerMenu.start();
					check = true;
					break;
				case "4":
					return;
				default:
					System.out.println("Enter a valid choice.");
				}
			}
		}
	}

}
