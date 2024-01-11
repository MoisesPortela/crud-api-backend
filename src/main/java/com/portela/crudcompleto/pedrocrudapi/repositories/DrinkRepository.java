package com.portela.crudcompleto.pedrocrudapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portela.crudcompleto.pedrocrudapi.models.Drink;


//criação de interface para inserir dados no sql
//anotaçãp @Repository opcional, pois já está herdando do JpaRepository
public interface DrinkRepository extends JpaRepository<Drink, Long>{

}
