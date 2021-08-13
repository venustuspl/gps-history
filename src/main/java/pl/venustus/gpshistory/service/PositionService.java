package pl.venustus.gpshistory.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.venustus.gpshistory.domain.Position;
import pl.venustus.gpshistory.repository.PositionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PositionService {
    public static final Logger LOGGER = LoggerFactory.getLogger(PositionService.class);
    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Transactional
    public Position addPosition(Position position) {
        if (position.getDeviceId().isEmpty()) {
            throw new NoSuchElementException("Any position must have deviceId!");
        } else {
            LOGGER.info("Saving position for: {}", position);
            return positionRepository.save(position);
        }
    }

    @Transactional
    public void deletePosition(Position position) {
        positionRepository.delete(position);
    }

    public Position getPositionById(Long positionId) {
        return positionRepository.findById(positionId)
                .orElseThrow(() -> new NoSuchElementException("Position with id: " + positionId + " not exists!"));
    }

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }
}
