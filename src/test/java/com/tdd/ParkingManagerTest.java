package com.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest {
    @Test
    public void should_assign_parking_boy_to_park_a_car() {
        ParkingManager parkingManager = new ParkingManager();
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        CarTicket ticket = parkingManager.assignPark(parkingBoy, car);

        assertNotNull(ticket);
    }

    @Test
    public void should_assign_smart_parking_boy_to_park_a_car() {
        ParkingManager parkingManager = new ParkingManager();
        ParkingLot parkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Car car = new Car();

        CarTicket ticket = parkingManager.assignPark(smartParkingBoy, car);

        assertNotNull(ticket);
    }

    @Test
    public void should_assign_super_parking_boy_to_park_and_fetch_a_car() {
        ParkingManager parkingManager = new ParkingManager();
        ParkingLot parkingLot = new ParkingLot(2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot);
        Car car = new Car();
        CarTicket ticket = parkingManager.assignPark(superParkingBoy, car);

        Car actual = parkingManager.assignFetch(superParkingBoy, ticket);

        assertSame(car, actual);
    }

    @Test
    public void should_parking_manager_can_park_and_fetch_a_car_by_itself() {
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingManager parkingManager = new ParkingManager(parkingLot);
        Car car = new Car();
        CarTicket ticket = parkingManager.park(car);

        Car actual = parkingManager.fetch(ticket);

        assertSame(car, actual);
    }

    @Test
    public void should_return_error_message_when_fetch_given_no_ticket() {
        //GIVEN
        ParkingManager parkingManager = new ParkingManager();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        CarTicket ticket = null;

        //WHEN
        Exception exception = assertThrows(RuntimeException.class, () ->
                parkingManager.assignFetch(parkingBoy, ticket));

        //THEN
        assertEquals("Please provide your parking ticket.", exception.getMessage());
    }
}
