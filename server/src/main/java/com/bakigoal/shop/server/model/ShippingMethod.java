package com.bakigoal.shop.server.model;

import com.bakigoal.shop.server.model.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Shipping_Methods")
public class ShippingMethod extends BaseEntity {
  private String method;

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }
}
