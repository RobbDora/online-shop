package ro.msg.learning.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_roles_table")
public class UserRole {

    @Id
    @GeneratedValue
    private Long roleId;

    private String role;

    public UserRole(){}

    public UserRole(String role){
        this.role = role;
    }
}
