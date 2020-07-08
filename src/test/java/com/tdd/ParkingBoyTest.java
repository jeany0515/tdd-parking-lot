package com.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {

    @Test
    public void should_return_a_ticket_when_parking_given_a_car() {
        //GIVEN
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();

        //WHEN
        CarTicket actual = parkingBoy.park(parkingLot, car);

        //THEN
        assertNotNull(actual);
    }

    @Test
    public void should_return_the_parked_car__when_fetch_given_the_correspond_ticket() {
        //GIVEN
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        CarTicket ticket = parkingBoy.park(parkingLot, car);

        //WHEN
        Car actual = parkingBoy.fetch(parkingLot, ticket);

        //THEN
        assertSame(car, actual);
    }
}
