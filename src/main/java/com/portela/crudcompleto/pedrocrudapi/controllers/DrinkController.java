package com.portela.crudcompleto.pedrocrudapi.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.portela.crudcompleto.pedrocrudapi.dto.DrinkDTO;
import com.portela.crudcompleto.pedrocrudapi.models.Drink;
import com.portela.crudcompleto.pedrocrudapi.service.DrinkService;

@RestController
@RequestMapping("/drinks")
public class DrinkController {
	// anotação pra injetar algo dentro da classe, no caso o drinkService
	@Autowired
	private DrinkService drinkService;
 
	@GetMapping
	public ResponseEntity<Page<DrinkDTO>> findAll(Pageable pageable) {
		Page<DrinkDTO> drinkList = drinkService.findAll(pageable);
		return ResponseEntity.ok().body(drinkList);
	}

	@GetMapping(value = "/{drinkId}")
	public ResponseEntity<DrinkDTO> findDrinkById(@PathVariable Long drinkId) {
		DrinkDTO drink = drinkService.findDrinkById(drinkId);
		return ResponseEntity.ok().body(drink);
	}

	@PostMapping
	public ResponseEntity<Drink> createDrink(@RequestBody Drink drink) {
		Drink drinkCreated = drinkService.createDrink(drink);
		// mudando o status de 200 pra 201
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{drinkId}")
				.buildAndExpand(drinkCreated.getId()).toUri();
		return ResponseEntity.created(uri).body(drinkCreated);
	}

	@DeleteMapping(value = "/{drinkId}")
	public ResponseEntity<Void> deleteDrink(@PathVariable Long drinkId) {
		drinkService.deleteDrink(drinkId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{drinkId}")
	public ResponseEntity<Drink> updateDrink(@PathVariable Long drinkId, @RequestBody Drink drink) {
		Drink drinkUpdated = drinkService.updateDrink(drinkId, drink);
		return ResponseEntity.ok().body(drinkUpdated);
	}
}
