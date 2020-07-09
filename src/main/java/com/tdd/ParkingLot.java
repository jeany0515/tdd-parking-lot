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
        this.carStorage = new HashMap<>();
        this.capacity = capacity;
    }

    public Car fetchCar(CarTicket ticket) {
        Car car = carStorage.get(ticket);
        carStorage.remove(ticket);
        return car;
    }

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        carStorage.put(carTicket, car);
        return carTicket;
    }

    public boolean isAvailable() {
        return carStorage.size() < capacity;
    }

    public boolean hasCar(CarTicket ticket) {
        return carStorage.containsKey(ticket);
    }

    public int getAvailablePosition() {
        return capacity - carStorage.size();
    }
}
