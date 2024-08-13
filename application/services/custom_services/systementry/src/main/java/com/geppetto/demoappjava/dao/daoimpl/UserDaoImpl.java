package com.geppetto.demoappjava.dao.daoimpl;

import com.geppetto.demoappjava.model.User;
import com.geppetto.demoappjava.repository.UserRepository;
import com.geppetto.demoappjava.dao.UserDao;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao{

    private final UserRepository userRepository;

     public UserDaoImpl(UserRepository userRepository) {
       this.userRepository = userRepository;
}





}
