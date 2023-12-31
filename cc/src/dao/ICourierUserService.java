package dao;
import java.util.*;

import entities.Courier;
//ICourierUserService Interface
public interface ICourierUserService {
 // functions only available to users...
    long placeOrder(Courier courierObj);

    String getOrderStatus(long trackingNumber);

    boolean cancelOrder(long trackingNumber);

    List<Courier> getAssignedOrders(int courierStaffId);
}

