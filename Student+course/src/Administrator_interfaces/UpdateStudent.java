package Administrator_interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbutility.Database;

public class UpdateStudent {
	
	public static String updatename(String newname,String username,String password)
	{
		String s=null;
		
		try (Connection conn= Database.provideConnection() ){
			  
			PreparedStatement pr= conn.prepareStatement("update Student set stname=? where email=? and password=?");
			pr.setString(1, newname);
			pr.setString(2, username);
			pr.setString(3, password);
			
		int x=	pr.executeUpdate();
			
				if(x>0)
				{
					s="Updation successfully...";
				}else
				{
					s="username ar password are invalid..";
				}
				
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return s;
	}
	
	
	public static String updateCourse(int courseId,String username,String password)
	{
		String s=null;
		
		try (Connection conn= Database.provideConnection() ){
			  
			PreparedStatement pr= conn.prepareStatement("update Student set courseId=? where email=? and password=?");
			pr.setInt(1, courseId);
			pr.setString(2, username);
			pr.setString(3, password);
			
		int x=	pr.executeUpdate();
			
				if(x>0)
				{
					s="Updation successfully...";
				}else
				{
					s="username ar password are invalid..";
				}
				
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		return s;
	}
	
	
	

}
