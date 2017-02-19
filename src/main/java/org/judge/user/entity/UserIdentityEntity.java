package org.judge.user.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by manish on 10/02/17.
 */
@Data
@Entity
@Table(name = "user_identity",
        uniqueConstraints = @UniqueConstraint(name = "name_value_constraint", columnNames = {"identity_name", "identity_value"}))
public class UserIdentityEntity {

    @Lob
    @Column(name = "type")
    String type;

    @Lob
    @Column(name = "identifier")
    String identifier;

    @Lob
    @Column(name = "secret")
    String secret;

    /**
     * This will be a JSON string stored in DB
     */
    @Lob
    @Column(name = "properties")
    String properties;
}
