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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public List<ParkDto> getParkByName(String name) {
        List<Park> parks = parkRepository.findByName(name);
        return parks.stream().map((park) -> ParkMapper.mapToParkDto(park))
                .collect(Collectors.toList());
    }

    @Override
    public List<ParkDto> getParkByCity(String city) {
        List<Park> parks = parkRepository.findByCity(city);
        return parks.stream().map((park) -> ParkMapper.mapToParkDto(park))
                .collect(Collectors.toList());
    }

    @Override
    public List<ParkDto> getParkByCountry(String country) {
         List<Park> parks = parkRepository.findByCountry(country);
         return parks.stream().map((park) -> ParkMapper.mapToParkDto(park))
                 .collect(Collectors.toList());
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
        park.setName(updatedPark.getName());
        park.setCountry(updatedPark.getCountry());
        park.setCity(updatedPark.getCity());
        park.setPrice(updatedPark.getPrice());
        park.setWeblink(updatedPark.getWeblink());

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


    public void updateParkImage(Long parkId, MultipartFile file) throws IOException {
        Park park = parkRepository.findById(parkId)
                .orElseThrow(() -> new RuntimeException("Park not found"));

        // 将文件转换为字节数组并保存
//        park.setImage(file.getBytes());

        parkRepository.save(park);
    }
}
