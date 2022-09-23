package com.example.demo.controller;
import com.example.demo.model.Payload;
import com.example.demo.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;

@RestController
public class NumberController {
    @Autowired
    private NumberService numberService;

    @PostMapping("/min")
    public List<Double> getMin(@Valid @RequestBody Payload payload) {
        return numberService.getMin(payload.numbers, payload.quantifier);
    }

    @PostMapping("/max")
    public List<Double> getMax(@Valid @RequestBody Payload payload) {
        return numberService.getMax(payload.numbers, payload.quantifier);
    }

    @PostMapping("/avg")
    public double getAvg(@Valid @RequestBody List<Double> numbers) {
        return numberService.getAvg(numbers);
    }

    @PostMapping("/median")
    public double getMedian(@Valid @RequestBody List<Double> numbers) {
        return numberService.getMedian(numbers);
    }

    @PostMapping("/percentile")
    public double getPercentile(@Valid @RequestBody Payload payload) {
        return numberService.getPercentile(payload.numbers, payload.quantifier);
    }
}