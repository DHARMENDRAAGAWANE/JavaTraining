package com.mindtraits;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

public class CollegeSystemTest {

//	@Test
//	public void testSearchStudent() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSearchCourse() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testAddStudentCollegeSystem() throws ParseException {
//		CollegeSystem collegeSystem = new CollegeSystem();
//		Student student = new Student();
//		student.getName();
//		collegeSystem.addStudent(collegeSystem);
//		assertEquals(0,true);
//		
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	public void testRemoveStudent() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateStudent() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testAddCourseCollegeSystem() {
		CollegeSystem collegeSystem = new CollegeSystem();
		Course course = new Course();
		course.getName();
		course.getMajor();
		course.getDuration();
		collegeSystem.addCourse(collegeSystem);
		assertEquals(course,collegeSystem);
		fail("Not yet implemented");
	}

//	@Test
//	public void testRemoveCourse() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdateCourse() {
//		fail("Not yet implemented");
//	}

}
