package Administrator_usecases;

import java.util.Scanner;

import Administration_implementation.AdminisratorImpl;
import Administrator_interfaces.Administrator;
import exception_part.CourseException;

public class UpdateFee {
   
	public static void updateFee(){
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the fee as you want to change");
		int cfee=sc.nextInt();
		
		System.out.println("Enter the course name in which fee you want to change");
		String cname=sc.next();
		
		Administrator admin=new AdminisratorImpl();
		
		try {
			String s=admin.updateFeeCourse(cfee, cname);
			System.out.println(s);
		} catch (CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		sc.close();
		
	}
	
}
