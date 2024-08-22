package net.parkguide.pgw.repository;

import net.parkguide.pgw.entity.Park;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkRepository extends JpaRepository<Park, Long> {
    List<Park> findByCity(String city);
    List<Park> findByCountry(String city);

    List<Park> findByName(String name);

}
