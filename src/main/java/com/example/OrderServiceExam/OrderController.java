package com.example.OrderServiceExam;

import com.example.OrderServiceExam.dto.EmailRequestDto;
import com.example.OrderServiceExam.dto.OrderRequestDto;
import com.example.OrderServiceExam.dto.OrderResponseDto;
import com.example.OrderServiceExam.dto.ProductResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private EmailClient emailClient;

    @PostMapping()
    public ResponseEntity<OrderResponseDto> create(@RequestBody OrderRequestDto orderRequestDto){
        log.info("Received order request for productId="+orderRequestDto.getProductId());
        ProductResponseDto productResponseDto = productClient.getById(orderRequestDto.getProductId());

        log.info("Calling Product Service for productId="+orderRequestDto.getProductId());



        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setMessage("Order successfully found!");

        //oz mailime atiram
        emailClient.sendMail(new EmailRequestDto("0708802077nar@gmail.com","Product availability","Mehsul tapildi ! ! !"));
        log.info("Email sending about product availability");


        return ResponseEntity.ok(orderResponseDto);
    }




}
