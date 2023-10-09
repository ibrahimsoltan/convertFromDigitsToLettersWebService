package com.example.convert_fromm_digits_to_letters_web_service;


import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class NumberQueryResolver  {
    ArabicNumberToWordsConverter converter = new ArabicNumberToWordsConverter();
    @QueryMapping
    public String getNumber(@Argument  double number) {
        System.out.println("Number: " + number);
        BigDecimal number1 = new BigDecimal(number);
        String result = converter.convert(number1);
        System.out.println("Result: " + result);
        return result;
    }
}
