package com.hexaware.MLP178.factory;

import com.hexaware.MLP178.persistence.OrderDAO;
//import com.hexaware.MLP178.persistence.CustomerDAO;
import com.hexaware.MLP178.persistence.DbConnection;

import java.util.List;
import java.text.ParseException;
import java.util.Calendar;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;

//import com.hexaware.MLP178.model.Customer;
import com.hexaware.MLP178.model.Freegift;
import com.hexaware.MLP178.model.Menu;
import com.hexaware.MLP178.model.Orders;
import com.hexaware.MLP178.model.Wallet;
import com.hexaware.MLP178.model.GstDemo;
import com.hexaware.MLP178.model.WalletType;
import com.hexaware.MLP178.model.OrderStatus;

/**
 * MenuFactory class used to fetch menu data from database.
 * 
 * @author hexware
 */
public class OrderFactory {
  /**
   * Protected constructor.
   */
  protected OrderFactory() {

  }

  /**
   * Call the data base connection.
   * 
   * @return the connection object.
   */
  public static OrderDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrderDAO.class);
  }

  /**
   * Call the data base connection.
   * 
   * @return the array of menu object.
   */
  public static Orders[] showOrder() {
    List<Orders> order = dao().show();
    return order.toArray(new Orders[order.size()]);
  }

  /**
   * Show Customer Orders History.
   * 
   * @param custId for pending orders.
   * @return the array of order object.
   */
  public static Orders[] showCustomerHistory(final int custId) {
    List<Orders> order = dao().customerHistory(custId);
    return order.toArray(new Orders[order.size()]);
  }
  /**
   * call the database connection.
   * @param customerGender gor getting gender of customer.
   * @return the gender value.
   */

  public static int getGender(final int customerGender) {
    int gndr = dao().getGender(customerGender);
    return gndr;
  }

  /**
   * Show Vendor Orders History.
   * 
   * @param vendId for pending orders.
   * @return the array of order object.
   */
  public static Orders[] showVendorHistory(final int vendId) {
    List<Orders> order = dao().vendorHistory(vendId);
    return order.toArray(new Orders[order.size()]);
  }

  /**
   * Show Customer Pending Orders.
   * 
   * @param custId for pending orders.
   * @return the array of order object.
   */
  public static Orders[] showpendingCustomerOrders(final int custId) {
    List<Orders> order = dao().pendingCustomer(custId);
    return order.toArray(new Orders[order.size()]);
  }

  /**
   * Show Customer Pending Orders.
   * 
   * @param vendId for pending orders.
   * @return the array of order object.
   */
  public static Orders[] showpendingVendorOrders(final int vendId) {
    List<Orders> order = dao().pendingVendor(vendId);
    return order.toArray(new Orders[order.size()]);
  }

  /**
   * Show Customer Pending Orders.
   * 
   * @param venId for pending orders.
   * @return the array of order object.
   */
  public static double showgstbyMonth(final int venId) {
    double res = dao().findByGst(venId);
    return res;
  }

  /**
   * Show Customer Pending Orders.
   * 
   * @param gstDemo for pending orders.
   * @return the array of order object.
   */
  public static String payGst(final GstDemo gstDemo) {
    dao().payGst(gstDemo);
    return "Gst Stored...";
  }
  /**
   * Show Customer Orders History.
   * @param custId for pending orders.
   * @return the array of order object.
   */
  public static int showCountbyorder(final int custId) {
    int res = dao().countbyOrder(custId);
    return res;
  }
    /**
   * Show Customer Orders History.
   * @param custId for pending orders.
   * @return the array of order object.
   */
  public static int countgiftbyCusId(final int custId) {
    int res1 = dao().countgiftbyCus(custId);
    return res1;
  }
   /**
   * Show Customer Pending Orders.
   * @param freegift for pending orders.
   * @return the array of order object.
   */
  public static String freeExtragift(final Freegift freegift) {
    dao().freegift(freegift);
    return "You are getting 5 ladoos";
  }
  /**
   * Show Customer Orders History.
   * @param custId for pending orders.
   * @return the array of order object.
   */
  public static int checkGender(final int custId) {
    int res1 = dao().checkGender1(custId);
     return res1;
  }
  /**
   * Show Vendor Orders History.
   * @param orderId  for accept or reject.
   * @param vendorId for accept or reject.
   * @param status   for changing status.
   * @return the array of order object.
   */
  public static String acceptOrRejectOrder(final int orderId, final int vendorId, final String status) {
    Orders order = dao().findByOrderId(orderId);
    String result = "";
    if (order != null) {
      if (order.getVendorId() == vendorId) {
        if (status.equals("ACCEPTED")) {
          dao().acceptOrReject(status, orderId);
          result = "Order Accepted Successfully...";
        }
        if (status.equals("REJECTED")) {
          dao().acceptOrReject(status, orderId);
          WalletType type = order.getWalletType();
          int custId = order.getCustomerId();
          double billAmount = order.getOrderTotalamount();
          dao().refundAmount(billAmount, type, custId);
          result = "Order Rejected and Amount Refunded...";
        }
      } else {
        result = "You are Unauthorized Vendor for this order...";
      }
    } else {
      result = "Invalid OrderId...";
    }
    return result;
  }

  /**
   * Show Vendor Orders History.
   * 
   * @param orderId for accept or reject.
   * @param custId  for accept or reject.
   * @param status  for changing status.
   * @return the array of order object.
   */
  public static String cancelOrder(final int orderId, final int custId, final String status) {
    Orders order = dao().findByOrderId(orderId);
    String result = "";
    if (order != null) {
      if (status.equals("YES")) {
        String st = "REJECTED";
        dao().acceptOrReject(st, orderId);
        double billAmount = order.getOrderTotalamount();
        WalletType type = order.getWalletType();
        billAmount = billAmount - (billAmount / 10);
        dao().refundAmount(billAmount, type, custId);
        result = ("Order Cancelled Successfully and Amount refunded to " + type);
      }
    } else {
      result = "Invalid OrderId...";
    }
    return result;
  }

  /**
   * Place order for customer.
   * 
   * @param order for accepting order details.
   * @return order status.
   * @throws ParseException
   */
  public static String placeOrder(final Orders order) throws ParseException {
    Menu menu = dao().findByMenuId(order.getMenuId1());
    Menu menu1 = dao().findByMenuId(order.getMenuId2());
    Menu menu2 = dao().findByMenuId(order.getMenuId3());
    Wallet wallet = dao().getWalletInfo(order.getWalletType(), order.getCustomerId());
    System.out.println(wallet.getWalletAmount());
    double walAmount = wallet.getWalletAmount();

    double price1 = menu.getMenuCost();
    double price2 = menu1.getMenuCost();
    double price3 = menu2.getMenuCost();
    double price = price1+price2+price3;
    Date today = new Date();
    System.out.println(order.getOrderDate());
    long diffTime = order.getOrderDate().getTime() - today.getTime();
    long diffDays = diffTime / (60 * 60 * 1000 * 24);
    double totalAmount = price * order.getOrderQuantity();

    if (walAmount < totalAmount) {
      return "Insufficient Funds To Place the Order...";
    } else if (diffDays < 0) {
      return "Order Cannot be Placed yesterday...";
    } else {
      double diff = walAmount - totalAmount;
    int count =0;
    count=OrderFactory.checkGender(order.getCustomerId());
    Calendar calendar = Calendar.getInstance();
    Calendar calendar2 = Calendar.getInstance();
    calendar.setTime(order.getOrderDate());
   // calendar2.setTime(calendar2.get);
    //calendar2.setTime(calendar.);
    int ordermonth= calendar.get(Calendar.MONTH);
    int currentmonth= calendar2.get(Calendar.MONTH);
      {
        if (count == 1 && ordermonth == currentmonth) {
          System.out.println("Happy Women's Day");
          System.out.println("Your Order Price of menu 1 is  " + price1);
          System.out.println("Your Order Price of menu 2 is  " + price2);
          System.out.println("Your Order Price of menu 3 is  " + price3);
          order.setOrderStatus(OrderStatus.PENDING);
          order.setOrderTotalamount(totalAmount);
          dao().placeOrder(order);
          dao().updateBalance(diff, order.getWalletType(), order.getCustomerId());
        }
      }
    }
    return "Order Placed Successfully For the Registered Address...\nSoon you will be notified by our Vendor...";
  }
}
