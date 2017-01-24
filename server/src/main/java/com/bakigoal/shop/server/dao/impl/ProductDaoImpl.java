package com.bakigoal.shop.server.dao.impl;

import com.bakigoal.shop.server.dao.ProductDao;
import com.bakigoal.shop.server.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao {

  public ProductDaoImpl() {
    super(Product.class);
  }

  @Override
  public List<Product> findByName(String name) {
    return getSession().createQuery("select p from Product p where p.name like :name", Product.class)
        .setParameter("name", name + "%").list();
  }
}
