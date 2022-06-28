package com.publicis.sapient.creditcardprocessing.rest;

import com.publicis.sapient.creditcardprocessing.data.CardData;
import com.publicis.sapient.creditcardprocessing.repository.CardRepository;
import com.publicis.sapient.creditcardprocessing.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProcessingController implements ProcessingApi{

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardService cardService;
    @Override
    public void addCard(CardData cardData) {

    }

    @Override
    public List<CardData> getCardDetails() {
        var lst = cardService.getAllCardDetails(cardRepository::findAll);
        lst.forEach(System.out::println);
        return lst;
    }
}
