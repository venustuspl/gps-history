package pl.venustus.gpshistory.controller;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.venustus.gpshistory.domain.Position;
import pl.venustus.gpshistory.domain.PositionDto;
import pl.venustus.gpshistory.mapper.PositionMapper;
import pl.venustus.gpshistory.service.PositionService;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PositionController.class)
public class PositionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PositionMapper positionMapper;

    @MockBean
    private PositionService positionService;

    @Test
    public void shouldSavePositionDto() throws Exception {
        //Given
        Position position = new Position(12L, "123", LocalDateTime.now(), 1234, 12345);
        PositionDto positionDto = new PositionDto("123", 1234, 12345);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(positionDto);

        //When
        when(positionMapper.mapToPosition(positionDto)).thenReturn(position);
        when(positionService.addPosition(positionMapper.mapToPosition(ArgumentMatchers.any(PositionDto.class)))).thenReturn(position);

        //Then
        mockMvc.perform(post("/positions/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(status().is2xxSuccessful());
    }
}