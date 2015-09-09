package com.tc.pp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tc.pp.dao.IUserDao;
import com.tc.pp.dao.common.IOperations;
import com.tc.pp.model.User;
import com.tc.pp.service.IUserService;
import com.tc.pp.service.common.AbstractService;

@Service("userService")
public class UserService extends AbstractService<User> implements IUserService {

    @Resource(name="usersDao")
    private IUserDao dao;
    
    public UserService() {
        super();
    }

    @Override
    protected IOperations<User> getDao() {
        return this.dao;
    }
}
