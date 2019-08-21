package com.mindtraits;

import java.io.Serializable;

public class Course implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String major;
	private int duration;
	
	/**
	 * @return the course name
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
	 * @return the major
	 */
	
	public String getMajor() {
		return major;
	}
	
	/**
	 * @param major the major to set
	 */
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	/**
	 * @return the duration
	 */
	
	public int getDuration() {
		return duration;
	}
	
	/**
	 * @param duration the duration to set
	 */
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "Course [name=" + name + ", major=" + major + ", duration="
				+ duration + "]";
	}
	
}

	
