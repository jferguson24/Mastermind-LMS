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
		
		System.out.println("Choose your branch:");
		//TODO getBranches function
		System.out.println("Enter your branch id:");
	}
}
