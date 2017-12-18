package ro.msg.learning.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.msg.learning.models.MyUserPrincipal;
import ro.msg.learning.entities.User;
import ro.msg.learning.repositories.UserRepository;



@Slf4j
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
            User user = userRepository.findByUserNameIgnoreCase(username);
            if (user == null) {
                throw new UsernameNotFoundException("User with username: '"+username+"' was not found");
            }else {
                return new MyUserPrincipal(user);
            }
    }
}
