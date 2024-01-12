package com.portela.crudcompleto.pedrocrudapi.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.portela.crudcompleto.pedrocrudapi.models.DrinkList;
import com.portela.crudcompleto.pedrocrudapi.repositories.DrinkListRepository;
import com.portela.crudcompleto.pedrocrudapi.service.exceptions.DatabaseException;
import com.portela.crudcompleto.pedrocrudapi.service.exceptions.ResourceNotFoundException;

@Service
public class DrinkListService {

	@Autowired
	private DrinkListRepository drinkListRepository;

	public List<DrinkList> findAll() {
		return drinkListRepository.findAll();

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
		DrinkList listUpdate = drinkListRepository.getReferenceById(listId);
		updateData(listUpdate,list);
		return drinkListRepository.save(listUpdate);
	}

	private void updateData(DrinkList listUpdate, DrinkList list) {
		listUpdate.setName(list.getName());
		
	}
	
}
