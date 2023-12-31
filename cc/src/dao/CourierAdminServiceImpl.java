package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import entities.Employee;
import exception.*;

public class CourierAdminServiceImpl extends CourierUserServiceImpl implements ICourierAdminService{
	static Connection conn = CourierServiceDb.connection;
	@Override
	public boolean addCourierStaff(Employee Obj) {
				boolean status=false;
				try {
					Statement stmt=conn.createStatement();
					String query = "INSERT INTO employee VALUES (" +
							Obj.getEmployeeID() + ", " +
							"'" + Obj.getEmployeeName() + "', " +	
			                "'" + Obj.getEmail() + "', " +
			                "'" + Obj.getContactNumber() + "', "+
					"'" + Obj.getRole() + "', " +
					Obj.getSalary() +"); " ;
//					 System.out.println(query);
					return stmt.execute(query);	
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}			
				return status;	
		}
	public void courierStatusUpdate(long trackingNumber, String Status) {
		try {
			Statement stmt=conn.createStatement();
			String query = "update courier set status='"+Status+"' where trackingnumber='"+trackingNumber+"';";
			int a=stmt.executeUpdate(query);
			//System.out.println(a);
			if (a>0)
			{
				System.out.println("Updated status to "+Status+" for the tracking number "+trackingNumber);	
			}
			else
			{
				throw new TrackingNumberNotFoundException(trackingNumber);				
			}		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void employeeList() {
		try {
			Statement stmt=conn.createStatement();
			String query = "select  * from employee;";		
			ResultSet res= stmt.executeQuery(query);
			int c=0;
			 System.out.println("------------------------------------------------------------------------------------------------");
		     System.out.printf("| %-6s | %-14s | %-20s | %-30s | %-10s |\n", "S.no", "EmployeeID", "Name", "Email", "Salary");
		     System.out.println("------------------------------------------------------------------------------------------------");
		     while (res.next()) {
	                System.out.printf("| %-6d | %-14d | %-20s | %-30s | %-10.2f |\n",
	                        ++c, res.getInt("EmployeeId"), res.getString("Name"),
	                        res.getString("Email"), res.getDouble("salary"));
	            }
		      System.out.println("------------------------------------------------------------------------------------------------");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	public void deleteEmployee(int empid) {
		try {
			Statement stmt=conn.createStatement();
			String query = "delete from employee where employeeid="+empid+";";
			 
			int a=stmt.executeUpdate(query);
			if (a>0)
			{
				System.out.println("Employee Deleted Successfully!!");
			}
			else {
				throw new InvalidEmployeeIdException(empid);
			}	
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	
	}

}
