package Administrator_interfaces;

import java.util.List;

import Bean_classes.Batch;
import Bean_classes.Course;
import Bean_classes.Student;
import exception_part.BatchException;
import exception_part.CourseException;
import exception_part.StudentException;

public interface Administrator {
	
	public String addNewCourse(Course c) throws CourseException;
	
	public String updateFeeCourse(int cfee, String cname) throws CourseException; 
	
	public String deleteCourse(String cname)throws CourseException;
	
	public Course getInfoCourse(String cname) throws CourseException;
	
	public String createBatch(Batch c)throws BatchException;
	
	public List getStudentBatchByCourse(String cname)throws CourseException,BatchException;
	
	public String updateSeatOfBatch(int seat,String bname)throws BatchException;
	
	public List getStudentEveryBatch()throws BatchException,CourseException;
	
	public String resisterStudent(Student s) throws StudentException,CourseException;
	
	public void loginStudent(String email,String password)throws StudentException;
	
	public List viewCoursesSeat()throws BatchException,CourseException;
	
	public String resisterAdmin(String username,String password);
	
	public boolean adminLogin(String username,String password);


}
