package org.judge.user.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by manish on 10/02/17.
 */
@Data
public class UserIdentity implements Serializable{

    public UserIdentity () {}

    public UserIdentity(String type, String identifier) {
        this.identifier = identifier;
        this.type = type;
    }

    String type;

    String identifier;

    String secret;

    Map<String, Object> properties;

    /**
     * Determines whether a given identity is valid or not.
     * Uses the blank check on type and identifer
     * @return {@link Boolean}
     */
    public Boolean valid() {
        return StringUtils.isNoneBlank(type, identifier);
    }
}
