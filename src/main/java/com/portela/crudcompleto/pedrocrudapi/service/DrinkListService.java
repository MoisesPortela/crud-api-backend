package com.portela.crudcompleto.pedrocrudapi.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portela.crudcompleto.pedrocrudapi.models.DrinkList;
import com.portela.crudcompleto.pedrocrudapi.repositories.DrinkListRepository;

@Service
public class DrinkListService {

	@Autowired
	private DrinkListRepository drinkListRepository;

	public List<DrinkList> findAll() {
		return drinkListRepository.findAll();

	}

	public DrinkList findListById(Long drinkListId) {
		Optional<DrinkList> drinkList = drinkListRepository.findById(drinkListId);
		return drinkList.get();
	}
	
	public DrinkList createList(DrinkList list) {
		return drinkListRepository.save(list);
	}
	public void deleteList (Long drinkListId) {
		drinkListRepository.deleteById(drinkListId);
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
