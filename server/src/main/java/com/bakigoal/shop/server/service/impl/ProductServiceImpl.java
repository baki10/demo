package com.bakigoal.shop.server.service.impl;

import com.bakigoal.shop.server.dao.ProductDao;
import com.bakigoal.shop.server.model.Product;
import com.bakigoal.shop.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product, ProductDao> implements ProductService {

  @Autowired
  public ProductServiceImpl(ProductDao dao) {
    super(dao);
  }

  @Override
  public List<Product> findByName(String name) {
    return getDao().findByName(name);
  }
}
