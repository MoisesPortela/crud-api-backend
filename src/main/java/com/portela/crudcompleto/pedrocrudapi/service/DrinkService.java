package com.portela.crudcompleto.pedrocrudapi.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portela.crudcompleto.pedrocrudapi.models.Drink;
import com.portela.crudcompleto.pedrocrudapi.repositories.DrinkRepository;

@Service
public class DrinkService {

	@Autowired
	private DrinkRepository drinkRepository;

	public List<Drink> findAll() {
		return drinkRepository.findAll();

	}

	public Drink findById(Long drinkId) {
		Optional<Drink> drink = drinkRepository.findById(drinkId);
		return drink.get();
	}

}
