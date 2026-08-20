package br.com.brobece.controllers;

import br.com.brobece.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public double sum(

            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo

    ) throws IllegalArgumentException{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private double convertToDouble(String strnumber) throws IllegalArgumentException {
        if(strnumber == null || strnumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value");
        String number = strnumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strnumber){
        if(strnumber == null || strnumber.isEmpty()) return false;
        String number = strnumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
