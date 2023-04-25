package MainClass;

import java.util.Scanner;

import Administration_implementation.AdminisratorImpl;
import Administrator_interfaces.Administrator;
import Administrator_usecases.AddCourse;
import Administrator_usecases.CreateBatch;
import Administrator_usecases.DeleteCourse;
import Administrator_usecases.GetInfocourse;
import Administrator_usecases.GetStudentEveryBatch;
import Administrator_usecases.UpdateFee;
import Administrator_usecases.Updateseat;
import Administrator_usecases.getStudentBatchByCourseName;

public class Index {
	
	public static void main(String[] args) {
		
		System.out.println("press:1 for Admin login");
		System.out.println("press: 2 for Student login");
		
		Administrator admin=new AdminisratorImpl();
		
		Scanner sc=new Scanner(System.in);
		int logInput=sc.nextInt();
		if(logInput==1)
		{
			for(int i=0;i<3;i++)
			{
				System.out.println("please Enter the username");
				String username=sc.next();
				System.out.println("please Enter the password");
				String password=sc.next();
				boolean x=admin.adminLogin(username, password);
				if(x==true)
				{
					break;
				}else
				{
					System.out.println("invalid credential..");
					if(i<2)
					{
						System.out.println("You have left"+(2-i)+" chance only..");
					}
					else
					{
						System.out.println("please try after some time later..");
					}
					
					continue;
				}
				
			}
			
			
			System.out.println("     ........welcome to the Automated Student Registration System.........");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("                press: 1 for Add new Course");
			System.out.println("                press: 2 Update fee of course");
			System.out.println("                press: 3 for Delete  a course from any Training session.");
			System.out.println("                press: 4 for Search information about a course.");
			System.out.println("                press: 5 for Create Batch under a course.");
			System.out.println("                press: 6 for Allocate students in a Batch under a course.");
			System.out.println("                press: 7 for Update total seats of a batch.");
			System.out.println("                press: 8 for View the students of every batch.");
			System.out.println("\n");
			System.out.println("                press: 0 to exit from this window...");
			
			boolean x=true;
			while(x) {
				
				int key=sc.nextInt();
				if(key==0) {
					System.out.println("                go to the Student login Page");
					StudentLoginPage.logStudent();
					
			
				}else
				{
					System.out.println("\n");
					System.out.println("                press: 1 for Add new Course");
					System.out.println("                press: 2 Update fee of course");
					System.out.println("                press: 3 for Delete  a course from any Training session.");
					System.out.println("                press: 4 for Search information about a course.");
					System.out.println("                press: 5 for Create Batch under a course.");
					System.out.println("                press: 6 for Allocate students in a Batch under a course.");
					System.out.println("                press: 7 for Update total seats of a batch.");
					System.out.println("                press: 8 for View the students of every batch.");
					System.out.println("\n");
					System.out.println("                press: 0 to exit from this window...");
				}
			
			
			
			switch (key) {
			case 1: {
				AddCourse.addCourse();
				break;
			}
			case 2:{
				UpdateFee.updateFee();
				break;
				
			}
			case 3:{
				
				DeleteCourse.deletedCourse();
				break;
				
			}
			case 4:{
				GetInfocourse.courseInfo();
				break;
				
			}
			case 5:{
				CreateBatch.createBatch();
				break;
				t repoit
			}
			case 6:{
				
				getStudentBatchByCourseName.getStOfCourse();
				break;
				
			}
			case 7:
			{
				Updateseat.updateseat();
				break;
				
				
			}
			case 8:
			{
				
				GetStudentEveryBatch.viewstbyBatch();
				break;
			}
			case 0:
				x=false;
				break;
			}
			
			
			
			}
			
			
		}else
		{
			StudentLoginPage.logStudent();
		}
		
		
		
	}
	

}
