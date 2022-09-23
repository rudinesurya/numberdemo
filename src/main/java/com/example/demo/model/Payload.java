package com.example.demo.model;

import java.util.List;
import javax.validation.constraints.NotNull;

public class Payload {
    @NotNull
    public List<Double> numbers;
    @NotNull
    public int quantifier;
}
