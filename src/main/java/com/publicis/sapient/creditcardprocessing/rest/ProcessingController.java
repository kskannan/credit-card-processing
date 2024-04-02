package com.publicis.sapient.creditcardprocessing.rest;

import com.publicis.sapient.creditcardprocessing.data.CardData;
import com.publicis.sapient.creditcardprocessing.repository.CardRepository;
import com.publicis.sapient.creditcardprocessing.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.publicis.sapient.creditcardprocessing.util.Utilities.validateUsingLuhn;

@RestController
public class ProcessingController implements ProcessingApi{

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardService cardService;
    @Override
    public ResponseEntity<CardData> addCard(CardData cardData) {
        return Optional.of(validateUsingLuhn().test(cardData.cardNumber()))
                .map(validCard -> {
                     if(validCard)
                         return new ResponseEntity(cardService.addNewCard(cardData, cardRepository::save), HttpStatus.OK);
                     else throw new RuntimeException("Invalid card number");
                })
                .orElseThrow();
    }
    @Override
    public List<CardData> getCardDetails() {
        return cardService.getAllCardDetails(cardRepository::findAll);
    }
}
