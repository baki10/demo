package com.bakigoal.shop.server.model;

import com.bakigoal.shop.server.model.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order extends BaseEntity {

  private Customer customer;
  private Address shippingAddress;
  private List<OrderDetail> orderDetails;
  private ShippingMethod shippingMethod;
  private Date orderDate;
  private String purchaseOrderNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "shipping_address_id")
  public Address getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(Address shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  @OneToMany(mappedBy = "order")
  public List<OrderDetail> getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(List<OrderDetail> orderDetails) {
    this.orderDetails = orderDetails;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "shipping_method_id")
  public ShippingMethod getShippingMethod() {
    return shippingMethod;
  }

  public void setShippingMethod(ShippingMethod shippingMethod) {
    this.shippingMethod = shippingMethod;
  }

  public String getPurchaseOrderNumber() {
    return purchaseOrderNumber;
  }

  public void setPurchaseOrderNumber(String purchaseOrderNumber) {
    this.purchaseOrderNumber = purchaseOrderNumber;
  }
}
