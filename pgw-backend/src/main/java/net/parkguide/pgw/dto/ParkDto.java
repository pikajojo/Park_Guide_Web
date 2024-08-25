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
    private String name;
    private String country;
    private String city;
    private long price;
    private String weblink;
}
