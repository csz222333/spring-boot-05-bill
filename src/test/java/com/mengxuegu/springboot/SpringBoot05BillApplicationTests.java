package com.mengxuegu.springboot;

import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.entities.ProviderBill;
import com.mengxuegu.springboot.entities.User;
import com.mengxuegu.springboot.mapper.BillMapper;
import com.mengxuegu.springboot.mapper.ProviderMapper;
import com.mengxuegu.springboot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot05BillApplicationTests {

    @Autowired
    ProviderMapper providerMapper;
    @Autowired
    BillMapper billMapper;
    @Autowired
    UserMapper userMapper;
    @Test
    public void contextLoads() {
        User user=null;
        List<User> users = userMapper.getUsers(user);



    }
}
