package willydekeyser.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import willydekeyser.springbootjpa.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    boolean existsByName(String name);
}
