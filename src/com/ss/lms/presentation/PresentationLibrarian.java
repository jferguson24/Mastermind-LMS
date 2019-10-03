package com.ss.lms.presentation;

import java.util.Scanner;
import com.ss.lms.service.ServiceAdmin;

public class PresentationLibrarian {

	private static Scanner scanner;
	private ServiceAdmin service;

	public PresentationLibrarian() {
		service = new ServiceAdmin();
		scanner = new Scanner( System.in );
		librarianMenu();
	}
	//
	//Displays librarians choices and gets the user input
	public void librarianMenu() {
		while(true) {
			System.out.println("\n\nLibrarian Menu.");
			System.out.println("1. Enter a branch you manage");
			System.out.println("2. Quit to previous");
			String input = scanner.nextLine();
			boolean check = false;
			while (check == false) {
				switch(input) {
				case "1":
					//TODO service layer get branches
					branches();
					check = true;
					break;
				case "2":
					return;
				default:
					System.out.println("Enter a valid choice.");
				}
			}
		}
	}
	
	public void branches() {
		while(true) {
			System.out.println("1) Choose your branch:");
			//TODO getBranches function
			System.out.println("2) Enter your branch id:");
			String input = scanner.nextLine();
			boolean check = false;
			while (check == false) {
				switch(input) {
				case "1":
					check = true;
					break;
				case "2":
					check = true;
					break;
				case "i":
					check = true;
					return;
				default:
					System.out.println("Invalid Input.");
				}
			}
		}
	}
	//
	
	public void branchOptions() {
		while(true) {
			System.out.println("1) Update the details of the Library");
			System.out.println("2) Add copies of Book to the Branch");
			System.out.println("3) Quit to previous");
			String input = scanner.nextLine();
			boolean check = false;
			while (check == false) {
				switch(input) {
				case "1":
					//TODO call updateLibrary() function
					check = true;
					break;
				case "2":
					//TODO call addCopies() function
					check = true;
					break;
				case "3":
					return;
				}
			}
		}
	}
	
	
}
