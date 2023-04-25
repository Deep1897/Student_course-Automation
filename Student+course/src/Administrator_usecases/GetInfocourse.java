package Administrator_usecases;

import java.util.Scanner;

import Administration_implementation.AdminisratorImpl;
import Administrator_interfaces.Administrator;
import Bean_classes.Course;
import exception_part.CourseException;

public class GetInfocourse {
	
	
	public static void courseInfo() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the course name to get information about course");
		String cname=sc.next();
		
		Administrator admin= new AdminisratorImpl();
		try {
			Course c=admin.getInfoCourse(cname);
			System.out.println(c);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	

}
