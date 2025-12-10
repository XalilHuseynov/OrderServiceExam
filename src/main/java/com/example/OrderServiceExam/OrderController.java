package com.example.OrderServiceExam;

import com.example.OrderServiceExam.dto.EmailRequestDto;
import com.example.OrderServiceExam.dto.OrderRequestDto;
import com.example.OrderServiceExam.dto.OrderResponseDto;
import com.example.OrderServiceExam.dto.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final ProductClient productClient;

    private final EmailClient emailClient;


    @PostMapping()
    public ResponseEntity<OrderResponseDto> create(@RequestBody OrderRequestDto orderRequestDto){
        log.info("Received order request for productId={}", orderRequestDto.getProductId());
        ProductResponseDto productResponseDto = productClient.getById(orderRequestDto.getProductId());

        log.info("Calling Product Service for productId={}", orderRequestDto.getProductId());

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setMessage("Order successfully found!");

        emailClient.sendMail(new EmailRequestDto(orderRequestDto.getCustomerEmail(),"Product availability","Mehsul tapildi ! ! !"));
        log.info("Email sending about product availability");

        return ResponseEntity.ok(orderResponseDto);
    }




}
