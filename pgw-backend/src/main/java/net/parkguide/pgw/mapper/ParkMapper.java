package net.parkguide.pgw.mapper;

import net.parkguide.pgw.dto.ParkDto;
import net.parkguide.pgw.entity.Park;

public class ParkMapper {
    public static ParkDto mapToParkDto(Park park) {
        return new ParkDto(
                park.getId(),
                park.getParkName(),
                park.getParkCountry(),
                park.getParkCity(),
                park.getPrice(),
                park.getWebLink());
    }

    public static Park mapToPark(ParkDto parkDto) {
        return new Park(
                parkDto.getId(),
                parkDto.getParkName(),
                parkDto.getParkCountry(),
                parkDto.getParkCity(),
                parkDto.getPrice(),
                parkDto.getWebLink()
        );
    }
}
