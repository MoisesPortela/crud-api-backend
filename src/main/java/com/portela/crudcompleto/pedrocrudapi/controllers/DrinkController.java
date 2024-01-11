package com.portela.crudcompleto.pedrocrudapi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.portela.crudcompleto.pedrocrudapi.models.Drink;
import com.portela.crudcompleto.pedrocrudapi.service.DrinkService;

@RestController
@RequestMapping("/drinks")
public class DrinkController {
	// anotação pra injetar algo dentro da classe, no caso o drinkService
	@Autowired
	private DrinkService drinkService;

	@GetMapping
	public ResponseEntity<List<Drink>> findAll() {
		List<Drink> drinkList = drinkService.findAll();
		return ResponseEntity.ok().body(drinkList);
	}
	@GetMapping(value="/{drinkId}")
	public ResponseEntity<Drink> findById(@PathVariable Long drinkId){
		Drink drink = drinkService.findById(drinkId);
		return ResponseEntity.ok().body(drink);
	}
}
