package com.ss.lms.presentation;

import java.util.Scanner;

public class PresentationBorrower {

	private static Scanner scanner;

	public PresentationBorrower() {
		scanner = new Scanner( System.in );
		if(validate()) {
			BorrowerMenu();
		}
	}
	
	public boolean validate() {
			System.out.println("Enter your Card Number: ");
			if(scanner.hasNext()) {
			/*
			 * check database
			 * 
			 * if(scanner.nextInt() == )
			 * 		return true; 
			 * else
			 * 		System.out.println("Invalid Card Number");
			 * 	return false;
			 * */ 
				return true;
			}
			else 	
				return false;
	}
	
	//Displays librarians choices and gets the user input
	public void BorrowerMenu() {
		 
			boolean check = false;
			do{
				System.out.println("Welcome to the Library's Borrowing Menu.");
				System.out.println("1) Check out a Book");
				System.out.println("2) Return a Book");
				System.out.println("3) Quit to previous");
				
				if(scanner.hasNextInt()) {
					
					switch(scanner.nextInt()) {
						case 1:
						//TODO service layer get branches
							checkOut();
							check = true;
							break;
						case 2:
							
							returnBook();
							check = true;
							break;
						case 3:
							return;
						default:
							System.out.println("Enter a valid choice.");
					}
				}
				else {
					System.out.println("Invalid character");
				}
				
			}while (check == false);
	}
	
	public void checkOut() {
		System.out.println("Enter branch you wish to check out from");
		// branches()
	}
	public void returnBook() {
		System.out.println("Enter branch you wish to return book to");
		// branches
	}
	
	
}
	
	