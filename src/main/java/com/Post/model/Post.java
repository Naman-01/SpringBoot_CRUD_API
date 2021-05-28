package com.Post.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;




@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pID ;
	
	@Column(name = "Post_Tittle")
	@NotBlank(message ="Post Tittle Not Blank")
	@NotNull(message = "Post Tittle Not NULL")
	private String pTittle ;
	
	@Column(name = "Post_Description")	
	@NotBlank(message ="Post Discription Not Blank")
	@NotNull(message = "Post Discription Not NULL")
	private String pDesc ;
	
	

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(Long pID, String pTittle, String pDesc) {
		super();
		this.pID = pID;
		this.pTittle = pTittle;
		this.pDesc = pDesc;
	}

	public Long getpID() {
		return pID;
	}

	public void setpID(Long pID) {
		this.pID = pID;
	}

	public String getpTittle() {
		return pTittle;
	}

	public void setpTittle(String pTittle) {
		this.pTittle = pTittle;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	@Override
	public String toString() {
		return "Post [pID=" + pID + ", pTittle=" + pTittle + ", pDesc=" + pDesc + "]";
	}
	
	
	
	

}
