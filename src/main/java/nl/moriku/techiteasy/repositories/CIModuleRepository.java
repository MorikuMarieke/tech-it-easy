package nl.moriku.techiteasy.repositories;

import nl.moriku.techiteasy.model.CIModule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CIModuleRepository extends JpaRepository<CIModule, Long> {
}
