package com.emre.publicTransport;

import com.emre.publicTransport.Controller.StationController;
import com.emre.publicTransport.Model.Station;
import com.emre.publicTransport.Service.StationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StationTests extends TestDataBase
{
    @Mock
    StationService stationService;

    @InjectMocks
    StationController stationController;

    @Test
    void save_shouldSaveSuccessfully()
    {
        // given
        List<Station> expected = getMockStation1();

        when(stationService.SaveAll(any())).thenReturn(expected);

        List<Station> request = new ArrayList<>();
        List<Station> actual = stationController.Save(request).getBody();

        assertAll(() -> assertNotNull(actual),
                () -> assertEquals(actual, expected));
    }

}