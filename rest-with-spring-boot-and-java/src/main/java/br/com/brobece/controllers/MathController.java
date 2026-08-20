package br.com.brobece.controllers;

import br.com.brobece.exception.UnsupportedMathOperationException;
import br.com.brobece.math.SimpleMath;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.brobece.request.converters.NumberConverter.convertToDouble;
import static br.com.brobece.request.converters.NumberConverter.isNumeric;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws IllegalArgumentException{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.sum( convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws IllegalArgumentException{
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.subtraction( convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  throws IllegalArgumentException{
        if (!isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.multiplication(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  throws IllegalArgumentException{
        if (!isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.division( convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    )  throws IllegalArgumentException{
        if (!isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.mean (convertToDouble(numberOne),  convertToDouble(numberTwo));
    }

    @RequestMapping("/squareRoot/{numberOne}")
    public double squareRoot(
            @PathVariable("numberOne") String numberOne
    )  throws IllegalArgumentException{
        if (!isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return math.squareRoot( Math.sqrt(convertToDouble(numberOne)));
    }
}
