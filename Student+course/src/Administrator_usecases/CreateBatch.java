package Administrator_usecases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import Administration_implementation.AdminisratorImpl;
import Administrator_interfaces.Administrator;
import Bean_classes.Batch;
import Bean_classes.Course;
import dbutility.Database;
import exception_part.BatchException;

public class CreateBatch {
	
	public static void createBatch() {
		
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
		
		
		
		System.out.println("\n Enter the courseId from above");
		
		int courseId=sc.nextInt();
		
		System.out.println(" Enter the batchId");
		int batchId=sc.nextInt();
		System.out.println(" Enter the batch name");
		String bname = sc.next();
		System.out.println(" Enter the seat in number");
		int seat=sc.nextInt();
		
		Batch b=new Batch(courseId, batchId, bname, seat);
		
		Administrator admin=new AdminisratorImpl();
		try {
			String s=admin.createBatch(b);
			System.out.println(s);
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
