package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Card;

public interface CardRepository extends JpaRepository<Card, Long>{
	
}
