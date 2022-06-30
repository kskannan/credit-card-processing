package com.publicis.sapient.creditcardprocessing.rest;

import com.publicis.sapient.creditcardprocessing.data.CardData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/credit/card")
public interface ProcessingApi {

    @PostMapping("/add")
    CardData addCard(@RequestBody CardData cardData);

    @GetMapping("get/all")
    List<CardData> getCardDetails();
}
