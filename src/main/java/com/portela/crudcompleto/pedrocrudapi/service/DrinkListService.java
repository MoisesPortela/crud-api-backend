package com.portela.crudcompleto.pedrocrudapi.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portela.crudcompleto.pedrocrudapi.models.DrinkList;
import com.portela.crudcompleto.pedrocrudapi.repositories.DrinkListRepository;
import com.portela.crudcompleto.pedrocrudapi.service.exceptions.DatabaseException;
import com.portela.crudcompleto.pedrocrudapi.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DrinkListService {

	@Autowired
	private DrinkListRepository drinkListRepository;

	public Page<DrinkList> findAll(Pageable pageable) {
		return drinkListRepository.findAll(pageable);

	}

	public DrinkList findListById(Long drinkListId) {
		Optional<DrinkList> drinkList = drinkListRepository.findById(drinkListId);
		return drinkList.orElseThrow(() -> new ResourceNotFoundException(drinkListId));
	}
	
	public DrinkList createList(DrinkList list) {
		return drinkListRepository.save(list);
	}
	public void deleteList (Long drinkListId) {
		try {
			if (drinkListRepository.existsById(drinkListId)) {
				drinkListRepository.deleteById(drinkListId);
			}else {
				throw new ResourceNotFoundException(drinkListId);
			}
			drinkListRepository.deleteById(drinkListId);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
	public DrinkList updateList(Long listId, DrinkList list) {
		try {
		DrinkList listUpdate = drinkListRepository.getReferenceById(listId);
		updateData(listUpdate,list);
		return drinkListRepository.save(listUpdate);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(listId);
		}
	}

	private void updateData(DrinkList listUpdate, DrinkList list) {
		listUpdate.setName(list.getName());
		
	}
	
}
