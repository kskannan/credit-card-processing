package com.publicis.sapient.creditcardprocessing.rest;

import com.publicis.sapient.creditcardprocessing.data.CardData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/credit/card")
@Api(value = "Credit card processing", tags = "Cards")
public interface ProcessingApi {

    @PostMapping("/add")
    @ApiOperation(value = "Add new credit card", consumes = "application/json", response = CardData.class)
    CardData addCard(@RequestBody CardData cardData);

    @GetMapping("get/all")
    @ApiOperation(value = "Fetch all credit card details", consumes = "application/json", response = List.class)
    List<CardData> getCardDetails();
}
