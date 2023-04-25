package Administrator_usecases;

import java.util.List;
import java.util.Scanner;

import Administration_implementation.AdminisratorImpl;
import Administrator_interfaces.Administrator;
import exception_part.BatchException;
import exception_part.CourseException;

public class getStudentBatchByCourseName {

	public static void getStOfCourse() {
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("please Enter the course name to get students and thier batch");
		String cname=sc.next();
		
		Administrator admin=new AdminisratorImpl();
		System.out.println("[ Stname , cname , Batch ]");
		try {
			List<String> s=admin.getStudentBatchByCourse(cname);
			System.out.println(s);
			
			
		} catch (CourseException | BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
