package com.publicis.sapient.creditcardprocessing.repository;

import com.publicis.sapient.creditcardprocessing.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
}
