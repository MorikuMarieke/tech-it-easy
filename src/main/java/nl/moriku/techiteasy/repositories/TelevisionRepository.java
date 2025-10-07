package nl.moriku.techiteasy.repositories;

import nl.moriku.techiteasy.model.Television;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {

    public List<Television> findByBrandIgnoreCase(String brand);

}
