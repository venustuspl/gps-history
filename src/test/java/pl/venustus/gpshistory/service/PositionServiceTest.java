package pl.venustus.gpshistory.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import pl.venustus.gpshistory.domain.Position;
import pl.venustus.gpshistory.repository.PositionRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PositionServiceTest {
    private final PositionRepository positionRepository = mock(PositionRepository.class);
    private PositionService positionService;

    @BeforeEach
    void setUp() {
        positionService = new PositionService(positionRepository);
    }

    @Test
    void shouldReturnEqualSavedObjectAsGiven() {
        //given
        Position position = new Position();
        position.setDeviceId("123");
        position.setLongitude(1234);
        position.setLongitude(12345);
        when(positionRepository.save(any(Position.class))).then(AdditionalAnswers.returnsFirstArg());

        //when
        Position addedPosition = positionService.addPosition(position);

        //then
        assertEquals(addedPosition, position);
    }
}