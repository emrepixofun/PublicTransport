package com.emre.publicTransport;

import com.emre.publicTransport.Controller.VehicleController;
import com.emre.publicTransport.Model.Vehicle;
import com.emre.publicTransport.Service.VehicleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleTests extends TestDataBase
{
    @Mock
    VehicleService vehicleService;

    @InjectMocks
    VehicleController vehicleController;

    @Test
    void findById_shouldBeSame()
    {
        // given
        Vehicle expected = getMockVehicle1();

        when(vehicleService.FindById(any())).thenReturn(expected);

        long vehicleId = 1L;
        Vehicle actual = vehicleController.Get(vehicleId).getBody();

        assertAll(() -> assertNotNull(actual),
                () -> assertEquals(actual, expected));
    }

}
