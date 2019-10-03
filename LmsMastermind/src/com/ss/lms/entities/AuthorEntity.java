package com.ss.lms.entities;

public class AuthorEntity {
	
	private Integer authorId;
	private String authorName;
	
	public AuthorEntity(){
		
	}
	
	public AuthorEntity(Integer authorId, String authorName) {
		this.authorId = authorId;
		this.authorName = authorName;
	}

	/**
	 * @return the authorId
	 */
	public Integer getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
	
}
