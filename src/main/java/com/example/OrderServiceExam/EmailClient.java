package com.example.OrderServiceExam;

import com.example.OrderServiceExam.dto.EmailRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="EmailServiceExam",url = "http://localhost:8083/emails")
public interface EmailClient {

    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@RequestBody EmailRequestDto emailRequestDto);

}
