package MainClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import Administrator_usecases.LoginStudent;
import Administrator_usecases.StudentResister;
import Administrator_usecases.ViewSeatcourse;
import Bean_classes.Course;
import dbutility.Database;

public class StudentLoginPage {
	
	public static void logStudent() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("\n");

		System.out.println("                                ..... Welcome to the Student page......");
		System.out.println("\n");
        System.out.println("          press:1 for Register himself in a course with a username and password (email should be the username)");       		
        System.out.println("          press:2 can see all the available course list and their seat availability.");   
        System.out.println("          press:3 for student login.");
        System.out.println("          press:4 admin login");
		
		boolean x=true;
		while(true) {
			
			int key=sc.nextInt();
			if(key==0)
			{
				System.out.println("you are exit the window");
			}
			else
			{
				System.out.println("              ..... Welcome to the Student page......");
				System.out.println("\n");
		        System.out.println("          press:1 for Register himself in a course with a username and password (email should be the username)");       		
		        System.out.println("          press:2 can see all the available course list and their seat availability.");   
		        System.out.println("          press:3 for student login.");
				System.out.println("\n");

				
			}
		
		
        
        
        switch (key) {
		case 1: {
			 StudentResister.resisterStudent();
			 break;
			
		}
		case 2:{
			ViewSeatcourse.seatCourse();
			break;
		
		}case 3:{
			
			LoginStudent.studentLoginn();
			System.out.println("press 1: for update course");
			int y=sc.nextInt();
			if(y==1)
			{
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
				
				System.out.println("\n");
				System.out.println("    please Enter the course from above ");
				int courseId=sc.nextInt();
				System.out.println("please Enter your username again");
				String username=sc.next();
				System.out.println("please Enter your password again");
				String password=sc.next();
				
				try (Connection conn2= Database.provideConnection()){
					
					PreparedStatement pr= conn2.prepareStatement("update student set courseId=? where email=? and password=?");
					pr.setInt(1, courseId);
					pr.setString(2, username);
					pr.setString(3, password);
					int z=pr.executeUpdate();
					if(z>0)
					{
						System.out.println("updation successfull..");
					}else
					{
						System.out.println("invalid credential....");
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			
			
			break;
			
		}case 4:{
			adminLOginPage.adminlog();
			break;
			
		}
		case 0:{
			x=false;
			break;
		
        
		}
        
		
	}

		}
	}
}
