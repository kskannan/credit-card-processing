package com.publicis.sapient.creditcardprocessing.data;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "cardNumber", "cardLimit"})
public record CardData(String name, long cardNumber, double cardLimit) {
}
