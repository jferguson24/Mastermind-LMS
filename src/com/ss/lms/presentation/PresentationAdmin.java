package com.ss.lms.presentation;

import java.util.Scanner;

import com.ss.lms.entities.*;
import com.ss.lms.service.ServiceAdmin;

import java.sql.Date;

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
		// empty the buffer before any input from the user, 
		// then a check is performed to see if they entered "quit"
		// use a setter to the Entity being populated
		StringBuffer allStringInput = new StringBuffer();
		Integer allIntegerInput;
		
		do 
		{
			String operation = "";
			String tableSelection = "";
			
			System.out.println("Select the operation you would like to do.");
			System.out.println("1. Create\n2. Read\n3. Update\n4. Delete\n0. Quit to user selection");
			
			operation = getNextLine();
			
			switch(operation) 
			{
			case "1":// CREATE operation
				System.out.println("Create operation selected.");
				tableSelection = selectTable();
				
				switch(tableSelection) 
				{
				case "1": // Authors table
					System.out.println("Authors table selected");
					EntityAuthor userAuthor = createEntityAuthor("Note: Enter \"-1\" for automatic primary key generation.");
					
					// the user quit somewhere in the process
					if(userAuthor == null) 
					{
						break;
					}
					
					// TODO consider returning a boolean to let the user know the operation was successful or not
					// create entity
					admin.createAuthor(userAuthor);
					break;
					
				case "2": // Publishers table
					System.out.println("Publishers table selected");
					
					EntityPublisher userPublisher = createEntityPublisher("Note: Enter \"-1\" for automatic primary key generation.");

					// the user quit somewhere in the process
					if(userPublisher == null) 
					{
						break;
					}

					// TODO consider returning a boolean to let the user know the operation was successful or not
					// create entity
					admin.createPublisher(userPublisher);
					break;
					
				case "3": // Books table
					System.out.println("Books table selected");
					
					EntityBook userBook = createEntityBook("Note: Enter \"-1\" for automatic primary key generation.");
					
					// the user quit somewhere in the process
					if(userBook == null) 
					{
						break;
					}
					
					// TODO consider returning a boolean to let the user know the operation was successful or not
					// create entity
					admin.createBook(userBook);
					break;
				case "4": // Library Branches table
					System.out.println("Library Branches table selected");
					EntityLibraryBranch userLibraryBranch = createEntityLibraryBranch("Note: Enter \"-1\" for automatic primary key generation.");
					
					// the user quit somewhere in the process
					if(userLibraryBranch == null) 
					{
						break;
					}
					
					// TODO consider returning a boolean to let the user know the operation was successful or not
					// create entity
					admin.createLibraryBranch(userLibraryBranch);
					break;
					
				case "5": // Borrower table
					System.out.println("Borrowers table selected");
					EntityBorrower userBorrower= createEntityBorrower("Note: Enter \"-1\" for automatic primary key generation.");
					
					// the user quit somewhere in the process
					if(userBorrower == null) 
					{
						break;
					}

					// TODO consider returning a boolean to let the user know the operation was successful or not
					// create entity
					admin.createBorrower(userBorrower);
					break;
					
				case "6": // Book Loans table
					System.out.println("Book Loans table selected");
					System.out.println("Admin cannot create a Book Loan.\nQuitting to table selection");
					break;
					
				case "0": // return to operation select
					break;
				}
				break; // once operation is done, return to operation select
				
			case "2": // READ operation
				System.out.println("Read operation selected.");
				tableSelection = selectTable();
				
				switch(tableSelection) 
				{
				case "1": // Authors table
					System.out.println("Authors table selected");
					EntityAuthor userAuthor = createEntityAuthor("Note: Enter N/A if you aren't concerned with the value of a field");
					
					// the user quit somewhere in the process
					if(userAuthor == null) 
					{
						break;
					}
					
					admin.updateAuthor(userAuthor);
					
					break;
				case "2": // Publishers table
					break;
				case "3": // Books table
					break;
				case "4": // Library Branches table
					break;
				case "5": // Borrower table
					break;
				case "6": // Book Loans table
					break;
				case "0": // return to operation select
					continue;
				}
				break;
			case "3": // UPDATE operation
				System.out.println("Update operation selected.");
				tableSelection = selectTable();
				
				switch(tableSelection) 
				{
				case "1": // Authors table
					break;
				case "2": // Publishers table
					break;
				case "3": // Books table
					break;
				case "4": // Library Branches table
					break;
				case "5": // Borrower table
					break;
				case "6": // Book Loans table TODO only update due date.
					break;
				case "0": // return to operation select
					continue;
				}
				break;
			case "4": // DELETE operation
				System.out.println("Delete operation selected.");
				tableSelection = selectTable();
				
				switch(tableSelection) 
				{
				case "1": // Authors table
					break;
				case "2": // Publishers table
					break;
				case "3": // Books table
					break;
				case "4": // Library Branches table
					break;
				case "5": // Borrower table
					break;
				case "6": // Book Loans table
					break;
				case "0": // return to operation select
					continue;
				}
				break;
			case "0": // Return to user select
				return;
			}
		}
		while(true);
	}
	
	// TODO document these functions properly
	private EntityAuthor createEntityAuthor(String note) 
	{
		EntityAuthor userAuthor = new EntityAuthor();
		StringBuffer allStringInput = new StringBuffer();
		Integer allIntegerInput;
		
		System.out.println("\n" + note);
		// Getting ID
		allIntegerInput = getIntegerFieldFromUser("Author ID");
		if(allIntegerInput == Integer.MIN_VALUE) 
		{
			return null; 
		}
		userAuthor.setAuthorId(allIntegerInput);
		
		// Getting name
		allStringInput.setLength(0); // empty the buffer before input
		allStringInput.append(getStringFieldFromUser("Author Name"));
		if("quit".equals(allStringInput.toString())) 
		{
			return null;
		}
		userAuthor.setAuthorName(allStringInput.toString());
		
		return userAuthor;
	}
	
	private EntityPublisher createEntityPublisher(String note) 
	{
		EntityPublisher userPublisher = new EntityPublisher();
		StringBuffer allStringInput = new StringBuffer();
		Integer allIntegerInput;

		System.out.println("\n" + note);
		// Getting ID
		allIntegerInput = getIntegerFieldFromUser("Publisher ID");
		if(allIntegerInput == Integer.MIN_VALUE) 
		{
			return null;
		}
		userPublisher.setPublisherId(allIntegerInput);
		
		// Getting name
		allStringInput.setLength(0); // empty the buffer before input
		allStringInput.append(getStringFieldFromUser("Publisher Name"));
		if("quit".equals(allStringInput.toString())) 
		{
			return null;
		}
		userPublisher.setPublisherName(allStringInput.toString());
		
		// Getting Address
		allStringInput.setLength(0); // empty the buffer before input
		allStringInput.append(getStringFieldFromUser("Publisher Address"));
		if("quit".equals(allStringInput.toString())) 
		{
			return null;
		}
		userPublisher.setPublisherAddress(allStringInput.toString());
		
		// Getting Phone
		allStringInput.setLength(0); // empty the buffer before input
		allStringInput.append(getStringFieldFromUser("Publisher Phone"));
		if("quit".equals(allStringInput.toString())) 
		{
			return null;
		}
		userPublisher.setPublisherPhone(allStringInput.toString());
		
		return userPublisher;
	}
	
	private EntityBook createEntityBook(String note) 
	{
		EntityBook userBook = new EntityBook();
		StringBuffer allStringInput = new StringBuffer();
		Integer allIntegerInput;
		
		System.out.println("\n" + note);
		// Getting ID
		allIntegerInput = getIntegerFieldFromUser("Book ID");
		if(allIntegerInput == Integer.MIN_VALUE) 
		{
			return null;
		}
		userBook.setBookId(allIntegerInput);
		
		// Getting name
		allStringInput.setLength(0); // empty the buffer before input
		allStringInput.append(getStringFieldFromUser("Book Name"));
		if("quit".equals(allStringInput.toString())) 
		{
			return null;
		}
		userBook.setTitle(allStringInput.toString());
		
		// Getting author ID
		allIntegerInput = getIntegerFieldFromUser("Author ID");
		if(allIntegerInput == Integer.MIN_VALUE) 
		{
			return null;
		}
		userBook.setAuthorId(allIntegerInput);
		
		// Getting publisher ID
		allIntegerInput = getIntegerFieldFromUser("Publisher ID");
		if(allIntegerInput == Integer.MIN_VALUE) 
		{
			return null;
		}
		userBook.setPubisherId(allIntegerInput);
		
		return userBook;
	}
	
	private EntityLibraryBranch createEntityLibraryBranch(String note) 
	{
		EntityLibraryBranch userLibraryBranch = new EntityLibraryBranch();
		StringBuffer allStringInput = new StringBuffer();
		Integer allIntegerInput;
		
		System.out.println("\n" + note);
		// Getting ID
		allIntegerInput = getIntegerFieldFromUser("Library Branch ID");
		if(allIntegerInput == Integer.MIN_VALUE) 
		{
			return null;
		}
		userLibraryBranch.setBranchId(allIntegerInput);
		
		// Getting name
		allStringInput.setLength(0); // empty the buffer before input
		allStringInput.append(getStringFieldFromUser("Library Branch Name"));
		if("quit".equals(allStringInput.toString())) 
		{
			return null;
		}
		userLibraryBranch.setBranchName(allStringInput.toString());
		
		// Getting address
		allStringInput.setLength(0); // empty the buffer before input
		allStringInput.append(getStringFieldFromUser("Library Branch Address"));
		if("quit".equals(allStringInput.toString())) 
		{
			return null;
		}
		userLibraryBranch.setBranchAddress(allStringInput.toString());
		
		return userLibraryBranch;
	}

	private EntityBorrower createEntityBorrower(String note) 
	{
		EntityBorrower userBorrower= new EntityBorrower();
		StringBuffer allStringInput = new StringBuffer();
		Integer allIntegerInput;
		
		System.out.println("/n" + note);
		// Getting ID
		System.out.println("Note: Enter \"-1\" for automatic primary key generation.");
		allIntegerInput = getIntegerFieldFromUser("Borrower Card Number");
		if(allIntegerInput == Integer.MIN_VALUE) 
		{
			return null;
		}
		userBorrower.setCardNo(allIntegerInput);
		
		// Getting name
		allStringInput.setLength(0); // empty the buffer before input
		allStringInput.append(getStringFieldFromUser("Borrower Name"));
		if("quit".equals(allStringInput.toString())) 
		{
			return null;
		}
		userBorrower.setName(allStringInput.toString());
		
		// Getting address
		allStringInput.setLength(0); // empty the buffer before input
		allStringInput.append(getStringFieldFromUser("Borrower Address"));
		if("quit".equals(allStringInput.toString())) 
		{
			return null;
		}
		userBorrower.setAddress(allStringInput.toString());
		
		// Getting phone number
		allStringInput.setLength(0); // empty the buffer before input
		allStringInput.append(getStringFieldFromUser("Borrower Phone Number"));
		if("quit".equals(allStringInput.toString())) 
		{
			return null;
		}
		userBorrower.setPhone(allStringInput.toString());
		
		return userBorrower;
	}
	
	private EntityBookLoan createEntityBookLoan(String note) 
	{
		EntityBookLoan userBookLoan = new EntityBookLoan();
		StringBuffer allStringInput = new StringBuffer();
		Integer allIntegerInput;
		
		System.out.println("\n" + note);
		// Getting book ID
		allIntegerInput = getIntegerFieldFromUser("Book ID");
		if(allIntegerInput == Integer.MIN_VALUE) 
		{
			return null;
		}
		userBookLoan.setBookId(allIntegerInput);
		
		// Getting Branch ID
		allIntegerInput = getIntegerFieldFromUser("Branch ID");
		if(allIntegerInput == Integer.MIN_VALUE) 
		{
			return null;
		}
		userBookLoan.setBranchId(allIntegerInput);
		
		// Getting card number
		allIntegerInput = getIntegerFieldFromUser("Card Number");
		if(allIntegerInput == Integer.MIN_VALUE) 
		{
			return null;
		}
		userBookLoan.setCardNo(allIntegerInput);
		
		// cannot change dateOut
		// TODO properly handle not changing the date
//		userBookLoan.setDateOut(java.sql.Date.);
		
		// Getting due date
		allStringInput.setLength(0); // empty the buffer before input
		allStringInput.append(getStringFieldFromUser("Due Date (YYYY-MM-DD)"));
		if("quit".equals(allStringInput.toString())) 
		{
			return null;
		}
		// TODO proper date input checking
		userBookLoan.setDueDate(Date.valueOf(allStringInput.toString()));
		
		return userBookLoan;
	}
	
	/*
	 * This function is for getting Integer values for entity fields
	 * */
	private Integer getIntegerFieldFromUser(String fieldName) 
	{
		System.out.println("Insert data for " + fieldName + ":");
		while(true) 
		{
			if(scanner.hasNextInt()) 
			{
				return scanner.nextInt();
			}
			else if("quit".equals(scanner.next())) 
			{
				return Integer.MIN_VALUE;
			}
			else
			{
				System.out.println("Publisher ID must be an integer");
			}
		}
	}
	
	/*
	 * This function is for getting String values for entity fields
	 * */
	private String getStringFieldFromUser(String fieldName) 
	{
		System.out.println("Insert data for " + fieldName + ". Enter \"quit\" to go back to operation screen");
		do
		{
			return getNextLine();
		}
		while(scanner.hasNextLine());
	}
	
	/*
	 * This function prompts the admin with all the tables in the db and returns their selection
	 * */
	private String selectTable() 
	{
		do 
		{
			System.out.println("Select the table you would like to do your operation on.");
			System.out.println("1. Authors\n2. Publishers\n3. Books\n4. Library Branch\n5. Borrower\n6. Book Loans\n0. Quit to previous");
			
			String targetTable = getNextLine();
			
			switch(targetTable) 
			{
			case "1": // Authors table
				return "1";
			case "2": // Publishers table
				return "2";
			case "3": // Books table
				return "3";
			case "4": // Library Branches table
				return "4";
			case "5": // Borrower table
				return "5";
			case "6": // Book Loans table
				return "6";
			case "0": // return to operation select
				return "0";
			}
			
			System.out.println("Invalid Input.");
			
		}while(true);
	}
	
	/*
	 * This function returns the next line while skipping over the next line feed, return carriage, etc
	 * */
	private String getNextLine() 
	{
		// regex pattern thanks to: https://archie94.github.io/blogs/skip-newline-while-reading-from-scanner-class
		// this tells scanner to skip past the next new line for all operating systems
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		return scanner.nextLine();
	}
}
