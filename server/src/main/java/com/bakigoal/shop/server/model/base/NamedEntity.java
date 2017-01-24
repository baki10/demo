package com.bakigoal.shop.server.model.base;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NamedEntity extends BaseEntity {

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return super.toString() + ", name = " + name;
  }
}
