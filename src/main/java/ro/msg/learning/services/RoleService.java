package ro.msg.learning.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import ro.msg.learning.exception.UserIsAlreadyAdminException;
import ro.msg.learning.entities.User;
import ro.msg.learning.entities.UserRole;
import ro.msg.learning.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class RoleService {

    private final UserRepository userRepository;

    @Autowired
    public RoleService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public void changeRole(Long userId) {
        User user = userRepository.findByUserId(userId);
        List<String> roleList = new ArrayList<>();
        for(UserRole userRole : user.getRoles()){
            roleList.add(userRole.getRole());
        }
        if(!roleList.contains("ADMIN")){
            user.getRoles().add(new UserRole("ADMIN"));
            userRepository.save(user);
        }else{
            throw new UserIsAlreadyAdminException("User with userid: "+userId+" is already admin");
        }
    }
}
