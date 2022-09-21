package com.example.demo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class NumberController {
    @PostMapping("/min")
    public List<Double> getMin(@RequestBody Payload payload) {
        List<Double> numbers = payload.numbers;
        int quantifier = payload.quantifier;

        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        minHeap.addAll(numbers);

        List<Double> result = new ArrayList<>();
        for (int i = 0; i<quantifier; ++i){
            result.add(minHeap.poll());
        }

        return result;
    }

    @PostMapping("/max")
    public List<Double> getMax(@RequestBody Payload payload) {
        List<Double> numbers = payload.numbers;
        int quantifier = payload.quantifier;

        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(numbers);

        List<Double> result = new ArrayList<>();
        for (int i = 0; i<quantifier; ++i){
            result.add(maxHeap.poll());
        }

        return result;
    }

    @PostMapping("/avg")
    public double getAvg(@RequestBody List<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).average().orElse(Double.NaN);
    }

    @PostMapping("/median")
    public double getMedian(@RequestBody List<Double> numbers) {
        Collections.sort(numbers);
        int size = numbers.size();
        int mid = size / 2;

        if (size % 2 == 0){
            return (numbers.get(mid) + numbers.get(mid+1)) / 2;
        }else {
            return numbers.get(mid);
        }
    }

    @PostMapping("/percentile")
    public double getPercentile(@RequestBody Payload payload) {
        List<Double> numbers = payload.numbers;
        int quantifier = payload.quantifier;

        Collections.sort(numbers);

        int index = (int)Math.ceil(((double)quantifier / 100.0) * numbers.size());

        return numbers.get(index-1);
    }
}