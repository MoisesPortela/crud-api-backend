package com.portela.crudcompleto.pedrocrudapi.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<Drink> findDrinkById(@PathVariable Long drinkId){
		Drink drink = drinkService.findDrinkById(drinkId);
		return ResponseEntity.ok().body(drink);
	}
	
	@PostMapping
	public ResponseEntity<Drink> createDrink(@RequestBody Drink drink){
		Drink drinkCreated = drinkService.createDrink(drink);
		//mudando o status de 200 pra 201
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{drinkId}").buildAndExpand(drinkCreated.getId()).toUri();	
		return ResponseEntity.created(uri).body(drinkCreated);
	}
	@DeleteMapping(value = "/{drinkId}")
	public ResponseEntity<Void> deleteDrink(@PathVariable Long drinkId){
		drinkService.deleteDrink(drinkId);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	
	
	
}
