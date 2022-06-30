package com.publicis.sapient.creditcardprocessing.util;

import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Utilities {
    public static Predicate<Long> validateUsingLuhn(){
        return (cardNumber) -> {
            String s= Long.toString(cardNumber);
            var digits = s.chars()
                    .map(Character::getNumericValue)
                    .toArray();
            IntUnaryOperator sumDigits = n -> n / 10 + n % 10;
            var sum = IntStream.rangeClosed(1, digits.length)
                    .map(i -> digits.length - i)
                    .map(i -> i % 2 == 0 ? sumDigits.applyAsInt(digits[i] * 2) : digits[i])
                    .sum();

            System.out.println(sum);
            return sum % 10 == 0;
        };
    }
}
