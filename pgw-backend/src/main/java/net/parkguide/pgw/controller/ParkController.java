package net.parkguide.pgw.controller;


import lombok.AllArgsConstructor;
import net.parkguide.pgw.dto.ParkDto;
import net.parkguide.pgw.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/parks")
public class ParkController {

    private final ParkService parkService;


    //Build Add Park Rest API
    @PostMapping
    public ResponseEntity<ParkDto> createPark(@RequestBody ParkDto parkDto) {
        ParkDto savedPark = parkService.createPark(parkDto);
        return new ResponseEntity<>(savedPark, HttpStatus.CREATED);
    }


    //Build Get Park Rest API
    @GetMapping("{id}")
    public ResponseEntity<ParkDto> getParkById(@PathVariable("id") Long parkId){
        ParkDto parkDto = parkService.getParkById(parkId);
        return ResponseEntity.ok(parkDto);
    }

    //Build Get All Parks Rest API
    @GetMapping
    public ResponseEntity<List<ParkDto>> getAllParks(){
       List<ParkDto> parks =  parkService.getAllParks();
       return ResponseEntity.ok(parks);
    }

    @GetMapping("/find/{name}")
    public ResponseEntity<List<ParkDto>> getParks(@PathVariable("name") String name,
                               @RequestParam(required = false) String city,
                               @RequestParam(required = false) String country
                              ) {
        if (name != null) {
            List<ParkDto> parks = parkService.getParkByName(name);
            return ResponseEntity.ok(parks);
        } else if (city != null) {
            List<ParkDto> parks =parkService.getParkByCity(city);
            return ResponseEntity.ok(parks);
        } else if (country != null) {
            List<ParkDto> parks = parkService.getParkByCountry(country);
            return ResponseEntity.ok(parks);
        } else {
            // Return all parks or handle error
            List<ParkDto> parks =parkService.getAllParks(); // 或者实现一个getAllParks()方法
            return ResponseEntity.ok(parks);
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<ParkDto> updatePark(@PathVariable("id") Long parkId,
                                              @RequestBody ParkDto updatedPark){
       ParkDto parkDto =  parkService.updatePark(parkId, updatedPark);
       return  ResponseEntity.ok(parkDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePark(@PathVariable("id") Long parkId){
        ParkDto parkDto = parkService.getParkById(parkId);
        String parkname = parkDto.getName();
        parkService.deletePark(parkId);
        return  ResponseEntity.ok(parkname + " is deleted successfully!");
    }

}
