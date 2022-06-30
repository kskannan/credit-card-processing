package com.publicis.sapient.creditcardprocessing.services;

import com.publicis.sapient.creditcardprocessing.data.CardData;
import com.publicis.sapient.creditcardprocessing.model.Card;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService{
    @Override
    public List<CardData> getAllCardDetails(Supplier<List<Card>> fetchCardDetails) {
        var cardDetails = fetchCardDetails.get();
        return cardDetails.stream().map(this::mapToCardData).collect(Collectors.toList());
    }

    @Override
    public CardData addNewCard(CardData cardData, UnaryOperator<Card> save) {
        var card = mapToCard(cardData);
        return mapToCardData(save.apply(card));
    }
    private Card mapToCard(CardData cardData){
       return new Card(getNextId(), cardData.name(), cardData.cardNumber(), cardData.cardLimit(), 0.00);
    }
    private CardData mapToCardData(Card card){
        return new CardData(card.getName(), card.getCardNumber(), card.getCardLimit());
    }

    private static int getNextId(){
        return new Random(10000).nextInt();
    }
}
