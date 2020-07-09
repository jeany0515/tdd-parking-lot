package com.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {
    @Test
    public void should_park_car_in_lot_with_more_available_position_when_park_given_smart_parking_boy_manage_two_lots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        Car car = new Car();

        CarTicket ticket = smartParkingBoy.park(car);

        assertNotNull(ticket);
        assertEquals(1, parkingLot2.getAvailableNumber());
    }

    @Test
    public void should_get_car_when_fetch_given_smart_parking_boy_manage_two_lots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        Car car = new Car();

        CarTicket ticket = smartParkingBoy.park(car);
        Car actual = smartParkingBoy.fetch(ticket);

        assertSame(car, actual);
    }
}
