package com.publicis.sapient.creditcardprocessing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CREDIT_CARD")
public class Card {
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    private String name;

    private long cardNumber;

    private double cardLimit;

    private double balance;

}
