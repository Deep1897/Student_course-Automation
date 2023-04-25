package Administrator_usecases;

import java.util.Scanner;

import Administration_implementation.AdminisratorImpl;
import Administrator_interfaces.Administrator;
import Bean_classes.Course;
import exception_part.CourseException;

public class AddCourse {
	
	public static void addCourse(){
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the courseId");
		int courseId=sc.nextInt();
		
		System.out.println("Enter the course name");
		String cname=sc.next();
		System.out.println("Enter the course fee");
		int cfee= sc.nextInt();
		System.out.println("Enter the course duration");
		String cduration =sc.next();
		
		Course cr=new Course(courseId, cname, cfee, cduration);
		
		Administrator admin=new AdminisratorImpl();
		
	   try {
		String s= admin.addNewCourse(cr);
		System.out.println(s);
		
	} catch (CourseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
		
		
		
	}
	
	

}
