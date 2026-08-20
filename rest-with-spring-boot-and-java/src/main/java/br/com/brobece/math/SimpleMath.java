package br.com.brobece.math;

import br.com.brobece.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class SimpleMath {


    public double sum(Double numberOne, Double numberTwo){
        return (numberOne) + (numberTwo);
    }



    public double subtraction(Double numberOne, Double numberTwo){
        return (numberOne) - (numberTwo);
    }



    public double multiplication(Double numberOne, Double numberTwo){
        return (numberOne) * (numberTwo);
    }



    public double division(Double numberOne, Double numberTwo){
        return (numberOne) / (numberTwo);
    }



    public double mean(Double numberOne, Double numberTwo){
        return ((numberOne) + (numberTwo)) / 2;
    }



    public double squareRoot(Double numberOne){
        return Math.sqrt(numberOne) ;
    }


}
