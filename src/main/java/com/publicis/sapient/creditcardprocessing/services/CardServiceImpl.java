package com.publicis.sapient.creditcardprocessing.services;

import com.publicis.sapient.creditcardprocessing.data.CardData;
import com.publicis.sapient.creditcardprocessing.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService{
    @Override
    public List<CardData> getAllCardDetails(Supplier<List<Card>> fetchCardDetails) {
        var cardDetails = fetchCardDetails.get();
        return cardDetails.stream().map(this::mapToCardData).collect(Collectors.toList());
    }

    private CardData mapToCardData(Card card){
        return new CardData(card.getName(), card.getCardNumber(), card.getCardLimit());

    }
}
