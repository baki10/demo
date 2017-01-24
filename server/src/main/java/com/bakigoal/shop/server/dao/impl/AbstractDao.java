package com.bakigoal.shop.server.dao.impl;

import com.bakigoal.shop.server.dao.Dao;
import com.bakigoal.shop.server.model.base.Identified;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public abstract class AbstractDao<E extends Identified> implements Dao<E> {

  private SessionFactory sessionFactory;
  private Class<E> entityClass;

  public AbstractDao(Class<E> eClass) {
    entityClass = eClass;
  }

  @Autowired
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  protected Session getSession() {
    return this.sessionFactory.getCurrentSession();
  }

  protected Class<E> getEntityClass() {
    return entityClass;
  }

  @Override
  public Serializable save(E e) {
    return getSession().save(e);
  }

  @Override
  public void saveOrUpdate(E e) {
    getSession().saveOrUpdate(e);
  }

  @Override
  public List<E> getAll() {
    return getSession().createQuery("from " + getEntityClass().getName(), getEntityClass()).list();
  }

  @Override
  public E get(Serializable id) {
    return getSession().get(getEntityClass(), id);
  }

  @Override
  public E load(Serializable id) {
    return getSession().load(getEntityClass(), id);
  }

  @Override
  public void update(E e) {
    getSession().update(e);
  }

  @Override
  public void delete(E e) {
    getSession().delete(e);
  }

  @Override
  public void delete(Serializable id) {
    getSession().delete(load(id));
  }

  @Override
  public void deleteAll() {
    getSession().createQuery("delete " + getEntityClass().getName()).executeUpdate();
  }

  @Override
  public long count() {
    return (long) getSession().createQuery("Select count(*) from " + getEntityClass().getName()).uniqueResult();
  }

  @Override
  public boolean exists(Serializable id) {
    return get(id) != null;
  }
}
