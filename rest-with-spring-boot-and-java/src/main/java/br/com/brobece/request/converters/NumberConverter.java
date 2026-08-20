package br.com.brobece.request.converters;

import br.com.brobece.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static double convertToDouble(String strnumber) throws IllegalArgumentException {
        if(strnumber == null || strnumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value");
        String number = strnumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strnumber){
        if(strnumber == null || strnumber.isEmpty()) return false;
        String number = strnumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
