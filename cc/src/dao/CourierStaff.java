package dao;
import java.util.Scanner;
import entities.Employee;

public class CourierStaff {

    public  void couriermenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        CourierAdminServiceImpl obj=new CourierAdminServiceImpl();
        do {
            //displayMenu();
            System.out.println("1. Add an Employee\n"
            		+ "2. Delete Employee\n"
            		+ "3. Update Courier Status\n"
            		+ "4. Get Employee List \n"
            		+ "5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
  
            switch (choice) {
                case 1:
                	System.out.println("Enter employeeid: ");   
                	int EmployeeID =scanner.nextInt();
                	scanner.nextLine();
                	System.out.println("Enter employee name: "); 
                	String Name=scanner.nextLine();
                	
                	System.out.println("Enter email: "); 
                	String email=scanner.nextLine();
                	
                	System.out.println("Enter phone number: "); 
                	String contactNumber=scanner.nextLine();
                	System.out.println("Enter employee role: "); 
                	String role=scanner.nextLine();
                	System.out.println("Enter salary: "); 
                	double salary=scanner.nextDouble();
                	Employee empobj=new Employee(EmployeeID,Name,email,contactNumber,role,salary);
                    System.out.println("Placing a new employee details...");
                 
                    obj.addCourierStaff(empobj);
                               

                    break;

                case 2:
                	System.out.println("Enter employeeid: ");   
                	int EmpID =scanner.nextInt();
                	obj.deleteEmployee(EmpID);
                    break;

                case 3:
                    // Cancel Order
                    System.out.println("Enter tracking number: ");
                    long trackingNumber=scanner.nextLong();
                    System.out.println("Enter status");
                    String status=scanner.next();
                    obj.courierStatusUpdate(trackingNumber,status);
                    break;

                case 4:
                	obj.employeeList();
                    break;
                case 5:  
                    System.out.println("!!Thanks For Using Courier Management System!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);
        scanner.close();
    }
}
