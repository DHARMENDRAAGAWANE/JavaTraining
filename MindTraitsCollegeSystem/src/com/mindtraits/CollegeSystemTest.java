package com.mindtraits;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

public class CollegeSystemTest {

	@Test
	public void testSearchStudent() {
		
		CollegeSystem collegeSystem = new CollegeSystem();
		collegeSystem.searchStudent(collegeSystem);
		assertEquals(collegeSystem.getStudents(), collegeSystem.students);
	}

	@Test
	public void testSearchCourse() {
		
		CollegeSystem collegeSystem = new CollegeSystem();
		collegeSystem.searchCourse(collegeSystem);
		assertEquals(collegeSystem.getCourses(), collegeSystem.courses);
	}

//	@Test
//	public void testAddStudentCollegeSystem() throws ParseException {
//		CollegeSystem collegeSystem = new CollegeSystem();
//		collegeSystem.addStudent(collegeSystem);
//		assertEquals(collegeSystem.getStudents().size(),1);
//	}
	
//	@Test
//	public void testRemoveStudent() {
//		fail("Not yet implemented");
//	}
	
//	@Test
//	public void testUpdateStudent() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testAddCourseCollegeSystem() {
		
		CollegeSystem collegeSystem = new CollegeSystem();
		collegeSystem.addCourse(collegeSystem);
		assertEquals(collegeSystem.getCourses().size(), 1);
	}

//	@Test
//	public void testRemoveCourse() {
//		
//		CollegeSystem collegeSystem = new CollegeSystem();
//		collegeSystem.removeCourse(collegeSystem);
//		assertEquals(collegeSystem.getCourses(), collegeSystem.courses);
//		}
//	
//	@Test
//	public void testUpdateCourse() {
//		CollegeSystem collegeSystem = new CollegeSystem();
//		collegeSystem.updateCourse(collegeSystem);
//		assertEquals(collegeSystem.getCourses(), collegeSystem.courses);
//	}

}
