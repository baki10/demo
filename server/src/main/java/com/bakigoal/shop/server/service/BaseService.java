package com.bakigoal.shop.server.service;

import com.bakigoal.shop.server.model.base.Identified;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Identified> {

  Serializable save(E entity);

  void saveOrUpdate(E entity);

  E get(Serializable id);

  E load(Serializable id);

  List<E> getAll();

  void update(E entity);

  void delete(E entity);

  void delete(Serializable id);

  void deleteAll();

  long count();

  boolean exists(Serializable id);
}
