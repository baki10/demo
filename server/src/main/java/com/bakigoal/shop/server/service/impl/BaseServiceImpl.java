package com.bakigoal.shop.server.service.impl;

import com.bakigoal.shop.server.dao.Dao;
import com.bakigoal.shop.server.model.base.Identified;
import com.bakigoal.shop.server.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
@Service
public abstract class BaseServiceImpl<E extends Identified, D extends Dao<E>> implements BaseService<E> {

  private D dao;

  public BaseServiceImpl(D dao) {
    this.dao = dao;
  }

  protected D getDao() {
    return dao;
  }

  @Override
  public Serializable save(E entity) {
   return getDao().save(entity);
  }

  @Override
  public void saveOrUpdate(E entity) {
    getDao().saveOrUpdate(entity);
  }

  @Override
  public E get(Serializable id) {
    return getDao().get(id);
  }

  @Override
  public E load(Serializable id) {
    return getDao().load(id);
  }

  @Override
  public List<E> getAll() {
    return getDao().getAll();
  }

  @Override
  public void update(E entity) {
    getDao().update(entity);
  }

  @Override
  public void delete(E entity) {
    getDao().delete(entity);
  }

  @Override
  public void delete(Serializable id) {
    getDao().delete(id);
  }

  @Override
  public void deleteAll() {
    getDao().deleteAll();
  }

  @Override
  public long count() {
    return getDao().count();
  }

  @Override
  public boolean exists(Serializable id) {
    return getDao().exists(id);
  }
}
