package com.publicis.sapient.creditcardprocessing.services;

import com.publicis.sapient.creditcardprocessing.data.CardData;
import com.publicis.sapient.creditcardprocessing.model.Card;

import java.util.List;
import java.util.function.Supplier;

public interface CardService {

    List<CardData> getAllCardDetails(Supplier<List<Card>> fetchCardDetails);

}
