package ro.msg.learning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.msg.learning.entities.User;
import ro.msg.learning.entities.UserRole;


@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>{

    User findByUserNameIgnoreCase(String username);

    User findByUserId(Long userId);

}
