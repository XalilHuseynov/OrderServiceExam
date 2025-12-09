package com.example.OrderServiceExam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private int id;
    private String name;
    private double price;

    private final List<ProductResponseDto> products = List.of(
            new ProductResponseDto(1, "Laptop", 1200.0),
            new ProductResponseDto(2, "Phone", 800.0),
            new ProductResponseDto(3, "Headphones", 120.0));

}