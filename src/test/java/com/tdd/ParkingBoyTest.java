package com.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    private ParkingBoy parkingBoy;
    private ParkingLot parkingLot;


    @Test
    public void should_return_a_ticket_when_parking_given_a_car() {
        //GIVEN
        parkingLot = new ParkingLot();
        parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //WHEN
        CarTicket actual = parkingBoy.park(car);

        //THEN
        assertNotNull(actual);
    }

    @Test
    public void should_return_the_parked_car__when_fetch_given_the_correspond_ticket() {
        //GIVEN
        parkingLot = new ParkingLot();
        parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        CarTicket ticket = parkingBoy.park(car);

        //WHEN
        Car actual = parkingBoy.fetch(ticket);

        //THEN
        assertSame(car, actual);
    }

    @Test
    public void should_return_the_parked_two_cars_when_fetch_given_two_parked_cars_with_the_correspond_tickets() {
        //GIVEN
        parkingLot = new ParkingLot();
        parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        CarTicket ticket1 = parkingBoy.park(car1);
        CarTicket ticket2 = parkingBoy.park(car2);

        //WHEN
        Car actual1 = parkingBoy.fetch(ticket1);
        Car actual2 = parkingBoy.fetch(ticket2);

        //THEN
        assertSame(car1, actual1);
        assertSame(car2, actual2);
    }


    @Test
    public void should_return_exception_when_fetch_given_wrong_ticket() {
        //GIVEN
        parkingLot = new ParkingLot();
        parkingBoy = new ParkingBoy(parkingLot);
        CarTicket ticket = new CarTicket();

        //WHEN
        Exception exception = assertThrows(RuntimeException.class, () ->
                parkingBoy.fetch(ticket));

        //THEN
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_exception_when_fetch_given_used_ticket() {
        //GIVEN
        parkingLot = new ParkingLot();
        parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        CarTicket carTicket = parkingBoy.park(car);
        parkingBoy.fetch(carTicket);

        //WHEN
        Exception exception = assertThrows(RuntimeException.class, () ->
                parkingBoy.fetch(carTicket));

        //THEN
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }

    @Test
    public void should_return_full_message_when_park_11th_car_given_parking_lot_have_parked_10_car() {
        //GIVEN
        parkingLot = new ParkingLot();
        parkingBoy = new ParkingBoy(parkingLot);
        for (int i = 1; i <= 10; i++) {
            Car car = new Car();
            parkingBoy.park(car);
        }
        Car car_11th = new Car();

        //WHEN
        Exception exception = assertThrows(RuntimeException.class, () -> parkingBoy.park(car_11th));

        //THEN
        assertEquals("Not enough position.", exception.getMessage());
    }

    @Test
    public void should_return_a_ticket_when_parking_given_parking_lot_2_capacity_and_a_car() {
        //GIVEN
        parkingLot = new ParkingLot(2);
        parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //WHEN
        CarTicket actual = parkingBoy.park(car);

        //THEN
        assertNotNull(actual);
    }

    @Test
    public void should_return_error_message_when_fetch_given_no_ticket() {
        //GIVEN
        parkingLot = new ParkingLot();
        parkingBoy = new ParkingBoy(parkingLot);
        CarTicket ticket = null;

        //WHEN
        Exception exception = assertThrows(RuntimeException.class, () ->
                parkingBoy.fetch(ticket));

        //THEN
        assertEquals("Please provide your parking ticket.", exception.getMessage());
    }

    @Test
    public void should_get_parked_cars_when_fetch_given_parking_boy_manage_two_lots() {
        //GIVEN
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingBoy = new ParkingBoy(parkingLot1, parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();
        CarTicket ticket1 = parkingBoy.park(car1);
        CarTicket ticket2 = parkingBoy.park(car2);

        //WHEN
        Car actual1 = parkingBoy.fetch(ticket1);
        Car actual2 = parkingBoy.fetch(ticket2);
        //THEN
        assertSame(car1, actual1);
        assertSame(car2, actual2);
    }

    @Test
    public void should_return_no_position_when_park_given_parking_boy_manage_two_lots_both_full() {
        //GIVEN
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        parkingBoy = new ParkingBoy(parkingLot1, parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        parkingBoy.park(car1);
        parkingBoy.park(car2);

        //WHEN
        Exception exception = assertThrows(RuntimeException.class, () -> parkingBoy.park(car3));

        //THEN
        assertEquals("Not enough position.", exception.getMessage());
    }
}
