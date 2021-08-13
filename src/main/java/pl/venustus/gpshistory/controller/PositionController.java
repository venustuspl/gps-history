package pl.venustus.gpshistory.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.venustus.gpshistory.domain.Position;
import pl.venustus.gpshistory.domain.PositionDto;
import pl.venustus.gpshistory.mapper.PositionMapper;
import pl.venustus.gpshistory.service.PositionService;

@Controller
@CrossOrigin
@RequestMapping("/positions")
public class PositionController {
    private final PositionService positionService;
    private final PositionMapper positionMapper;

    public PositionController(PositionService positionService, PositionMapper positionMapper) {
        this.positionService = positionService;
        this.positionMapper = positionMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<Position> add(@RequestBody PositionDto positionDto) {
        try {
            Position position = positionService.addPosition(positionMapper.mapToPosition(positionDto));
            return new ResponseEntity<>(position, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}