package Administrator_usecases;

import java.util.Scanner;

import Administration_implementation.AdminisratorImpl;
import Administrator_interfaces.Administrator;
import exception_part.StudentException;

public class LoginStudent {
	
	public static void studentLoginn(){
		
		Scanner sc=new Scanner(System.in);
		System.out.println("please Enter the email as username");
		String email=sc.next();
		System.out.println("please Enter the password");
		String password = sc.next();
		
		Administrator admin=new AdminisratorImpl();
		
		try {
			admin.loginStudent(email, password);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
