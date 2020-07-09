package com.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SuperParkingBoyTest {
    @Test
    public void should_park_car_in_lot_with_more_empty_rate_when_park_given_super_parking_boy_manage_two_lots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot1, parkingLot2);
        Car car = new Car();

        CarTicket ticket = superParkingBoy.park(car);

        assertNotNull(ticket);
        assertEquals(0, parkingLot1.getAvailablePosition());
    }

    @Test
    public void should_park_car_in_lot_with_more_empty_rate_when_park_given_super_parking_boy_manage_two_lots_with_parked_car() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot1, parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();
        superParkingBoy.park(car1);


        superParkingBoy.park(car2);

        assertEquals(1, parkingLot1.getAvailablePosition());
        assertEquals(1, parkingLot2.getAvailablePosition());
    }

    @Test
    public void should_get_parked_car_when_fetch_given_super_parking_boy_manage_two_lots_with_parked_car() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot1, parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();
        CarTicket ticket1 = superParkingBoy.park(car1);
        CarTicket ticket2 = superParkingBoy.park(car2);

        Car actual1 = superParkingBoy.fetch(ticket1);
        Car actual2 = superParkingBoy.fetch(ticket2);

        assertSame(car1, actual1);
        assertSame(car2, actual2);
    }
}
