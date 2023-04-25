package Administrator_usecases;

import java.util.Scanner;

import Administration_implementation.AdminisratorImpl;
import Administrator_interfaces.Administrator;
import exception_part.BatchException;

public class Updateseat {

	public static void updateseat() {
		
		Scanner sc =new Scanner(System.in);
		System.out.println("please enter the seat in number to be update ");
		int seat=sc.nextInt();
		System.out.println("please Enter the batch name to be updated");
		String bname=sc.next();
		
		Administrator admin=new AdminisratorImpl();
		try {
			String s=admin.updateSeatOfBatch(seat, bname);
			System.out.println(s);
		} catch (BatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
