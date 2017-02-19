package org.judge.user.repository;

import org.judge.user.entity.UserEntity;
import org.judge.user.entity.UserIdentityEntity;
import org.judge.user.pojo.UserIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by manish on 10/02/17.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findById(Long id);

    /**
     * This is supposed to return a user based on the given type and identifer for a {@link UserIdentity}
     * @param userIdentity {@link UserIdentity}
     * @return userEntity {@link UserEntity}
     */
    @Query("SELECT u From UserEntity u , UserIdentityEntity ui WHERE u.id = ui.userId AND ui.type = ?1 AND ui.identifier = ?2")
    UserEntity findByUserIdentity(String type, String identifier);

}
