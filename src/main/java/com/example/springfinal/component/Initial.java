package com.example.springfinal.component;

import com.example.springfinal.entity.User;
import com.example.springfinal.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@Transactional
public class Initial implements InitializingBean {
    @Autowired
    private PasswordEncoder pe;
    @Autowired
    private UserRepository ur;

    @Override
    public void afterPropertiesSet() throws Exception {
        if(ur.count()==0){
            User user=new User();
            user.setAuthority(User.ADMIN_AUTHORITY);
            user.setName("Jack");
            user.setNumber("200");
            user.setPassword(pe.encode(user.getNumber()));
            ur.save(user);
        }
    }
}
