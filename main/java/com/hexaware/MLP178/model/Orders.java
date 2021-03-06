package com.hexaware.MLP178.model;
import java.util.Objects;
import java.util.Date;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Orders {

/**
 * orderId to store orderId.
 */
  private int orderId;
  /**
 * customerId to store menu category.
 */
  private int customerId;
  /**
 * vendorId to store food name.
 */
  private int vendorId;
  /**
 * menuId to store quantity.
 */
  private int menuId1;
  /**
 * menuId to store quantity.
 */
  private int menuId2;
/**
 * menuId to store quantity.
 */
  private int menuId3;
  /**
 * orderStatus to store cost.
 */
  private OrderStatus orderStatus;
  /**
 * orderComments to store calories.
 */
  private String orderComments;
   /**
 * orderTotalamount to store food reviews.
 */
  private Double orderTotalamount;
   /**
 * orderTotalamount to store food reviews.
 */
  private Date orderDate;
   /**
 * orderQuantity to store food reviews.
 */
  private int orderQuantity;
    /**
 * orderQuantity to store food reviews.
 */
  private WalletType walletType;
  /**
   * Default Constructor.
   */
  public Orders() {

  }
/**
 * @param argOrderId to initialize food id.
 * used to get details through constructor.
 * @param argCustomerId to initialize food price.
 * @param argVendorId to initialize food Detail.
 * @param argMenuId1 to initialize food Status.
 * @param argMenuId2 to initialize food Status.
 * @param argMenuId3 to initialize food Status.
 * @param argOrderStatus to initialize food Rating.
 * @param argOrderComments to initialize food Rating.
 * @param argOrderTotalamount to initialize food Rating.
 * @param argOrderDate to initialize food Rating.
 * @param argOrderQuantity to initialize food Rating.
 * @param argWalletType to initialize food Rating.
 */
  public Orders(final int argOrderId, final int argCustomerId, final int argVendorId,
      final int argMenuId1, final int argMenuId2, final int argMenuId3, final OrderStatus argOrderStatus,
      final String argOrderComments, final Double argOrderTotalamount,
      final Date argOrderDate, final int argOrderQuantity, final WalletType argWalletType) {
    this.orderId = argOrderId;
    this.customerId = argCustomerId;
    this.vendorId = argVendorId;
    this.menuId1 = argMenuId1;
    this.menuId2 = argMenuId2;
    this.menuId3 = argMenuId3;
    this.orderStatus = argOrderStatus;
    this.orderComments = argOrderComments;
    this.orderTotalamount = argOrderTotalamount;
    this.orderDate = argOrderDate;
    this.orderQuantity = argOrderQuantity;
    this.walletType = argWalletType;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orders order = (Orders) obj;
    if (Objects.equals(orderId, order.orderId) && Objects.equals(customerId, order.customerId)
        && Objects.equals(menuId1, order.menuId1) && Objects.equals(menuId2, order.menuId2)
        && Objects.equals(menuId3, order.menuId3) && Objects.equals(orderComments, order.orderComments)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(orderId);
  }
  @Override
    public final String toString() {
    return String.format("%15s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s %15s", orderId, customerId, vendorId,
     menuId1, menuId2, menuId3, orderStatus, orderComments, orderTotalamount, orderDate, orderQuantity, walletType);
  }
    /**
     * @return this food ID.
     */
  public final int getOrderId() {
    return orderId;
  }
    /**
     * @param argOrderId gets the food id.
     */
  public final void setOrderId(final int argOrderId) {
    this.orderId = argOrderId;
  }
  /**
     * @return this menu category.
     */
  public final int getCustomerId() {
    return customerId;
  }
  /**
     * @param argCustomerId gets the menu category1.
     */
  public final void setCustomerId(final int argCustomerId) {
    this.customerId = argCustomerId;
  }
    /**
     * @return this menu item.
     */
  public final int getVendorId() {
    return vendorId;
  }
  /**
   * @param argVendorId gets the menu item.
   */
  public final void setVendorId(final int argVendorId) {
    this.vendorId = argVendorId;
  }
   /**
     * @return this menu quantity.
     */
  public final int getMenuId1() {
    return menuId1;
  }
  /**
   * @param argMenuId1 gets the menu Quantity.
   */
  public final void setMenuId1(final int argMenuId1) {
    this.menuId1 = argMenuId1;
  }
  /**
     * @return this menu quantity.
     */
    public final int getMenuId2() {
      return menuId2;
    }
  /**
   * @param argMenuId3 gets the menu Quantity.
   */
  public final void setMenuId3(final int argMenuId3) {
    this.menuId3 = argMenuId3;
  }
  /**
     * @return this menu quantity.
     */
    public final int getMenuId3() {
      return menuId3;
    }
  /**
   * @param argMenuId2 gets the menu Quantity.
   */
  public final void setMenuId2(final int argMenuId2) {
    this.menuId2 = argMenuId2;
  }
  /**
     * @return this menu cost.
     */
  public final OrderStatus getOrderStatus() {
    return orderStatus;
  }
  /**
   * @param argOrderStatus gets the menu Quantity.
   */
  public final void setOrderStatus(final OrderStatus argOrderStatus) {
    this.orderStatus = argOrderStatus;
  }
  /**
     * @return this menu calories.
     */
  public final String getOrderComments() {
    return orderComments;
  }
  /**
   * @param argOrderComments gets the menu Quantity.
   */
  public final void setOrderComments(final String argOrderComments) {
    this.orderComments = argOrderComments;
  }
  /**
     * @return this menu reviews.
     */
  public final Double getOrderTotalamount() {
    return orderTotalamount;
  }
  /**
   * @param pamount gets the menu reviews.
   */
  public final void setOrderTotalamount(final Double pamount) {
    this.orderTotalamount = pamount;
  }
  /**
     * @return this menu reviews.
     */
  public final Date getOrderDate() {
    return orderDate;
  }
  /**
   * @param argOrderDate gets the menu reviews.
   */
  public final void setOrderDate(final Date argOrderDate) {
    this.orderDate = argOrderDate;
  }
  /**
     * @return this menu reviews.
     */
  public final int getOrderQuantity() {
    return orderQuantity;
  }
  /**
   * @param argOrderQuantity gets the menu reviews.
   */
  public final void setOrderQuantity(final int argOrderQuantity) {
    this.orderQuantity = argOrderQuantity;
  }
  /**
     * @return this menu reviews.
     */
  public final WalletType getWalletType() {
    return walletType;
  }
  /**
   * @param argWalletType gets the menu reviews.
   */
  public final void setWalletType(final WalletType argWalletType) {
    this.walletType = argWalletType;
  }
public void setPromoCode(String pc) {
}
}
