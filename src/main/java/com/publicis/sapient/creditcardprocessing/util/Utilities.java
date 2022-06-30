package com.publicis.sapient.creditcardprocessing.util;

import com.publicis.sapient.creditcardprocessing.data.CardData;

import java.util.Optional;
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

    public static void main(String[] args) {
        System.out.println(Utilities.validateUsingLuhn().test(1234569874123654L));
        System.out.println(Utilities.validateUsingLuhn().test(4546384822028982L));
        var r = Optional.of(validateUsingLuhn().test(1234569874123654L))
                .map(a -> {
                    if(a)
                        return new CardData("kannan", 123456, 10.0);
                        //return cardService.addNewCard(cardData, cardRepository::save);
                    else throw new RuntimeException("Invalid card number");
                })
                .orElseThrow();
        System.out.println(r.cardNumber());
        //var obj = new Utilities();
        //System.out.println(Utilities.luhn().(1234569874123654L));
        //System.out.println(obj.luhn(4546384822028982L));
    }
}
