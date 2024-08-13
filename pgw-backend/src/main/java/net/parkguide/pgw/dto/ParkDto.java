package net.parkguide.pgw.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ParkDto {
    private long id;
    private String parkName;
    private String parkCountry;
    private String parkCity;
    private long price;
    private String webLink;
}
