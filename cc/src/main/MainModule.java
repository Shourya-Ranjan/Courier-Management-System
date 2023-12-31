package main;
import java.util.*;
import dao.CourierMenu;
import dao.CourierServiceDb;
import dao.CourierStaff;
public class MainModule {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);	
		CourierServiceDb dbCon=	new CourierServiceDb();
		System.out.println("Are you user or Admin??");
		String us=sc.next();
		if (us.equalsIgnoreCase("Admin"))
		{
			System.out.println(".................Welcome Admin.................");
			CourierStaff staffobj=new CourierStaff();
			staffobj.couriermenu();
		}
		else
		{
			System.out.println(".................Welcome "+us+".................");
			CourierMenu.couriermenu();		
		}
		dbCon.closeConnection();
		sc.close();
		
	}
}
