package com.ss.lms.presentation;

import java.util.Scanner;

import com.ss.lms.service.ServiceAdmin;

public class PresentationAdmin 
{
	Scanner scanner;
	ServiceAdmin admin;
	
	public PresentationAdmin() 
	{
		scanner = new Scanner(System.in);
		admin = new ServiceAdmin();
		this.menu();
	}
	
	private void menu() 
	{
		do 
		{
			System.out.println("Select the operation you would like to do.");
			System.out.println("1. Create\n2. Read\n3. Update\n4. Delete\n0. Quit to previous");
			
			String operation = scanner.nextLine();
			String tableSelection = "";
			
			switch(operation) 
			{
			case "1":// CREATE operation
				selectTable();
				break;
			case "2": // READ operation
				selectTable();
				break;
			case "3": // UPDATE operation
				selectTable();
				break;
			case "4": // DELETE operation
				selectTable();
				break;
			case "5": // Return to user select
				selectTable();
				return;
			default:
				System.out.println("Invalid Input.");
			}
		}
		while(true);
	}
	
	private void selectTable() 
	{
		do 
		{
			System.out.println("Select the table you would like to do your operation on.");
			System.out.println("1. Authors\n2. Publishers\n3. Books\n4. Library Branch\n5. Borrower\n6. Book Loans\n0.Quit to previous");
			
			String targetTable = scanner.nextLine();
			
			switch(targetTable) 
			{
			case " 1": // Authors table
				break;
			case " 2": // Publishers table
				break;
			case " 3": // Books table
				break;
			case " 4": // Library Branches table
				break;
			case " 5": // Borrower table
				break;
			case " 6": // Book Loans table
				break;
			case " 7": // return to operation select
				return;
			}
			
			System.out.println("Invalid Input.");
			
		}while(true);
	}
}
