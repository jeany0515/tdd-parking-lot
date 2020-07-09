package com.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    private ParkingBoy parkingBoy;
    private  ParkingLot parkingLot;

    @BeforeEach
    void init() {
        parkingBoy = new ParkingBoy();
        parkingLot = new ParkingLot();
    }


    @Test
    public void should_return_a_ticket_when_parking_given_a_car() {
        //GIVEN
        Car car = new Car();

        //WHEN
        CarTicket actual = parkingBoy.park(parkingLot, car);

        //THEN
        assertNotNull(actual);
    }

    @Test
    public void should_return_the_parked_car__when_fetch_given_the_correspond_ticket() {
        //GIVEN
        Car car = new Car();
        CarTicket ticket = parkingBoy.park(parkingLot, car);

        //WHEN
        Car actual = parkingBoy.fetch(parkingLot, ticket);

        //THEN
        assertSame(car, actual);
    }

    @Test
    public void should_return_the_parked_two_cars_when_fetch_given_two_parked_cars_with_the_correspond_tickets() {
        //GIVEN
        Car car1 = new Car();
        Car car2 = new Car();
        CarTicket ticket1 = parkingBoy.park(parkingLot, car1);
        CarTicket ticket2 = parkingBoy.park(parkingLot, car2);

        //WHEN
        Car actual1 = parkingBoy.fetch(parkingLot, ticket1);
        Car actual2 = parkingBoy.fetch(parkingLot, ticket2);

        //THEN
        assertSame(car1, actual1);
        assertSame(car2, actual2);
    }


    @Test
    public void should_return_exception_when_fetch_given_wrong_ticket() {
        //GIVEN
        CarTicket ticket = new CarTicket();

        //WHEN
        Exception exception = assertThrows(RuntimeException.class, () ->
                parkingBoy.fetch(parkingLot, ticket));

        //THEN
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_exception_when_fetch_given_used_ticket() {
        //GIVEN
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(parkingLot, car);
        parkingBoy.fetch(parkingLot, carTicket);

        //WHEN
        Exception exception = assertThrows(RuntimeException.class, () ->
                parkingBoy.fetch(parkingLot, carTicket));

        //THEN
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_full_message_when_park_11th_car_given_parking_lot_have_parked_10_car() {
        //GIVEN
        for(int i=1; i<=10; i++) {
            Car car = new Car();
            parkingBoy.park(parkingLot, car);
        }
        Car car_11th = new Car();

        //WHEN
        Exception exception = assertThrows(RuntimeException.class, () -> parkingBoy.park(parkingLot, car_11th));

        //THEN
        assertEquals("Not enough position.", exception.getMessage());
    }

    @Test
    public void should_return_a_ticket_when_parking_given_parking_lot_2_capacity_and_a_car() {
        //GIVEN
        parkingLot = new ParkingLot(2);
        Car car = new Car();

        //WHEN
        CarTicket actual = parkingBoy.park(parkingLot, car);

        //THEN
        assertNotNull(actual);
    }

    @Test
    public void should_return_error_message_when_fetch_given_no_ticket() {
        //GIVEN
        CarTicket ticket = null;

        //WHEN
        Exception exception = assertThrows(RuntimeException.class, () ->
                parkingBoy.fetch(parkingLot, ticket));

        //THEN
        assertEquals("Please provide your parking ticket.", exception.getMessage());
    }
}
