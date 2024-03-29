package com.publicis.sapient.creditcardprocessing.repository;

import com.publicis.sapient.creditcardprocessing.model.Card;

import java.util.List;

public class CardRepositoryMock {

    public List<Card> findAll(){
        return List.of(getCard());
    }

    private Card getCard() {
        var card = new Card();
        card.setId(1);
        card.setCardLimit(1000);
        card.setCardNumber(4648354228028685L);
        card.setBalance(0.00);
        card.setName("John");
        return card;
    }

    public Card save(Card card) {
        return getCard();
    }
}