package com.tc.pp.dao.common;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.common.base.Preconditions;

@SuppressWarnings("unchecked")
public abstract class AbstractHibernateDao<T extends Serializable> implements IOperations<T> {
    
    private Class<T> clazz;
    
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    protected final void setClazz(final Class<T> clazzToSet) {
        this.clazz = Preconditions.checkNotNull(clazzToSet);
    }
    
    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public final T findOne(final long id) {
        return (T)getCurrentSession().get(clazz, id);
    }

  
    public final List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }


    public final void create(final T entity) {
         Preconditions.checkNotNull(entity);
         // getCurrentSession().persist(entity);
         getCurrentSession().saveOrUpdate(entity);
    }

   
    public final T update(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().update(entity);
        return entity;
        //return (T)getCurrentSession().merge(entity);
    }

   
    public final void delete(final T entity) {
         Preconditions.checkNotNull(entity);
         getCurrentSession().delete(entity);
    }

  
    public final void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }
    
}
