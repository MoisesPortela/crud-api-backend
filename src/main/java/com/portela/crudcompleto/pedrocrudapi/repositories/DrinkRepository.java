package com.portela.crudcompleto.pedrocrudapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portela.crudcompleto.pedrocrudapi.models.Drink;


//criação de interface para inserir dados no sql
@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long>{

}
