package com.publicis.sapient.creditcardprocessing.services;

import com.publicis.sapient.creditcardprocessing.data.CardData;
import com.publicis.sapient.creditcardprocessing.repository.CardRepositoryMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CardServiceImplTest {

    @Autowired
    private  CardService cardService;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCardDetails(){
        CardRepositoryMock cardRepositoryMock = new CardRepositoryMock();
        var lst = cardService.getAllCardDetails(cardRepositoryMock::findAll);
        assertNotNull(lst);
        assertThat(lst.get(0)).hasFieldOrPropertyWithValue("name", "John");
    }

    @Test
    void addNewCard(){
        CardRepositoryMock cardRepositoryMock = new CardRepositoryMock();
        var cardData = cardService.addNewCard(new CardData("Test", 4648354228028685L, 1000), cardRepositoryMock::save);
        assertNotNull(cardData);
        assertThat(cardData).hasFieldOrPropertyWithValue("cardNumber", 4648354228028685L);
    }
}