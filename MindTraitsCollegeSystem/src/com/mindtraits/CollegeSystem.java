package com.mindtraits;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

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
	
	static Scanner sn = new Scanner(System.in);

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
 * search student
 * @throws IOException using path 
 */

public void readRecord() throws IOException{
	
	Path path = Paths.get("src/student.txt").toAbsolutePath(); 
	
	List<String> students = Files.lines(path).collect(Collectors.toList());
	System.out.println("Enter Student name:");
	String name  = getInput();
	
	displayResults(name,students);
}

/**
 * @return the search input
 */

public static String getInput() {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Student Name:");
	String name = sc.nextLine();
	sc.close();
	
	return name;
	
}
/**
 * @param name 
 * @param titles
 * @throws IOException
 */
public static void displayResults(String name,List<String> titles) throws IOException{

	boolean inFile  = titles.stream().anyMatch(p->p.equalsIgnoreCase(name));
	
	if(inFile) {
		
		System.out.println("Yes,"+name+"in this file");
	}else {
		
		System.out.println("No,"+name+"is not in this file");
			
		}
	
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
			this.readRecord();
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
		@SuppressWarnings("resource")
		Scanner sn = new Scanner(System.in);
		
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
				Header.Head();
				try {
				/**
				 * add student
				 * @param collegeSystem add the student from the collegeSystem
				 * @throws ParseException is used for date format
				 */
				System.out.println("Add Student");
				System.out.println("*******************");
				Student student = new Student();
				@SuppressWarnings("resource")
				Scanner s = new Scanner(System.in);
				System.out.println("Enter Student Name:");
				String name = s.nextLine();
				student.setName(name);
				System.out.println("Enter Date of Birth:");
				String dob = s.nextLine();
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				Date date1 = simpleDateFormat.parse(dob);
				student.setDob(date1);
				System.out.println("Enter Course:");
				String coursename = s.nextLine();
				
				
				Optional<Course> optionalCourse = this.getCourses().stream()
						.filter(oneCourse -> oneCourse.getName().equalsIgnoreCase(coursename)).findAny();
				

				if (optionalCourse.isPresent()) {

					student.setCourse(optionalCourse.get());
					
				}else {
					
					System.out.println("given course not found");
					
					throw new RuntimeException("course not found");
				}
				this.addStudent(student);
				this.getStudents().stream().forEach(stu -> System.out.println(stu));
				this.getCourses().stream().forEach(oneCourse -> System.out.println(oneCourse));

				
				}catch(Exception e) {
					
					collegeMenu();
					
				}
				
				break;
			   
		case 2:	
				Header.Head();
				/**
				 * remove student 
				 * @param collegeSystem remove the student from the collegeSystem
				 */
				System.out.println("Remove Student");
		   	   	System.out.println("*******************");
		   	   	
//		   	   	Student student = new Student();
//				List<Student> students = new ArrayList<Student>();
//				@SuppressWarnings("resource")
//				Scanner ns = new Scanner(System.in);
//				System.out.println("Enter Remove Name:");
//				String remove = ns.nextLine();
//
//				for(int i=0;i<students.size();i++) {
//					
//					if(name.equals(remove)) {
//					
//						students.remove(i);
//						break;
//					
//					}
//				
//				}
//				System.out.println("Removed Successfully");	
		   	   	
		   	   	studentMenu();
				
		   	   	break;
		   	   	
		case 3:
				Header.Head();
				/**
				 * update student 
				 * @param collegeSystem update remove the student from the collegeSystem
				 */
				System.out.println("Update Student");
	   	   		System.out.println("*******************");
//	   	   		Student student = new Student();
//	   	   		List<Student> students = new ArrayList<Student>();
//	   	   		@SuppressWarnings("resource")
//	   	   		Scanner ns = new Scanner(System.in);
//	   	   		System.out.println("Enter Update Name:");
//	   	   		String element  = ns.nextLine();
//			
//
//				for(int i=0;i<students.size();i++) {
//				
//				
//			  	  if(students.get(i).getName().equals(name)) {
//			    	
//			    		student.set(i, element);
//			   		 }
//				}
//	   	   		
//	   	   		System.out.println("update Successfully");
				
	   	   		studentMenu();
	   	   	
				break;
	   	   		
		case 4:
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
	@SuppressWarnings("resource")
	Scanner sn = new Scanner(System.in);
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
			Header.Head();
			/**
			 * add course
			 * @param collegeSystem add the course from the collegeSystem
			 */
			System.out.println("Add Course");
			System.out.println("*******************");
			Course course = new Course();
			Scanner ns = new Scanner(System.in);
			System.out.println("Enter Course Name:");
			String name = ns.nextLine();
			course.setName(name);
			System.out.println("Enter Major:");
			String major = ns.nextLine();
			course.setMajor(major);
			System.out.println("Enter Duration:");
			int duration = ns.nextInt();
			course.setDuration(duration);
			this.addCourse(course);
			this.getStudents().stream().forEach(stu -> System.out.println(stu));
			this.getCourses().stream().forEach(oneCourse -> System.out.println(oneCourse));
			
			courseMenu();
			
			break;
		   
	case 2:
			Header.Head();
			/**
	   		 * remove course
	   		 * @param collegeSystem remove the course from the collegeSystem
	   		 */
	   		
			System.out.println("Remove Course");
	   	   	System.out.println("*******************");   			
			List<Course> courses = new ArrayList<Course>();
	   		System.out.println("Enter Remove Name:");
	   		String remove = sn.nextLine();
	   		for(int i=0;i<courses.size();i++) {
	   				
	   			if(courses.get(i).equals(remove)) {
	   				
	   				courses.remove(i);
	   				
	   			}
	   			
	   		}
	   		System.out.println("Removed Succesfully");
			
			courseMenu();

	   	   	break;
	   	   	
	case 3:
			Header.Head();
			/**
			 * update course
			 * @param collegeSystem update the course from the collegeSystem
			 */
//			System.out.println("Update Course");
//   	   	System.out.println("*******************");
//   	   	CollegeSystem collegeSystem2 = new CollegeSystem();
//   	   	Course course2 = new Course();
//   		System.out.println("Enter Update Name:");
//   		String update = sn.nextLine();
//   			
//   		for(int i=0;i<courses.size();i++) {
//   					
//   		if(courses.get(i).equals(update)) {
//   				
//   			courses.set(i, course);
//   		}
			
//	}
//   		System.out.println("Update Successfully");
//
			courseMenu();

   	   		break;
   	   		
	case 4:
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