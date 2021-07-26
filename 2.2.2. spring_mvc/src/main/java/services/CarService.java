package services;

import entities.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CarService {
    public List<Car> getCars(Integer quality) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Toyota", "200", "red"));
        cars.add(new Car("Ferrari", "250", "blue"));
        cars.add(new Car("Волга", "120", ",белая"));
        cars.add(new Car("Москвич", "120", "синий"));
        cars.add(new Car("Запорожец", "120", "красный"));
        if (quality != null) {
            List<Car> sortedCars = cars.stream().limit(quality).collect(Collectors.toList());
            return sortedCars;
        } else {
            return cars;
        }
    }
}
