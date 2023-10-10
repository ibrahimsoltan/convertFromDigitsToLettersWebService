package com.example.convert_fromm_digits_to_letters_web_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class GetNumberController {
    ArabicNumberToWordsConverter converter = new ArabicNumberToWordsConverter();

    @PostMapping("/getNumber")
    public String getNumber(@RequestBody NumberWrapper  wrapper) {
        BigDecimal number = wrapper.getNumber();  // Assuming NumberWrapper's getNumber() returns BigDecimal
        String result = converter.convert(number);
        System.out.println("Result: " + result);
        return result;
    }
}
