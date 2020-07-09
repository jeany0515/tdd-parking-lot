package com.tdd;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {
    protected final List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot... parkingLots){
        this.parkingLots = Arrays.asList(parkingLots);
    }

    public CarTicket park(Car car) {
        List<ParkingLot> availableLots = getAvailableParkingLots();
        return availableLots.stream().findFirst().get().park(car);
    }

    protected List<ParkingLot> getAvailableParkingLots() {
        List<ParkingLot> availableLots = parkingLots.stream().filter(lot -> lot.getAvailableNumber() >0 ).collect(Collectors.toList());
        if (availableLots.size() == 0) {
            throw new RuntimeException("Not enough position.");
        }
        return availableLots;
    }

    public Car fetch(CarTicket ticket) {
        if (ticket == null) {
            throw new RuntimeException("Please provide your parking ticket.");
        }

        List<ParkingLot> parkedLots = parkingLots.stream().filter(lot -> lot.hasCar(ticket)).collect(Collectors.toList());
        if (parkedLots.size() == 0) {
            throw new RuntimeException("Unrecognized parking ticket.");
        }
        return parkedLots.stream().findFirst().get().fetchCar(ticket);
    }
}
