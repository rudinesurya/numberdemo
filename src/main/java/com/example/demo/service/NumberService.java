package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

@Service
public class NumberService {
    public NumberService(){
    }

    public List<Double> getMin(List<Double> numbers, int quantifier){
        if (numbers.size() == 0)
            throw new ArithmeticException("Array is empty");
        if (quantifier <= 0)
            throw new ArithmeticException("Quantifier cannot be less than 0");
        else if (quantifier > numbers.size())
            throw new ArithmeticException("Quantifier cannot be more than array size");

        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        minHeap.addAll(numbers);

        List<Double> result = new ArrayList<>();
        for (int i = 0; i<quantifier; ++i){
            result.add(minHeap.poll());
        }

        return result;
    }

    public List<Double> getMax(List<Double> numbers, int quantifier){
        if (numbers.size() == 0)
            throw new ArithmeticException("Array is empty");
        if (quantifier <= 0)
            throw new ArithmeticException("Quantifier cannot be less than 0");
        else if (quantifier > numbers.size())
            throw new ArithmeticException("Quantifier cannot be more than array size");

        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(numbers);

        List<Double> result = new ArrayList<>();
        for (int i = 0; i<quantifier; ++i){
            result.add(maxHeap.poll());
        }

        return result;
    }

    public double getAvg(List<Double> numbers){
        if (numbers.size() == 0)
            throw new ArithmeticException("Array is empty");

        return numbers.stream().mapToDouble(Double::doubleValue).average().orElse(Double.NaN);
    }

    public double getMedian(List<Double> numbers){
        if (numbers.size() == 0)
            throw new ArithmeticException("Array is empty");

        Collections.sort(numbers);
        int size = numbers.size();
        int mid = size / 2;

        if (size % 2 == 0){
            return (numbers.get(mid) + numbers.get(mid+1)) / 2;
        }else {
            return numbers.get(mid);
        }
    }

    public double getPercentile(List<Double> numbers, int quantifier){
        if (numbers.size() == 0)
            throw new ArithmeticException("Array is empty");
        if (quantifier <= 0)
            throw new ArithmeticException("Quantifier cannot be less than or equal to 0");
        else if (quantifier > 100)
            throw new ArithmeticException("Quantifier cannot be more than 100");

        Collections.sort(numbers);

        int index = (int)Math.ceil(((double)quantifier / 100.0) * numbers.size());

        return numbers.get(index-1);
    }
}
