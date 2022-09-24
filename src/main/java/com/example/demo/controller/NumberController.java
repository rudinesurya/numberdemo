package com.example.demo.controller;
import com.example.demo.exception.InputValidationException;
import com.example.demo.model.Payload;
import com.example.demo.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;

@RestController
public class NumberController {
    @Autowired
    private NumberService numberService;

    @PostMapping("/min")
    public ResponseEntity<List<Double>> getMin(@Valid @RequestBody Payload payload) {
        if (payload.numbers.size() == 0 || payload.quantifier <= 0)
            throw new InputValidationException("Numbers or quantifier have to be more than 0.");
        if (payload.quantifier > payload.numbers.size())
            throw new InputValidationException("Quantifier have to be less than or equal to numbers.size().");

        var result = numberService.getMin(payload.numbers, payload.quantifier);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/max")
    public ResponseEntity<List<Double>> getMax(@Valid @RequestBody Payload payload) {
        if (payload.numbers.size() == 0 || payload.quantifier <= 0)
            throw new InputValidationException("Numbers or quantifier have to be more than 0.");
        if (payload.quantifier > payload.numbers.size())
            throw new InputValidationException("Quantifier have to be less than or equal to numbers.size().");

        var result = numberService.getMax(payload.numbers, payload.quantifier);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/avg")
    public ResponseEntity<Double> getAvg(@Valid @RequestBody List<Double> numbers) {
        if (numbers.size() == 0)
            throw new InputValidationException("Numbers cannot be empty.");

        var result = numberService.getAvg(numbers);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/median")
    public ResponseEntity<Double> getMedian(@Valid @RequestBody List<Double> numbers) {
        if (numbers.size() == 0)
            throw new InputValidationException("Numbers cannot be empty.");

        var result = numberService.getMedian(numbers);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/percentile")
    public ResponseEntity<Double> getPercentile(@Valid @RequestBody Payload payload) {
        if (payload.numbers.size() == 0)
            throw new InputValidationException("Numbers have to be more than 0.");
        if (payload.quantifier <= 0 || payload.quantifier > 100)
            throw new InputValidationException("Quantifier have to be between 0 to 100.");

        var result = numberService.getPercentile(payload.numbers, payload.quantifier);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}