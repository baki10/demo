package com.bakigoal.shop.server.dao;

import com.bakigoal.shop.server.model.Product;

import java.util.List;

public interface ProductDao extends Dao<Product>{

  List<Product> findByName(String name);
}
