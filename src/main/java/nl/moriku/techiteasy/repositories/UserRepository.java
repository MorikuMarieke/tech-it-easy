package nl.moriku.techiteasy.repositories;

import nl.moriku.techiteasy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
