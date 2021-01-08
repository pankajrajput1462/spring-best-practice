package com.batchjob.springbatchdemo.model;

import lombok.Data;

@Data
public class Coffee {
    private final String brand;
    private final String origin;
    private final String characteristics;

    public Coffee(String brand, String origin, String characteristics) {
        this.brand = brand;
        this.origin = origin;
        this.characteristics = characteristics;
    }
}
