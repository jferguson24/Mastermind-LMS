/**
 * 
 */
package com.ss.lms.dataaccess;

import java.sql.*;
import java.util.ArrayList;

import com.ss.lms.entities.*;

/**
 * @author sj
 *
 */
public class DataAccessLibrarian {
	
	Connection con;
	
	public DataAccessLibrarian() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");  
//			Statement stmt=con.createStatement(); 
//			ResultSet rs=stmt.executeQuery("select * from tbl_author");  
//			while(rs.next())  
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2));  

			}catch(Exception e){ System.out.println(e);} 
	}
	
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("No connection active.");
		}  
	}
	
	public ArrayList<EntityLibraryBranch> selectBranches(){
		ArrayList<EntityLibraryBranch> branchArray = new ArrayList<EntityLibraryBranch>();
		Statement stmt2;
		try {
			stmt2 = con.createStatement();
			ResultSet branches=stmt2.executeQuery("select * from tbl_library_branch;");  
			while(branches.next()) { 
				EntityLibraryBranch branch = new EntityLibraryBranch(branches.getInt(1),branches.getString(2),branches.getString(3));
				branchArray.add(branch); 
			}		
			return branchArray;
		} catch (SQLException e) {
			System.out.println("Invalid Query");
		} 
		return branchArray;
	}
	
	public boolean updateBranchAddress(int branchId, String address) {
		Statement update;
		try {
			update = con.createStatement();
			update.executeUpdate("update tbl_library_branch set branchAddress = \"" + address + "\" where branchId = "+ branchId +";");
	
			return true;
		} catch (SQLException e) {
			System.out.println("Invalid Query");
		} 
		return false;
	}
	public boolean updateBranch(int branchId, String name, String address) {
		Statement update;
		try {
			
			update = con.createStatement();
			update.executeUpdate("update tbl_library_branch set branchName = \"" + name + "\",branchAddress = \"" + address + "\" where branchId = "+ branchId +";");
		
			return true;
		} catch (SQLException e) {
			System.out.println("Invalid Query");
		} 
		return false;
	}
	public boolean updateBranchName(int branchId, String name) {

		Statement update;
		try {
			update = con.createStatement();
			update.executeUpdate("update tbl_library_branch set branchName = \"" + name + "\" where branchId = "+ branchId +";");
	
			return true;
		} catch (SQLException e) {
			System.out.println("Invalid update Query");
		} 
		return false;
	}
	public ArrayList<EntityBook> selectBooks(int branchId){
		ArrayList<EntityBook> bookArray = new ArrayList<EntityBook>();
		Statement stmt2;
		try {
			stmt2 = con.createStatement();
			ResultSet books=stmt2.executeQuery("select * from tbl_book, tbl_book_copies where tbl_book.bookId = tbl_book_copies.bookId and branchId = " + branchId);  
			while(books.next()) { 
				EntityBook book = new EntityBook(books.getInt(1),books.getString(2),books.getInt(3),books.getInt(4));
				bookArray.add(book); 
			}		
			return bookArray;
		} catch (SQLException e) {
			System.out.println("Invalid select all books Query");
		} 
		return bookArray;
	}
	
	public String selectAuthorName(EntityBook book) {
		String authorName = null;
		Statement stmt2;
		try {
			stmt2 = con.createStatement();
			ResultSet author=stmt2.executeQuery("select authorName from tbl_book, tbl_author"
										+ " where tbl_book.authId = tbl_author.authorId and bookId = "
										+ book.getAuthorId());  
			author.next();
			authorName = new String(author.getString(1));
			return authorName;
		} catch (SQLException e) {
			System.out.println("Invalid select authorName Query");
		} 
		return authorName;
	}
	
	public int selectNumberOfCopies(EntityBook book, int branchId) {
		int numCopies = 0;
		Statement stmt2;
		try {
			stmt2 = con.createStatement();
			ResultSet noOfCopies = stmt2.executeQuery("select noOfCopies from tbl_book_copies where branchId =" + branchId + " and bookId = " + book.getBookId());  
			noOfCopies.next();
			numCopies = noOfCopies.getInt(1);
			return numCopies;
		} catch (SQLException e) {
			System.out.println("Invalid select noOfCopies Query");
		} 
		return numCopies;
	}

	public boolean updateCopies(EntityBook book, int branchId, int numCopies) {

		Statement update;
		try {
			update = con.createStatement();
			update.executeUpdate("update tbl_book_copies set noOfCopies = \""
									+ numCopies + "\" where branchId = "
									+ branchId +" and bookId = "
									+ book.getBookId() + ";");
	
			return true;
		} catch (SQLException e) {
			System.out.println("Invalid update noOfCopies Query");
		} 
		return false;
	}
}
