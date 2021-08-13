package pl.venustus.gpshistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.venustus.gpshistory.domain.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
}
