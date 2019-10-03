/**
 * 
 */
package com.ss.lms.service;


import java.util.ArrayList;

import com.ss.lms.dataaccess.*;
import com.ss.lms.entities.*;

/**
 * @author sj
 *
 */
public class ServiceLibrarian {

	DataAccessLibrarian DAOlib;
	
	public ServiceLibrarian() {
		DAOlib = new DataAccessLibrarian();
	}
	
	public ArrayList<EntityLibraryBranch> getBranchEntities() {
		return DAOlib.selectBranches();
	}
	
	public boolean updateLibraryAddress(int branchId, String address) {
		return DAOlib.updateBranchAddress(branchId, address);
	}
	public boolean updateLibraryName(int branchId, String name) {
		return DAOlib.updateBranchName(branchId, name);
	}
	public boolean updateLibrary(int branchId, String name, String address) {
		return DAOlib.updateBranch(branchId, name, address);
	}
	public ArrayList<EntityBook> getBookEntities(int branchId) {
		return DAOlib.selectBooks(branchId);
	}
	
	public String getAuthorName(EntityBook book) {
		return DAOlib.selectAuthorName(book);
	}
	public int getNumberOfCopies(int bookId, int branchId) {
		return DAOlib.selectNumberOfCopies(bookId, branchId); 
	}

	public boolean changeCopies(int bookId, int branchId, int numCopies) {
		return DAOlib.updateCopies(bookId, branchId, numCopies);
	}
}
