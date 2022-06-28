package com.publicis.sapient.creditcardprocessing.rest;

import com.publicis.sapient.creditcardprocessing.data.Card;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProcessingController implements ProcessingApi{

    @Override
    public void addCard(Card card) {

    }

    @Override
    public List<Card> getCardDetails() {

        return null;
    }
}
