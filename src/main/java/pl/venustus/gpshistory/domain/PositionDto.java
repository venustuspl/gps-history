package pl.venustus.gpshistory.domain;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PositionDto {
    private String deviceId;
    private int latitude;
    private int longitude;
}
