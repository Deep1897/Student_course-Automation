package Administrator_usecases;

import java.util.Scanner;

import Administration_implementation.AdminisratorImpl;
import Administrator_interfaces.Administrator;
import exception_part.CourseException;

public class DeleteCourse {

	public static void deletedCourse() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("please Enter the course name to be deleted");
		String cname=sc.next();
		
		Administrator admin=new AdminisratorImpl();
		
		try {
			String s=admin.deleteCourse(cname);
			System.out.println(s);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
