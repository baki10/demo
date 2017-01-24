package com.bakigoal.shop.server.model;

import com.bakigoal.shop.server.model.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Payments")
public class Payments extends BaseEntity {

  private Order order;
  private Double amount;
  private Date date;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
