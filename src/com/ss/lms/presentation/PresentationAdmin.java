package com.ss.lms.presentation;

import java.util.Scanner;

import com.ss.lms.entities.*;
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
		scanner.close();
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
				tableSelection = selectTable();
				
				switch(tableSelection) 
				{
				case " 1": // Authors table
					Integer authorId = null;
					String authorName = null;
					
					System.out.println("You selected ");
					System.out.println("Insert an author ID, or enter \"-1\" for all author IDs.");
					// get author Id field
					while(scanner.hasNext()) 
					{
						if(scanner.hasNextInt()) 
						{
							authorId = scanner.nextInt();
							break;
						}
						else
						{
							System.out.println("Author ID must be an integer");
						}
					}
					
					// TODO print library name.
					
					// get author name field
					System.out.println("Insert an author name, or enter \"N/A\" for all author IDs.");
					authorName = scanner.next();

					admin.createAuthor(new EntityAuthor(authorId, authorName));
					
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
				case " 0": // return to operation select
					continue;
				}
				break;
			case "2": // READ operation
				tableSelection = selectTable();
				
				switch(tableSelection) 
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
				case " 0": // return to operation select
					continue;
				}
				break;
			case "3": // UPDATE operation
				tableSelection = selectTable();
				
				switch(tableSelection) 
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
				case " 6": // Book Loans table TODO only update due date.
					break;
				case " 0": // return to operation select
					continue;
				}
				break;
			case "4": // DELETE operation
				tableSelection = selectTable();
				
				switch(tableSelection) 
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
				case " 0": // return to operation select
					continue;
				}
				break;
			case "0": // Return to user select
				tableSelection = selectTable();
				
				switch(tableSelection) 
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
				case " 0": // return to operation select
					continue;
				}
				return;
			default:
				System.out.println("Invalid Input.");
			}
		}
		while(true);
	}
	
	/*
	 * This function prompts the admin with all the tables in the db and returns their selection
	 * */
	
	private EntityLibraryBranch getEntityPublisher() 
	{
		EntityLibraryBranch userEntityPublisher = new EntityLibraryBranch();
		

		System.out.println("Insert an branch ID, or enter \"-1\" for all branch IDs.");
		while(scanner.hasNext()) 
		{
			if(scanner.hasNextInt()) 
			{
				userEntityPublisher.setBranchId(scanner.nextInt());
				break;
			}
			else
			{
				System.out.println("Branch ID must be an integer");
			}
		}
		
		System.out.println("Insert an branch name, or enter \"N/A\" for all branch names.");
		userEntityPublisher.setBranchName(scanner.nextLine());
		
		System.out.println("Insert an branch address, or enter \"N/A\" for all branch addresses.");
		userEntityPublisher.setBranchAddress(scanner.nextLine());
		
		return userEntityPublisher;
	}
	
	private EntityBook getEntityBook() 
	{
		EntityBook userEntityBook = new EntityBook();
		

		System.out.println("Insert an book ID, or enter \"-1\" for all book IDs.");
		while(scanner.hasNext()) 
		{
			if(scanner.hasNextInt()) 
			{
				userEntityBook.setBookId(scanner.nextInt());
				break;
			}
			else
			{
				System.out.println("Branch ID must be an integer");
			}
		}
		
		System.out.println("Insert an book name, or enter \"N/A\" for all book names.");
		userEntityBook.setBranchName(scanner.nextLine());
		
		System.out.println("Insert an branch address, or enter \"N/A\" for all branch addresses.");
		userEntityBook.setBranchAddress(scanner.nextLine());
		
		return userEntityBook;
	}
	
	
	private String selectTable() 
	{
		do 
		{
			System.out.println("Select the table you would like to do your operation on.");
			System.out.println("1. Authors\n2. Publishers\n3. Books\n4. Library Branch\n5. Borrower\n6. Book Loans\n0.Quit to previous");
			
			String targetTable = scanner.nextLine();
			
			switch(targetTable) 
			{
			case " 1": // Authors table
				return "1";
			case " 2": // Publishers table
				return "2";
			case " 3": // Books table
				return "3";
			case " 4": // Library Branches table
				return "4";
			case " 5": // Borrower table
				return "5";
			case " 6": // Book Loans table
				return "6";
			case " 0": // return to operation select
				return "0";
			}
			
			System.out.println("Invalid Input.");
			
		}while(true);
	}
}
