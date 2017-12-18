package ro.msg.learning.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.entities.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{


}
