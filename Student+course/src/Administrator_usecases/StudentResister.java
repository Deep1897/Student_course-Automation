package Administrator_usecases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Administration_implementation.AdminisratorImpl;
import Administrator_interfaces.Administrator;
import Bean_classes.Course;
import Bean_classes.Student;
import dbutility.Database;
import exception_part.CourseException;
import exception_part.StudentException;

public class StudentResister {

	public static void resisterStudent() {
		
		Scanner sc=new Scanner(System.in);
		
		
		
		try (Connection conn= Database.provideConnection()){
			
			   PreparedStatement pr= conn.prepareStatement("select * from course");
			   ResultSet rs= pr.executeQuery();
			   while(rs.next())
			   {
				   Course cr=new Course();
				   cr.setCourseId(rs.getInt("courseId"));
				   cr.setCname(rs.getString("cname"));
				   cr.setCfee(rs.getInt("cfee"));
				   cr.setCduration(rs.getString("cduration"));
				   System.out.println(cr);
				   
				   
			   }
			   
			  
			   
			   
			   
			   
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("enter the courseId from above you choosen ");
		int courseId=sc.nextInt();
		System.out.println("please Enter your name");
		String stname=sc.next();
		System.out.println("Enter your email as user name");
		String email=sc.next();
		System.out.println("Enter the password");
		String password =sc.next();
		
		Student st=new Student( courseId, stname, email, password);
		
		Administrator admin=new AdminisratorImpl();
		
		try {
			String s= admin.resisterStudent(st);
			System.out.println(s);
			
		} catch (StudentException | CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}
