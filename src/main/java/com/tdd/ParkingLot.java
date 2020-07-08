package com.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<CarTicket, Car> carStorage = new HashMap<>();

    public Car fetchCar(CarTicket ticket) {
        return carStorage.get(ticket);
    }

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        carStorage.put(carTicket, car);
        return carTicket;
    }
}
