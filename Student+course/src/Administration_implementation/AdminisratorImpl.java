package Administration_implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Administrator_interfaces.Administrator;
import Bean_classes.Batch;
import Bean_classes.Course;
import Bean_classes.Student;
import dbutility.Database;
import exception_part.BatchException;
import exception_part.CourseException;
import exception_part.StudentException;

public class AdminisratorImpl implements Administrator{

	@Override
	public String addNewCourse(Course c) throws CourseException {
		
		String mes=null;
		
		try (Connection conn= Database.provideConnection()){
			
               PreparedStatement pr= conn.prepareStatement("insert into course values(?,?,?,?)");
           	pr.setInt(1, c.getCourseId());
			pr.setString(2, c.getCname());
			pr.setInt(3, c.getCfee());
			pr.setString(4, c.getCduration());
			
		int x=	pr.executeUpdate();	
		
		if(x>0) {
			
			mes="Added successfully...";
		
		}else
		{
			mes="Not done..";
		}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return mes;
		
		
	}

	@Override
	public String updateFeeCourse(int cfee, String cname) throws CourseException {
		String s=null;
		try (Connection conn= Database.provideConnection()){
			
			PreparedStatement pr=  conn.prepareStatement("update course set cfee=? where cname=?");
			  pr.setInt(1, cfee);
			  pr.setString(2, cname);
			  int y= pr.executeUpdate();
			  
			  
			if(y>0)
			{
				s="Updation successfully";
			}else
			{
				s="Wrong Input";
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		
		return s;
		
		
		
	}

	@Override
	public String deleteCourse(String cname) throws CourseException {
		
		String mes=null;
		
		try (Connection conn= Database.provideConnection()){
			  PreparedStatement pr= conn.prepareStatement("delete from course where cname=?");
			   pr.setString(1, cname);
			  int x= pr.executeUpdate();
			if(x>0)
			{
				mes="Deleted course "+cname+" successfully...";
			}else
			{
				
				mes="Not done...";
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return mes;
		
		
	}

	@Override
	public Course getInfoCourse(String cname) throws CourseException {
		Course c=null;
		
		try (Connection conn= Database.provideConnection()){
			
			     PreparedStatement pr=    conn.prepareStatement("select * from course where cname=?");
			
			    		 pr.setString(1, cname);
			    ResultSet rs= pr.executeQuery();
			   
			    
			    while(rs.next())
			    {
			    	c=new Course();
			    	c.setCourseId(rs.getInt("courseID"));
			    	c.setCname(rs.getString("cname"));
			    	c.setCfee(rs.getInt("cfee"));
			    	c.setCduration(rs.getString("cduration"));
			    	
			    }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return c;
	}

	@Override
	public String createBatch(Batch c) throws BatchException {
		
		String s=null;
		try (Connection conn= Database.provideConnection()){
			

			   
			   PreparedStatement dr= conn.prepareStatement("insert into batch values(?,?,?,?)");
			   dr.setInt(1, c.getCourseId());
			   dr.setInt(2, c.getBatchId());
			   dr.setString(3, c.getBname());
			   dr.setInt(4, c.getSeat());
			   int x=dr.executeUpdate();
			   
			  
			   if(x>0)
			   {
				   s="created batch successfully";
			   }
			   else
			   {
				   s="not done...";
			   }
			   
			   
			   
			   
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return s;
		
	}

	@Override
	public List getStudentBatchByCourse(String cname) throws CourseException, BatchException {
		List ll=null;
		
	try (Connection conn= Database.provideConnection()){
		
		PreparedStatement pr= conn.prepareStatement("select s.stname,c.cname,b.bname from student s inner join course c on s.courseID=c.courseId inner join batch b on c.courseId=b.courseId where cname=?");
		pr.setString(1, cname);
		ResultSet rs= pr.executeQuery();
		
		while(rs.next())
		{
			ll=new ArrayList<String>();
			ll.add(rs.getString("stname"));
			ll.add(rs.getString("cname"));
			ll.add(rs.getString("bname"));
			
			System.out.println(ll);
			
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
		// TODO: handle exception
	}
		
		
		return ll;
	}

	@Override
	public String updateSeatOfBatch(int seat, String bname) throws BatchException {
		String mes=null;
		
		try (Connection conn= Database.provideConnection()){
			PreparedStatement pr= conn.prepareStatement("update batch set seat=? where bname=?");
			pr.setInt(1, seat);
			pr.setString(2, bname);
			int x=pr.executeUpdate();
			if(x>0)
			{
				mes="Updation successfull...";
				
			}else
			{
				mes="Invalid batch name";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return mes;
		
		
		
	}

	@Override
	public List getStudentEveryBatch() throws BatchException, CourseException {
		
		List ll=null;
		
		try (Connection conn= Database.provideConnection()){
			PreparedStatement pr=  conn.prepareStatement("select s.stId, s.stname, c.courseId,c.cname,b.bname from student s inner join course c on s.courseID=c.courseId inner join batch b on c.courseId=b.courseId");
			ResultSet rs= pr.executeQuery();
			
			while(rs.next())
			{
				ll=new ArrayList<>();
				ll.add(rs.getInt("stId"));
				ll.add(rs.getString("stname"));
				ll.add(rs.getInt("courseId"));
				ll.add(rs.getString("cname"));
				ll.add(rs.getString("bname"));
				
				System.out.println(ll);
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		return ll;
		
		
	}

	@Override
	public String resisterStudent(Student s) throws StudentException, CourseException {
		String mes=null;
		try (Connection conn= Database.provideConnection()){
			
		PreparedStatement pr=	conn.prepareStatement("insert into student (courseId,stname,email,password) values(?,?,?,?)");
			pr.setInt(1, s.getCourseId());
			pr.setString(2, s.getStname());
			pr.setString(3, s.getEmail());
			pr.setString(4, s.getPassword());
			
			int x=pr.executeUpdate();
			if(x>0)
			{
				mes="Student resister successfully....";
			}else
			{
				mes="NOt done..";
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
		
		
		return mes;
	}

	@Override
	public void loginStudent(String email, String password) throws StudentException {
		
		
		List newll=null;
		
		try (Connection conn= Database.provideConnection()){
			 PreparedStatement pr= conn.prepareStatement("select s.stId, s.stname,c.cname,s.email,b.bname from student s inner join course c on s.courseID=c.courseId inner join batch b on c.courseId=b.courseId where email=? and password=?");
			  pr.setString(1, email);
			  pr.setString(2, password);
			 ResultSet rs= pr.executeQuery();
			if(rs.next())
			{
				newll=new ArrayList<>();
				newll.add(rs.getInt("stId"));
				newll.add(rs.getString("stname"));
				newll.add(rs.getString("cname"));
				newll.add(rs.getString("email"));
				newll.add(rs.getString("bname"));
				System.out.println(newll);
			}
			else
			{
				System.out.println("invalid Input either username or password");
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

	@Override
	public List viewCoursesSeat() throws BatchException, CourseException {
		List ll=null;
		
		try (Connection conn= Database.provideConnection()){
			PreparedStatement pr= conn.prepareStatement("select c.cname,c.courseId,b.seat from course c inner join batch b on b.courseId=c.courseId");
			ResultSet rs= pr.executeQuery();
			
			while(rs.next())
			{
				ll=new ArrayList<>();
				ll.add(rs.getString("cname"));
				ll.add(rs.getInt("courseId"));
				ll.add(rs.getInt("seat"));
				System.out.println(ll);
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return ll;
	}

	@Override
	public String resisterAdmin(String username, String password) {
		String s=null;
		
		try (Connection conn= Database.provideConnection()){
			
			 PreparedStatement pr=  conn.prepareStatement("insert into admin values(?,?)");
			pr.setString(1, username);
			pr.setString(2, password);
			int x=pr.executeUpdate();
			if(x>0)
			{
				s="resistration successfull....";
			}else
			{
				s="not done...";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return s;
		
		
	}

	@Override
	public boolean adminLogin(String username, String password) {
		boolean mes=false;
		
		try (Connection conn= Database.provideConnection()){
			  PreparedStatement pr= conn.prepareStatement("select username, password from admin where username=? and password=?");
			pr.setString(1, username);
			pr.setString(2, password);
		 ResultSet rs=	pr.executeQuery();
			if(rs.next())
			{
				mes=true;
			}else
			{
				mes=false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		return mes;
		
		
	}

	


	
	
	
	
	

}
