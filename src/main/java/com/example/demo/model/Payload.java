package com.example.demo.model;

import java.util.List;
import javax.validation.constraints.NotNull;

public class Payload {
    @NotNull(message = "Numbers may not be null")
    public List<Double> numbers;
    @NotNull(message = "Quantifier may not be null")
    public Integer quantifier;
}
