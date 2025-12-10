package com.example.OrderServiceExam;

import com.example.OrderServiceExam.dto.OrderResponseDto;
import com.example.OrderServiceExam.dto.ProductResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ProductServiceExam",url = "http://localhost:8081/products")
public interface ProductClient {
    @GetMapping("/{id}")
    ProductResponseDto getById(@PathVariable int id);

    @GetMapping()
    List<ProductResponseDto> getAll();
}
