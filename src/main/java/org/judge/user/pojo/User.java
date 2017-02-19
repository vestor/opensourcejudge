package org.judge.user.pojo;

import lombok.Data;
import org.judge.user.entity.UserIdentityEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by manish on 10/02/17.
 */
@Data
public class User implements Serializable {

    Long id;
    List<UserIdentityEntity> identityList;

}
