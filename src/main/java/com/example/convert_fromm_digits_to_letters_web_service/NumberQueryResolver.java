package com.example.convert_fromm_digits_to_letters_web_service;


import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.GraphQLScalarType;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class NumberQueryResolver  {
    ArabicNumberToWordsConverter converter = new ArabicNumberToWordsConverter();

    @QueryMapping
    public String getNumber(@Argument BigDecimal number) {
        System.out.println("Number: " + number);
        String result = converter.convert(number);
        System.out.println("Result: " + result);
        return result;
    }
}
