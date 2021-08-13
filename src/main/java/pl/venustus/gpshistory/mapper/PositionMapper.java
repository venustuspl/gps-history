package pl.venustus.gpshistory.mapper;

import org.springframework.stereotype.Component;
import pl.venustus.gpshistory.domain.Position;
import pl.venustus.gpshistory.domain.PositionDto;
import pl.venustus.gpshistory.service.PositionService;

import java.time.LocalDateTime;

@Component
public class PositionMapper {
    private final PositionService positionService;

    public PositionMapper(PositionService positionService) {
        this.positionService = positionService;
    }

    public Position mapToPosition(PositionDto positionDto) {
        Position position = new Position();
        position.setDeviceId(positionDto.getDeviceId());
        position.setDateTime(LocalDateTime.now());
        position.setLatitude(positionDto.getLatitude());
        position.setLongitude(positionDto.getLongitude());

        return position;
    }
}
