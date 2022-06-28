package com.publicis.sapient.creditcardprocessing.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "CREDIT_CARD")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    private String name;

    private long cardNumber;

    private int cardLimit;
    private double balance;


}
