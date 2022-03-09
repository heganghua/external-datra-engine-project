package com.jxzj.external.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jxzj.external.data.dao.users.User1Mapper;
import com.jxzj.external.data.entity.users.User1;
import com.jxzj.external.data.service.User1Server;

@Service
public class User1ServiceImpl implements User1Server {

    @Autowired
    User1Mapper user1Mapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addRequired(User1 user1) {
        user1Mapper.insert(user1);
    }

}
