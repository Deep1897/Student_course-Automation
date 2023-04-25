package Administrator_usecases;

import Administration_implementation.AdminisratorImpl;
import Administrator_interfaces.Administrator;
import exception_part.BatchException;
import exception_part.CourseException;

public class GetStudentEveryBatch {

	public static void viewstbyBatch(){
		// TODO Auto-generated method stub
		
		
		Administrator admin=new AdminisratorImpl();
		System.out.println("[ stId , Stname , cId , bname ]");
		try {
			admin.getStudentEveryBatch();
		} catch (BatchException | CourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
