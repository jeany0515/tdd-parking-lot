package com.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    public static final int CAPACITY = 10;
    private Map<CarTicket, Car> carStorage;
    private int capacity;

    public ParkingLot() {
        this.carStorage = new HashMap<>();
        this.capacity = CAPACITY;
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Car fetchCar(CarTicket ticket) {
        if (ticket == null) {
            throw new RuntimeException("Please provide your parking ticket.");
        }
        if (!carStorage.containsKey(ticket)) {
            throw new RuntimeException("Unrecognized parking ticket.");
        }
        Car car = carStorage.get(ticket);
        carStorage.remove(ticket);
        return car;
    }

    public CarTicket park(Car car) {
        if (carStorage.size() == capacity) {
            return null;
        }

        CarTicket carTicket = new CarTicket();
        carStorage.put(carTicket, car);
        return carTicket;
    }
}
