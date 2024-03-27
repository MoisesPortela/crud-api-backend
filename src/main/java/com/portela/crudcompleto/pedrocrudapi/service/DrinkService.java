package com.portela.crudcompleto.pedrocrudapi.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portela.crudcompleto.pedrocrudapi.dto.DrinkDTO;
import com.portela.crudcompleto.pedrocrudapi.models.Drink;
import com.portela.crudcompleto.pedrocrudapi.repositories.DrinkRepository;
import com.portela.crudcompleto.pedrocrudapi.service.exceptions.DatabaseException;
import com.portela.crudcompleto.pedrocrudapi.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DrinkService {

	@Autowired
	private DrinkRepository drinkRepository;
	
	private ModelMapper modelMapper;

	public Page<DrinkDTO> findAll(Pageable pageable) {
		Page<Drink> drink = drinkRepository.findAll(pageable);
		Page<DrinkDTO> drinkDto = drink.map(Drink -> modelMapper.map(Drink, DrinkDTO.class));
		return drinkDto;

	}
	@Transactional(readOnly = true)
	public DrinkDTO findDrinkById(Long drinkId) {
		Drink drink = drinkRepository.findById(drinkId).get();
		DrinkDTO drinkDto = new DrinkDTO(drink);
		return drinkDto;
	}

	public Drink createDrink(Drink drink) {
		return drinkRepository.save(drink);
	}

	public void deleteDrink(Long drinkId) {
		try {
			if (drinkRepository.existsById(drinkId)) {
				drinkRepository.deleteById(drinkId);
			} else {
				throw new ResourceNotFoundException(drinkId);
			}
			drinkRepository.deleteById(drinkId);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Drink updateDrink(Long drinkId, Drink drink) {
		try {
			// pega a referencia do objeto no banco de dados e deixa preparado
			// para trabalharmos com ele para só depois jogar novamente no banco
			Drink drinkUpdate = drinkRepository.getReferenceById(drinkId);
			updateData(drinkUpdate, drink);
			return drinkRepository.save(drinkUpdate);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(drinkId);
		}

	}

	private void updateData(Drink drinkUpdate, Drink drink) {
		drinkUpdate.setNome(drink.getNome());
		drinkUpdate.setTipo(drink.getTipo());
		drinkUpdate.setQtd(drink.getQtd());
		drinkUpdate.setTamanho(drink.getTamanho());
		drinkUpdate.setPreco(drink.getPreco());
	}

}
