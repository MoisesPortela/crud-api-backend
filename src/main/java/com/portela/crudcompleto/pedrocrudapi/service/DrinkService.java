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

	public Drink findDrinkById(Long drinkId) {
		Optional<Drink> drink = drinkRepository.findById(drinkId);
		return drink.get();
	}
	
	public Drink createDrink(Drink drink) {
		return drinkRepository.save(drink);
	}
	
	public void deleteDrink (Long drinkId) {
		drinkRepository.deleteById(drinkId);
	}
	public Drink updateDrink (Long drinkId, Drink drink) {
		//pega a referencia do objeto no banco de dados e deixa preparado 
			//para trabalharmos com ele para só depois jogar novamente no banco
		Drink drinkUpdate = drinkRepository.getReferenceById(drinkId);
		updateData(drinkUpdate,drink);
		return drinkRepository.save(drinkUpdate);
		
	}

	private void updateData(Drink drinkUpdate, Drink drink) {
		drinkUpdate.setNome(drink.getNome());
		drinkUpdate.setTipo(drink.getTipo());
		drinkUpdate.setQtd(drink.getQtd());
		drinkUpdate.setTamanho(drink.getTamanho());
		drinkUpdate.setPreco(drink.getPreco());
	}

}
