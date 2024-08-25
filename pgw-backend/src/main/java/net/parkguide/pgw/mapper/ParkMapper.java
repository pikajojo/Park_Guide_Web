package net.parkguide.pgw.mapper;

import net.parkguide.pgw.dto.ParkDto;
import net.parkguide.pgw.entity.Park;

public class ParkMapper {
    public static ParkDto mapToParkDto(Park park) {
        return new ParkDto(
                park.getId(),
                park.getName(),
                park.getCountry(),
                park.getCity(),
                park.getPrice(),
                park.getWeblink());
    }

    public static Park mapToPark(ParkDto parkDto) {
        return new Park(
                parkDto.getId(),
                parkDto.getName(),
                parkDto.getCountry(),
                parkDto.getCity(),
                parkDto.getPrice(),
                parkDto.getWeblink()
        );
    }
}
