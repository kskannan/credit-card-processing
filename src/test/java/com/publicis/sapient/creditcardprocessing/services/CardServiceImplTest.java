package com.publicis.sapient.creditcardprocessing.services;

import com.publicis.sapient.creditcardprocessing.repository.CardRepositoryMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        Assertions.assertNotNull(lst);
        lst.forEach(c -> {
            System.out.println(c.name());
            System.out.println(c.cardNumber());
            System.out.println(c.cardLimit());
        });
        org.assertj.core.api.Assertions.assertThat(lst.get(0)).hasFieldOrPropertyWithValue("name", "John");
    }
}