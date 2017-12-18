package ro.msg.learning.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import ro.msg.learning.entities.User;
import ro.msg.learning.entities.UserRole;

import java.util.*;

public class MyUserPrincipal extends User implements UserDetails {

    private List<UserRole> roles = new ArrayList<>();
    private List<String> rolesList = new ArrayList<>();

    public MyUserPrincipal(User user) {
        super(user);
        this.roles = user.getRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        for(UserRole userRole : roles) {
            rolesList.add(userRole.getRole());
        }
        String role = StringUtils.collectionToCommaDelimitedString(rolesList);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(role);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
