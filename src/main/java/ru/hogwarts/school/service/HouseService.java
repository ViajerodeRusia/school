package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.House;
import ru.hogwarts.school.repository.HouseRepository;

import java.util.Collection;

@Service
public class HouseService {
    public final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public House createHouse(House house) {
        houseRepository.save(house);
        return house;
    }
    public House findHouse(long id) {
        return houseRepository.findById(id).get();
    }
    public House findHouseByName(String name) {
        return houseRepository.findHouseByName(name);
    }
    public House findHouseByColor(String color) {
        return houseRepository.findHouseByColor(color);
    }
    public House editHouse(House house) {
        return houseRepository.save(house);
    }
    public void deleteHouse(long id) {
        houseRepository.deleteById(id);
    }
    public Collection<House> getAllHouses() {
        return houseRepository.findAll();
    }
}
