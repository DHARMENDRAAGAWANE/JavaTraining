package com.mindtraits;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Date dob;
	private Course course;
	
	/**
	 * @return the name
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the date of birth
	 */
	
	public Date getDob() {
		return dob;
	}
	
	/**
	 * @param dob the date to set
	 */
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}
	
	/**
	 * @param course the course to set
	 */
	
	public void setCourse(Course course ) {
		this.course = course;
	}

	
	@Override
	public String toString() {
		return "Student [name=" + name + ", dob=" + dob + ", Course=" + course + "]";

	}
}