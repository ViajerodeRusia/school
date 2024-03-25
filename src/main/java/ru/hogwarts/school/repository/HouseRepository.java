package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.House;

public interface HouseRepository extends JpaRepository<House, Long> {
    //TODO: для поиска факультета по имени или цвету, игнорируя регистр
    House findHouseByName(String name);
    House findHouseByColor(String color);
}
