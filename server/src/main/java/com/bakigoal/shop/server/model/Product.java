package com.bakigoal.shop.server.model;

import com.bakigoal.shop.server.model.base.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Product extends NamedEntity {

  private Double unitPrice;

  public Double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }
}
