package pl.venustus.gpshistory.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.venustus.gpshistory.domain.Position;
import pl.venustus.gpshistory.domain.PositionDto;
import pl.venustus.gpshistory.service.PositionService;

import static org.mockito.Mockito.mock;

class PositionMapperTest {
    private final PositionService positionService = mock(PositionService.class);
    private PositionMapper positionMapper;

    @BeforeEach
    void setUp() {
        positionMapper = new PositionMapper(positionService);
    }

    @Test
    void shouldMapedPositonDtoPropertiesBeEqualsToPositionProperties() {
        //given
        PositionDto positionDto = new PositionDto("123", 1234, 12345);

        //when
        Position position = positionMapper.mapToPosition(positionDto);

        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(position.getDeviceId(), positionDto.getDeviceId()),
                () -> Assertions.assertEquals(position.getLatitude(), positionDto.getLatitude()),
                () -> Assertions.assertEquals(position.getLongitude(), positionDto.getLongitude())
        );
    }
}