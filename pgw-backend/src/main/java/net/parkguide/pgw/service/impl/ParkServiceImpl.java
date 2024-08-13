package net.parkguide.pgw.service.impl;

import lombok.AllArgsConstructor;
import lombok.Setter;
import net.parkguide.pgw.dto.ParkDto;
import net.parkguide.pgw.entity.Park;
import net.parkguide.pgw.exception.ResourceNotFoundException;
import net.parkguide.pgw.mapper.ParkMapper;
import net.parkguide.pgw.repository.ParkRepository;
import net.parkguide.pgw.service.ParkService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParkServiceImpl implements ParkService {
    private ParkRepository parkRepository;

    @Override
    public ParkDto createPark(ParkDto parkDto) {
        Park park = ParkMapper.mapToPark(parkDto);
        Park savedPark = parkRepository.save(park);
        return ParkMapper.mapToParkDto(savedPark);
    }

    @Override
    public ParkDto getParkById(Long parkId) {
        Park park = parkRepository.findById(parkId)
                .orElseThrow(() -> new ResourceNotFoundException("Park is not found with given id: " + parkId));

        return ParkMapper.mapToParkDto(park);
    }

    @Override
    public List<ParkDto> getAllParks() {
        List<Park> parks = parkRepository.findAll();
        return parks.stream().map((park) -> ParkMapper.mapToParkDto(park))
                .collect(Collectors.toList());

    }

    @Override
    public ParkDto updatePark(Long parkId, ParkDto updatedPark) {
        Park park = parkRepository.findById(parkId).orElseThrow(
                () -> new ResourceNotFoundException("Park is not found with given id: "+parkId)
        );
        park.setParkName(updatedPark.getParkName());
        park.setParkCountry(updatedPark.getParkCountry());
        park.setParkCity(updatedPark.getParkCity());
        park.setPrice(updatedPark.getPrice());
        park.setWebLink(updatedPark.getWebLink());

        Park updatedParkObj = parkRepository.save(park);

        return ParkMapper.mapToParkDto(updatedParkObj);
    }

    @Override
    public void deletePark(Long parkId) {
        Park park = parkRepository.findById(parkId).orElseThrow(
                () -> new ResourceNotFoundException("Park is not found with given id: "+parkId)
        );

        parkRepository.deleteById(parkId);

    }
}
