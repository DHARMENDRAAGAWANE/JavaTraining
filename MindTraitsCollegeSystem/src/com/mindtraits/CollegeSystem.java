package com.mindtraits;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Scanner;
import com.mindtraits.Course;
import com.mindtraits.Student;

/**
 * The mindtrairs college system program implements an application that​
 * displays to the standard output
 * @author Vignesh
 * @version 1.0
 * @since 2019-08-16
 *
 */

class CollegeSystem extends Header {
	
	Scanner sn = new Scanner(System.in);
	List<Student> students = new ArrayList<Student>();
	List<Course> courses = new ArrayList<Course>();
	
	/** 
	 * @return the course
	 */
	
	public List<Course> getCourses() {
		return courses;
	}
	
	/**
	 * @param course the course to set
	 */
	
	public void addCourse(Course course) {
		this.courses.add(course);
	}
	
	/**
	 * @param courses the course to set the course list
	 */
	
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	/**
	 * @return the student
	 */
	
	public List<Student> getStudents() {
		return students;
	}
	
	/**
	 * @param student the student to set
	 */
	
	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	/**
	 * @param students the to set the student list
	 */
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}
		
	/**
	 * college MainMenu
	 * @throws ParseException used for date format
	 * @throws IOException is used
	 */
	
	public void collegeMenu() throws ParseException, IOException {
	
		System.out.println("1.Search(Student or Course)");
		System.out.println("2.Student");
		System.out.println("3.Course");
		System.out.println("4.exit");
	
		int choice = 0;
		int count = 0;
	
		while(count==0){
			System.out.println("Enter Your choice 1 to 4:");
			choice = sn.nextInt();
			if(choice < 6){
				count++;
			}else{
				System.out.println("Invalid Choice");
			}
		}
	
		switch(choice){

		case 1:
				Header.Head();
				System.out.println("1.Search Student");
				System.out.println("2.Search Course");
				System.out.println("Enter Your Choice 1 to 2:");
				int n = sn.nextInt();
				if(n==1) {
						searchStudent(this);
				}else if(n==2) {
					
						searchCourse(this);
				}
				
				collegeMenu();
				count++;
				
				break;
		case 2:
				Header.Head();
				this.studentMenu();
				count++;
			
				break;
		case 3:
				Header.Head();
				this.courseMenu();
				count++;
			
				break;
		case 4:
	        	System.exit(choice);
	        
	        	break;
	        
		default:
				System.out.println("Invalid choice");
			
		}

	}

	/**
	 * student MainMenu
	 * @throws ParseException used for set the date format
	 * @throws IOException used
	 */

	public void studentMenu() throws ParseException, IOException{
				
		System.out.println("1.Add Student");
		System.out.println("2.Remove Student");
		System.out.println("3.Update Student");
		System.out.println("4.Back to Main Menu");
		

		int choice = 0;
		int count = 0;
		while(count==0){
			System.out.println("Enter Your choice:");
			choice = sn.nextInt();
		if(choice < 5){
			count++;
		}else{
			 System.out.println("Invalid Choice");
		} 
		
	}

		switch(choice){
		
		case 1:
				//add Student
				Header.Head();
				System.out.println("Add Student");
				System.out.println("*******************");
				try {
					
					addStudent(this);
					
				}catch(Exception e) {
					
					studentMenu();
					
				}
				
				studentMenu();
				
				break;
			   
		case 2:	
				//remove Student
				Header.Head();
				System.out.println("Remove Student");
			   	System.out.println("*******************");
				removeStudent(this);
		   	   	studentMenu();
				
		   	   	break;
		   	   	
		case 3:
				//update Student
				Header.Head();
				System.out.println("Update Student");
			   	System.out.println("*******************");
				updateStudent(this);
	   	   		studentMenu();
	   	   	
				break;
	   	   		
		case 4:
				//back to MainMenu
				Header.Head();
				System.out.println("Back to Main Menu");
	   	   		System.out.println("*******************");
	   	   		collegeMenu();
	   			
	   	   		break;
	   	   		
	   	default:

	   			System.out.println("Invalid Choice");
			
			
			
		}
	}

	/**
	 * course MainMenu
	 * @throws ParseException unused
	 * @throws IOException used
	 */

	public void courseMenu() throws ParseException, IOException{
	
		System.out.println("1.Add Course");
		System.out.println("2.Remove Course");
		System.out.println("3.Update Course");
		System.out.println("4.Back to Main Menu");
	

		int choice = 0;
		int count = 0;

		while(count==0){
			System.out.println("Enter Your choice:");
			choice = sn.nextInt();
			if(choice < 5){
				count++;
			}else{
				System.out.println("Invalid Choice");
			}
		}

		switch(choice){
	
		case 1:
				//add Course
				Header.Head();
				System.out.println("Add Course");
				System.out.println("*******************");
				addCourse(this);
				courseMenu();
			
				break;
		   
		case 2:
				//remove Course
				Header.Head();
				System.out.println("Remove Course");
	   	   		System.out.println("*******************");
	   	   		removeCourse(this);
	   	   		courseMenu();

	   	   		break;
	   	   	
		case 3:
				//update Course
				Header.Head();
				System.out.println("Update Course");
   	   			System.out.println("*******************");
	   	   		updateCourse(this);
				courseMenu();
			
				break;
   	   		
		case 4:
				//back to MainMenu
				Header.Head();
				System.out.println("Back to Main Menu");
   	   			System.out.println("*******************");
   	   			collegeMenu();
   			
   	   			break;
   
		default:
				System.out.println("Invalid Choice");
		}
	}
	
	
	/**
	 * search student
	 * @param collegeSystem used to set student collections
	 */
	
	Scanner s = new Scanner(System.in);
	public void searchStudent(CollegeSystem collegeSystem) {
		
		System.out.println("Enter Search Student Name:");
		String searchname = s.nextLine();
		ListIterator<Student> listIterator = collegeSystem.students.listIterator();
	
		while(listIterator.hasNext()) {
			
			Student student = listIterator.next();
			
			if (student.getName().contains(searchname)) {
				
				System.out.println(student);
				
			}
		}

	}
	
	
	/**
	 * search course
	 * @param collegeSystem used to set course collections
	 */
	
	public void searchCourse(CollegeSystem collegeSystem) {

		System.out.println("Enter Search Course Name:");
		String searchcourse = s.nextLine();
		ListIterator<Course> Iterator = collegeSystem.courses.listIterator();
		
		
		while(Iterator.hasNext()) {
			
		Course course = Iterator.next();

		if(course.getName().contains(searchcourse)) {
				
				System.out.println(course);
			}

		}

	}
	
	
	/**
	 * add student
	 * @param collegeSystem add the student from the collegeSystem
	 * @throws ParseException is used for date format
	 */
	
	Scanner sc = new Scanner(System.in);
	public void addStudent(CollegeSystem collegeSystem) throws ParseException {
		
		Student student = new Student();
		System.out.println("Enter Student Name:");
		String name = sc.nextLine();
		student.setName(name);
		System.out.println("Enter Date of Birth:");
		String dob = sc.nextLine();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date1 = simpleDateFormat.parse(dob);
		student.setDob(date1);
		System.out.println("Enter Course:");
		String coursename = sc.nextLine();
	
	
		Optional<Course> optionalCourse = collegeSystem.getCourses().stream()
			.filter(oneCourse -> oneCourse.getName().equalsIgnoreCase(coursename)).findAny();
	

		if (optionalCourse.isPresent()) {

			student.setCourse(optionalCourse.get());
		
		}else {
		
			System.out.println("given course not found");
			
			throw new RuntimeException("course not found");
		}
		collegeSystem.addStudent(student);
		collegeSystem.getStudents().stream().forEach(stu -> System.out.println(stu));
		collegeSystem.getCourses().stream().forEach(oneCourse -> System.out.println(oneCourse));

	
}
	
	/**
	 * remove student 
	 * @param collegeSystem remove the student from the collegeSystem
	 */

	public void removeStudent(CollegeSystem collegeSystem) {
	
	   	System.out.println("Enter Remove Student Name:");
	   	String removename = sc.nextLine();
	   	
	   	for(Iterator<Student> iterator = collegeSystem.students.iterator(); iterator.hasNext();) {
			Student student = iterator.next();
			if(student.getName().contains(removename)) {
				
				iterator.remove();
				
			}
		}
	   	System.out.println("Removed Successfully");
	   	System.out.println(collegeSystem.students);

}
	/**
	 * update student 
	 * @param collegeSystem update remove the student from the collegeSystem
	 */
	
	public void updateStudent(CollegeSystem collegeSystem) {
		
		System.out.println("Enter Update Student Name:");
		String updatename = sc.nextLine();
		
		ListIterator<Student> listIterator = collegeSystem.students.listIterator();			

			while(listIterator.hasNext()) {
				
				Student student = listIterator.next();

			if(student.getName().equalsIgnoreCase(updatename)){
				System.out.println("Enter the New Student Name:");
				String newstudentname = sc.nextLine();
				student.setName(newstudentname);
			}
		}
	
			System.out.println("Updated Successfully");
		   	System.out.println(collegeSystem.students);
		
}
	/**
	 * add course
	 * @param collegeSystem add the course from the collegeSystem
	 */
	public void addCourse(CollegeSystem collegeSystem) {
		@SuppressWarnings("resource")
		Scanner sr = new Scanner (System.in);
		Course course = new Course();
		System.out.println("Enter Course Name:");
		String name = sr.nextLine();
		course.setName(name);
		System.out.println("Enter Major:");
		String major = sr.nextLine();
		course.setMajor(major);
		System.out.println("Enter Duration:");
		int duration = sr.nextInt();
		course.setDuration(duration);
		collegeSystem.addCourse(course);
		collegeSystem.getStudents().stream().forEach(stu -> System.out.println(stu));
		collegeSystem.getCourses().stream().forEach(oneCourse -> System.out.println(oneCourse));
		}
	
	/**
	* remove course
	* @param collegeSystem remove the course from the collegeSystem
	*/
	Scanner sr1 = new Scanner (System.in);
	public void removeCourse(CollegeSystem collegeSystem) {
		
		System.out.println("Enter Remove Course Name:");
	   	String removename = sr1.nextLine(); 
	   	
		for(Iterator<Course> iterator = collegeSystem.courses.iterator(); iterator.hasNext();) {
		Course course = iterator.next();
			if(course.getName().contains(removename)) {
				
				iterator.remove();
				
			}
		}
	   	System.out.println("Removed Successfully");
	   	System.out.println(collegeSystem.courses);
}
	
	/**
	 * update course
	 * @param collegeSystem update the course from the collegeSystem
	 */
	Scanner sr2 = new Scanner (System.in);
	public void updateCourse(CollegeSystem collegeSystem) {
		System.out.println("Enter Update Course Name:");
		String updatename = sr2.nextLine();
		
		ListIterator<Course> listIterator = collegeSystem.courses.listIterator();			
			
			while(listIterator.hasNext()) {
				
				Course course = listIterator.next();

			if(course.getName().equalsIgnoreCase(updatename)){
				System.out.println("Enter the New Course Name:");
				String newcoursename = sr2.nextLine();
				course.setName(newcoursename);
			}
		}
	
			System.out.println("Updated Successfully");
		   	System.out.println(collegeSystem.courses);
		}
		
	
	/**
	 * This is main method which make use to run collegeSystem
	 * @param args unused
	 * @throws ParseException set the date format
	 * @throws IOException used
	 */

	public static void main(String[]args) throws ParseException, IOException {
		
		Header.Head();
		CollegeSystem collegeSystem = new CollegeSystem();
		collegeSystem.collegeMenu();
	
	

		
		}

}