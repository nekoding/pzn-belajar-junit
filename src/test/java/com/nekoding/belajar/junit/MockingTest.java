package com.nekoding.belajar.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.mockito.Mockito;

@Execution(ExecutionMode.CONCURRENT)
public class MockingTest {

    @Test
    public void testCase1() {
        Vehicle vehicle = Mockito.mock(Vehicle.class);

        // mock data
        Mockito.when(vehicle.getBrandName()).thenReturn("Toyota");
        Mockito.when(vehicle.getTotalTire()).thenReturn(4);

        // assertion
        Assertions.assertEquals("Toyota", vehicle.getBrandName());
        Assertions.assertEquals(4, vehicle.getTotalTire());

        // verify mock
        Mockito.verify(vehicle, Mockito.times(1)).getBrandName();
        Mockito.verify(vehicle, Mockito.times(1)).getTotalTire();
    }
}
