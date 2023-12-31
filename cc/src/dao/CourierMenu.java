package dao;

import entities.Courier;

import java.util.ArrayList;
import java.util.Scanner;

public class CourierMenu {

    public static void couriermenu() {
        
        Scanner scanner = new Scanner(System.in);
        CourierUserServiceImpl obj=new CourierUserServiceImpl();
        int choice;

        do {
            System.out.println("1. Place an order\n"
            		+ "2. Get Order Status\n"
            		+ "3. Cancel Order\n"
            		+ "4. Get Assigned Orders\n"
            		+ "5. Get Order History\n"
            		+ "6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    // Place Order
                	Courier courierObject = new Courier();
                	System.out.println("Enter  senderName: ");
                    String senderName = scanner.nextLine();
                    courierObject.setSenderName(senderName);
                    System.out.println("Enter  senderAddress: ");
                    String senderAddress = scanner.nextLine();
                    courierObject.setSenderAddress(senderAddress);
                    System.out.println("Enter receiverName : ");
                    String receiverName = scanner.nextLine();
                    courierObject.setReceiverName(receiverName);
                    System.out.println("Enter  receiverAddress: ");
                    String receiverAddress = scanner.nextLine();
                    courierObject.setReceiverAddress(receiverAddress);
                    System.out.println("Enter parcel weight : ");
                    double weight = scanner.nextDouble();
                    courierObject.setWeight(weight);
                    scanner.nextLine();
                    System.out.println("Enter userId : ");
                    int userId = scanner.nextInt();
                    courierObject.setUserId(userId);

                    System.out.println("Placing a new courier order...");
                    long trackingId=obj.placeOrder(courierObject);
                    
                    System.out.println("Tracking Id Of your order is : "+trackingId);
                    break;

                case 2:
                    // Get Order Status
                    System.out.println("Enter tracking number to get order status:");
                    long trackingNumber=scanner.nextLong();  
                    String Status=obj.getOrderStatus(trackingNumber);
                    System.out.println("--------------Courier Order Status---------------");
                    System.out.println("-------------------------------------------------");
                    System.out.printf("| %-20s | %-23s|\n", "Field", "Value");
                    System.out.println("-------------------------------------------------");
                    System.out.printf("| %-20s | %-23s|\n", "Tracking Number", trackingNumber);
                    System.out.printf("| %-20s | %-23s|\n", "Status",Status) ;
                    System.out.println("-------------------------------------------------");
                    break;

                case 3:
                    // Cancel Order
                    System.out.println("Enter tracking number to cancel the order:");
                    trackingNumber=scanner.nextLong();
                                      
                    if (obj.cancelOrder(trackingNumber)) 
    				System.out.println("Order Cancelled!!");
                    break;

                case 4:
                    
                	System.out.println("Enter Employee id : ");
                    int empid=scanner.nextInt();
                    ArrayList<Courier> al=obj.getAssignedOrders(empid);
                    if(al!=null) {
                    	System.out.println("---------------------------------------------------------------------Courier Details-------------------------------------------------------------------------------------------------");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("| %-10s | %-15s | %-15s | %-15s | %-20s | %-10s | %-15s | %-15s | %-12s | %-10s | %-10s |\n",
                                "courierID", "senderName", "senderAddress", "receiverName", "receiverAddress", "weight", "status",
                                "trackingNumber", "deliveryDate", "userId", "empid");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                        for (Courier c : al) {
                            System.out.printf("| %-10d | %-15s | %-15s | %-15s | %-20s | %-10.2f | %-15s | %-15s | %-12s | %-10d | %-10d |\n",
                                    c.getCourierID(), c.getSenderName(), c.getSenderAddress(), c.getReceiverName(),
                                    c.getReceiverAddress(), c.getWeight(), c.getStatus(),c.getTrackingNumber(),
                                    c.getDeliveryDate(), c.getUserId(), c.getEmpId());
                        }

                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    
                    }
                    
        
                    break;

                case 5:
                    
                    System.out.println("Enter you tracking number to get courier history");
                    long tn=scanner.nextLong();
                    obj.getOrderHistory(tn);
                    break;
                    
                case 6:
                	System.out.println("!!Thanks For Using Courier Management System!!");
                	break;
                
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 6);

        scanner.close();
    }

}
