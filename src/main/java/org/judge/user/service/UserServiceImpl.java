package org.judge.user.service;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.judge.Mapper;
import org.judge.user.entity.UserEntity;
import org.judge.user.pojo.User;
import org.judge.user.pojo.UserIdentity;
import org.judge.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;

/**
 * Created by manish on 10/02/17.
 * Implementation of UserService
 */
@Component
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Mapper mapper;

    @Override
    public User findById(Long id) {
        if(id == null) {
            log.error("User Id is null");
            throw new IllegalArgumentException("User's id cannot be null");
        }
        return mapper.convertValue(userRepository.findById(id), User.class);
    }

    @Override
    public User findByIdentity(UserIdentity userIdentity) {
        if(!userIdentity.valid()) {
            log.error("UserIdentity invalid {}", userIdentity);
            throw new IllegalArgumentException("User identity is invalid");
        }
        return mapper.convertValue(userRepository.findByUserIdentity(userIdentity.getType(), userIdentity.getIdentifier()), User.class);
    }

    @Override
    public User findByIdentity(String type, String identifier) {
        return findByIdentity(new UserIdentity(type, identifier));
    }

    @Override
    public User saveUser(User user) {
        return mapper.convertValue(userRepository.save(mapper.convertValue(user, UserEntity.class)), User.class);
    }

    @Override
    public List<User> saveUsers(List<User> users) {
        return mapper.convertValue(userRepository.save((List<UserEntity>)mapper.convertValue(users, new TypeReference<List<UserEntity>>() {})), new TypeReference<List<User>>(){});

    }
}
