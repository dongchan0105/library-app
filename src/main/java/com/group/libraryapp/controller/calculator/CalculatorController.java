package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.request.request.CalculatorMultiplyRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @GetMapping("/add")
    public int addTwoNumbers(int number1,int number2){
        return number1+number2;
    }

    @PostMapping("multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request){
        return request.getNumber1() * request.getNumber2();
    }
}
