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

	public DrinkList findById(Long drinkListId) {
		Optional<DrinkList> drinkList = drinkListRepository.findById(drinkListId);
		return drinkList.get();
	}

}
