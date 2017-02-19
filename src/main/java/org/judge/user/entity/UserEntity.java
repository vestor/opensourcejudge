package org.judge.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by manish on 10/02/17.
 */
@Data
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue
    Long id;

    @GeneratedValue
    Date createdAt;

    @GeneratedValue
    Date updatedAt;

    /**
     * Normal Many to one relationship for maintaining multiple identities for a user.
     * Got this idea from a friend @vaibhavsinha
     */
    @JoinColumn(name = "user_id",nullable = false)
    @ManyToOne(targetEntity = UserIdentityEntity.class, fetch = FetchType.EAGER)
    List<UserIdentityEntity> identities;


}
