package Administrator_usecases;

import Administration_implementation.AdminisratorImpl;
import Administrator_interfaces.Administrator;
import exception_part.BatchException;
import exception_part.CourseException;

public class ViewSeatcourse {
	
	public static void seatCourse() {
		System.out.println("courseName-----courseId------Seats");
		Administrator admin =new AdminisratorImpl();
		
		try {
			admin.viewCoursesSeat();
		} catch (BatchException | CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
