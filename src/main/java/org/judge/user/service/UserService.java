package org.judge.user.service;

import org.judge.user.pojo.User;
import org.judge.user.pojo.UserIdentity;

import java.util.List;

/**
 * Created by manish on 10/02/17.
 * This provides functions for Create, Read, Update operations for Users within the system.
 *
 */
public interface UserService {

    /**
     * Normal method to find a user by a given id
     * @param id {@link Long}
     * @return {@link User}
     */
    User findById(Long id);

    /**
     * Find a user by a given identity name and value
     * Eg. identity name=GITHUB, value= userName
     * @param userIdentity {@link UserIdentity}
     * @return {@link User}
     */
    User findByIdentity(UserIdentity userIdentity);

    /**
     * Find a user by the given identity's type and identifier
     *
     * @param type {@link String}
     * @param identifier {@link String}
     * @return User {@link User}
     */
    User findByIdentity(String type, String identifier);

    /**
     * Saves the given user while updating all the parameters
     * @param user {@link User}
     * @return {@link User}
     */
    User saveUser(User user);

    /**
     * Saves multiple users
     * @param users {@link User}
     * @return List {@link User}
     */
    List<User> saveUsers(List<User> users);

}
