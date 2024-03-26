package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.House;
import ru.hogwarts.school.service.HouseService;

import java.util.Collection;

@RestController
@RequestMapping("houses")
public class HouseController {
    private final HouseService houseService;

    public HouseController(@Autowired HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("{id}") //GET https://localhost:8080/houses/23
    public ResponseEntity<House> getHouseInfo(@PathVariable Long id) {
        House foundHouse = houseService.findHouse(id);
        if(foundHouse == null) {
            // 404
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundHouse);
    }
    @PostMapping //POST https://localhost:8080/houses
    public House createHouse(@RequestBody House house) {
        return houseService.createHouse(house);
    }

    @PutMapping //PUT https://localhost:8080/houses
    public ResponseEntity<House> editHouse(@RequestBody House house) {
        House foundHouse = houseService.editHouse(house);
        if(foundHouse == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundHouse);
    }

    @GetMapping //GET https://localhost:8080/houses
    public ResponseEntity getAllHouses(@RequestParam(required = false) String name,
                                                          @RequestParam(required = false) String color) {
        if(name != null && !name.isBlank()) {
            return ResponseEntity.ok(houseService.findHouseByName(name));
        }
        if(color != null && !color.isBlank()) {
            return ResponseEntity.ok(houseService.findHouseByColor(color));
        }
        return ResponseEntity.ok(houseService.getAllHouses());
    }

    @DeleteMapping("{id}") //DELETE https://localhost:8080/houses
    public ResponseEntity deleteHouse(@PathVariable Long id) {
        houseService.deleteHouse(id);
        return ResponseEntity.ok().build();
    }
}
