package com.tdd;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        List<ParkingLot> availableLots = this.parkingLots.stream().filter(ParkingLot::isAvailable).collect(Collectors.toList());
        if (availableLots.size() == 0) {
            throw new RuntimeException("Not enough position.");
        }
        return availableLots.stream().max((Comparator.comparing(ParkingLot::getAvailablePosition))).get().park(car);
    }


}
