package com.bakigoal.shop.server.service;

import com.bakigoal.shop.server.model.Product;

import java.util.List;

public interface ProductService extends BaseService<Product> {

  List<Product> findByName(String name);

}
