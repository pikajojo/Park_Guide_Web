package net.parkguide.pgw.controller;


import net.parkguide.pgw.dto.ParkDto;
import net.parkguide.pgw.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parks")
public class ParkController {

    private final ParkService parkService;

    // dependency injection of ParkService
    public ParkController(ParkService parkService) {
        this.parkService = parkService;
    }

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
    @PutMapping("{id}")
    public ResponseEntity<ParkDto> updatePark(@PathVariable("id") Long parkId,
                                              @RequestBody ParkDto updatedPark){
       ParkDto parkDto =  parkService.updatePark(parkId, updatedPark);
       return  ResponseEntity.ok(parkDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePark(@PathVariable("id") Long parkId){
        ParkDto parkDto = parkService.getParkById(parkId);
        String parkname = parkDto.getParkName();
        parkService.deletePark(parkId);
        return  ResponseEntity.ok(parkname + " is deleted successfully!");
    }

}
