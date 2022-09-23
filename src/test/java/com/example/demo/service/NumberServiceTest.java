package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberServiceTest {

    private NumberService numberService = new NumberService();

    private List<Double> numbers = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));

    @Test
    void it_should_return_min() {
        var result = numberService.getMin(numbers, 2);
        assertEquals(Arrays.asList(1.0, 2.0), result);
    }

    @Test
    void it_should_return_max() {
        var result = numberService.getMax(numbers, 2);
        assertEquals(Arrays.asList(5.0, 4.0), result);
    }

    @Test
    void it_should_return_avg() {
        var result = numberService.getAvg(numbers);
        assertEquals(3.0, result);
    }

    @Test
    void it_should_return_median() {
        var result = numberService.getMedian(numbers);
        assertEquals(3.0, result);
    }

    @Test
    void it_should_return_percentile() {
        var result = numberService.getPercentile(numbers, 75);
        assertEquals(4.0, result);
    }
}