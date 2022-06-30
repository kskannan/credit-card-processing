package com.publicis.sapient.creditcardprocessing.rest;

import com.publicis.sapient.creditcardprocessing.data.CardData;
import com.publicis.sapient.creditcardprocessing.model.Card;
import com.publicis.sapient.creditcardprocessing.repository.CardRepository;
import com.publicis.sapient.creditcardprocessing.services.CardService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ProcessingControllerTest {

    @MockBean
    private CardService cardService;

    @MockBean
    private CardRepository cardRepository;

    @Autowired
    private ProcessingApi processingApi;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addValidCard() {
        var cardData = new CardData("kannan", 4648354228028685L, 10.0);
        Mockito.when(cardService.addNewCard(any(), any()))
                .thenReturn(cardData);
        var result = processingApi.addCard(cardData);
        assertNotNull(result);
        assertEquals( 4648354228028685L, result.cardNumber());
    }

    @Test
    void addInvalidCard() {
        var result = Assertions.assertThrows(RuntimeException.class, () -> {
            processingApi.addCard(new CardData("kannan", 1234569874123654L, 10.0));
        }, "Invalid card number message was expected");

        assertEquals("Invalid card number",result.getMessage());
    }

}