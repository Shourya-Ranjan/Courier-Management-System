package dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import entities.Courier;
import exception.*;

public class CourierUserServiceImpl implements ICourierUserService {
	static Connection conn = CourierServiceDb.connection;

	@Override
	public long placeOrder(Courier courierObj) {

			boolean status=false;
			try {
				
				// Logic to generate random employee Id
				String qq="SELECT COUNT(*) from employee;";
				PreparedStatement pstmt = conn.prepareStatement(qq);
				ResultSet EmpCount=pstmt.executeQuery();
				EmpCount.next();
				int empID=(int) (Math.random() * EmpCount.getInt("COUNT(*)")) + 1;
				
				// Logic to insert values in courier
				String query = "INSERT INTO courier (SenderName, userId, SenderAddress, ReceiverName, ReceiverAddress, Weight, Status, TrackingNumber, DeliveryDate, empId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, CURDATE(), ?)";
				PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

				stmt.setString(1, courierObj.getSenderName());
				stmt.setInt(2, courierObj.getUserId());
				stmt.setString(3, courierObj.getSenderAddress()); 
				stmt.setString(4, courierObj.getReceiverName());
				stmt.setString(5, courierObj.getReceiverAddress());
				stmt.setDouble(6, courierObj.getWeight());
				stmt.setString(7, "Pending");
				stmt.setDouble(8, Courier.SysTrackingNumber);
				stmt.setInt(9, empID);


				// Execute the prepared statement
				status=stmt.executeUpdate()>0;

				 if(status) {
					 System.out.println("Order Placed Successfully!!");
					 return Courier.SysTrackingNumber;
				 }
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
			return -1;
		
	}

	@Override
	public String getOrderStatus(long trackingNumber) {

		try {
			Statement stmt = conn.createStatement();
			String query = "select * from courier where trackingNumber='" + trackingNumber + "';";
//			System.out.println(query);

			ResultSet res = stmt.executeQuery(query);

			String result;
			if (res.next()) {
				result = res.getString("status");
				return result;
			} else {
				throw new TrackingNumberNotFoundException(trackingNumber);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return " ";
	}

	@Override
	public boolean cancelOrder(long trackingNumber) {

		boolean status = false;
		try {
			Statement stmt = conn.createStatement();
			String query = "delete from courier where trackingNumber='" + trackingNumber + "';";
//			System.out.println(query);
			stmt.execute("use courier");
			// System.out.println(stmt.execute(query));
			status= stmt.executeUpdate(query)>0;
			// System.out.println(a);
			if(status) {
				return status;
			}
			else {
				throw new TrackingNumberNotFoundException(trackingNumber);
			}
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return status;

	}

	@Override
	public ArrayList<Courier> getAssignedOrders(int empid) 
	{
		try {
			Statement stmt = conn.createStatement();
			String query = "select  * from courier where empid=" + empid + ";";
//			System.out.println(query);
			ResultSet res = stmt.executeQuery(query);
			
			ArrayList<Courier> arr = new ArrayList<Courier>();//Creating array list
			while (res.next()) {
				arr.add(new Courier(res.getInt("courierID"),res.getString("senderName"),res.getString("senderAddress"),res.getString("receiverName"),res.getString("receiverAddress"),res.getDouble("weight"),res.getString("status"),
						res.getLong("trackingNumber"),res.getString("deliveryDate"),res.getInt("userId"),res.getInt("empid")));
			}
			if(arr.isEmpty()) {
				throw new InvalidEmployeeIdException(empid);
			}
			
			return arr;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public void getOrderHistory(long trackingNumber) {
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from courier where trackingNumber='" + trackingNumber + "';";
			ResultSet res = stmt.executeQuery(query);
			if(res==null) {
				throw new TrackingNumberNotFoundException(trackingNumber);
			}

			if (res.next()) {
				String status = res.getString("status");
				String senderName = res.getString("senderName");
				String deliveryDate = res.getString("deliveryDate");
				if (status.equals("Pending"))
				{
					System.out.println("-------------Courier Order History---------------");
					System.out.println("-------------------------------------------------");
			        System.out.printf("| %-20s | %-23s |\n", "Field", "Value");
			        System.out.println("-------------------------------------------------");
			        System.out.printf("| %-20s | %-23s |\n", "Courier Sent by", senderName);
			        System.out.printf("| %-20s | %-23s |\n", "Expected Delivery by", deliveryDate);
			        System.out.printf("| %-20s | %-23s |\n", "Status", "Pending");
			        System.out.println("-------------------------------------------------");
				}
				else if (status.equals("In Transit")) {
				System.out.println("-------------Courier Status Report---------------");
				System.out.println("-------------------------------------------------");
		        System.out.printf("| %-20s | %-23s |\n", "Field", "Value");
		        System.out.println("-------------------------------------------------");
		        System.out.printf("| %-20s | %-23s |\n", "Courier Sent by", senderName);
		        System.out.printf("| %-20s | %-23s |\n", "Expected Delivery by", deliveryDate);
		        System.out.printf("| %-20s | %-23s |\n", "Status", "In Transit");
		        System.out.println("-------------------------------------------------");
				}
				else {
					System.out.println(
							"Courier Sent by : " + senderName + "\nDelivered on : " + deliveryDate);
			}}} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
