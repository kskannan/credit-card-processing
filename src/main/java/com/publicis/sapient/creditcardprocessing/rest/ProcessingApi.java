package com.publicis.sapient.creditcardprocessing.rest;

import com.publicis.sapient.creditcardprocessing.data.Card;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RequestMapping("/credit/card")
public interface ProcessingApi {

    @PostMapping("/add")
    void addCard(@RequestBody Card card);

    @GetMapping("get/all")
    List<Card> getCardDetails();
}
