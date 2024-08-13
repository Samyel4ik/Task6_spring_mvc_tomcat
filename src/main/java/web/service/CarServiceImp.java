package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarServiceImp implements CarService{

    private List<Car> list ;

    public CarServiceImp() {
        list = new ArrayList<>();
        list.add(new Car("Toyota", "Corolla", 220));
        list.add(new Car("Honda", "Civic", 200));
        list.add(new Car("Ford", "Mustang", 185));
        list.add(new Car("Chevrolet", "Malibu", 160));
        list.add(new Car("BMW", "3 Series", 220));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count >= list.size() || count <= 0) {
            return new ArrayList<>(list);
        }
        return new ArrayList<>(list.subList(0, count));
    }
}
