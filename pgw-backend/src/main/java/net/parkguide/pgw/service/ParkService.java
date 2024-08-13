package net.parkguide.pgw.service;

import net.parkguide.pgw.dto.ParkDto;
import net.parkguide.pgw.entity.Park;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParkService {
    ParkDto createPark(ParkDto parkDto);

    ParkDto getParkById(Long parkId);

    List<ParkDto> getAllParks();

    ParkDto updatePark(Long parkId, ParkDto updatedPark);

    void deletePark(Long parkId);
}
