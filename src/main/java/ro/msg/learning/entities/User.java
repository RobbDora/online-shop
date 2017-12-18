package ro.msg.learning.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue
    private Long userId;

    private String userName;

    @JsonIgnore
    private String password;


    public User(User user){
        this.userId = user.userId;
        this.userName = user.userName;
        this.password = user.password;
        this.roles = user.roles;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles_table", joinColumns = {@JoinColumn(name = "fk_user")},
            inverseJoinColumns = {@JoinColumn(name = "fk_role")})
    private List<UserRole> roles = new ArrayList<>();
}

