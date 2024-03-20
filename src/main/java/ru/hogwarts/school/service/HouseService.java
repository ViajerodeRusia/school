package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.House;

import java.util.Collection;
import java.util.HashMap;

@Service
public class HouseService {
    private final HashMap<Long, House> houses = new HashMap<>();
    private long lastId = 0;

    public House createHouse(House house) {
        house.setId(++lastId);
        houses.put(lastId, house);
        return house;
    }
    public House findHouse(long id) {
        return houses.get(id);
    }
    public House editHouse(House house) {
        houses.put(house.getId(), house);
        return house;
    }
    public House deleteHouse(long id) {
        return houses.remove(id);
    }
    public Collection<House> getAllHouses() {
        return houses.values();
    }
}
