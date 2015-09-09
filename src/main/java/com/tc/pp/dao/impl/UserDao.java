package com.tc.pp.dao.impl;


import org.springframework.stereotype.Repository;

import com.tc.pp.dao.IUserDao;
import com.tc.pp.dao.common.AbstractHibernateDao;
import com.tc.pp.model.User;

@Repository("usersDao")
public class UserDao extends AbstractHibernateDao<User> implements IUserDao {

    public UserDao() {
        super();
        
        setClazz(User.class);
    }
}
