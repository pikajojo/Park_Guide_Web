package net.parkguide.pgw.repository;

import net.parkguide.pgw.entity.Park;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkRepository extends JpaRepository<Park, Long> {
}
