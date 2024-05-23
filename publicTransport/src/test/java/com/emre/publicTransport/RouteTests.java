package com.emre.publicTransport;

import com.emre.publicTransport.Controller.RouteController;
import com.emre.publicTransport.Model.Route;
import com.emre.publicTransport.Service.RouteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RouteTests extends TestDataBase
{
    @Mock
    RouteService routeService;

    @InjectMocks
    RouteController routeController;

    @Test
    void save_shouldSaveSuccessfully()
    {
        // given
        Route expected = getMockRoute1();

        when(routeService.Save(any())).thenReturn(expected);

        Route request = new Route();
        Route actual = routeController.Save(request).getBody();

        assertAll(() -> assertNotNull(actual),
                () -> assertEquals(actual, expected));
    }

}