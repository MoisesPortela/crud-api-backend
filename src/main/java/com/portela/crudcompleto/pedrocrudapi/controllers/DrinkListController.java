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

import com.portela.crudcompleto.pedrocrudapi.models.DrinkList;
import com.portela.crudcompleto.pedrocrudapi.service.DrinkListService;

@RestController
@RequestMapping("/list")
public class DrinkListController {
	// anotação pra injetar algo dentro da classe, no caso o drinkService
	@Autowired
	private DrinkListService drinkListService;

	@GetMapping
	public ResponseEntity<Page<DrinkList>> findAll(Pageable pageable) {
		Page<DrinkList> drinkLists = drinkListService.findAll(pageable);
		return ResponseEntity.ok().body(drinkLists);
	}

	@GetMapping(value = "/{drinkListId}")
	public ResponseEntity<DrinkList> findById(@PathVariable Long drinkListId) {
		DrinkList drinkList = drinkListService.findListById(drinkListId);
		return ResponseEntity.ok().body(drinkList);
	}

	@PostMapping
	public ResponseEntity<DrinkList> createList(@RequestBody DrinkList list) {
		DrinkList listCreate = drinkListService.createList(list);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{drinkListId")
				.buildAndExpand(listCreate.getId()).toUri();
		return ResponseEntity.created(uri).body(listCreate);
	}

	@DeleteMapping(value = "/{drinkListId}")
	public ResponseEntity<Void> deleteDrink(@PathVariable Long drinkListId) {
		drinkListService.deleteList(drinkListId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{drinkListId}")
	public ResponseEntity<DrinkList> updateList(@PathVariable Long drinkListId, @RequestBody DrinkList drinkList) {
		DrinkList listUpdated = drinkListService.updateList(drinkListId, drinkList);
		return ResponseEntity.ok().body(listUpdated);
	}
}
