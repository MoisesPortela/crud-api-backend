package com.portela.crudcompleto.pedrocrudapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portela.crudcompleto.pedrocrudapi.models.DrinkList;
import com.portela.crudcompleto.pedrocrudapi.service.DrinkListService;

@RestController
@RequestMapping("/list")
public class DrinkListController {
	// anotação pra injetar algo dentro da classe, no caso o drinkService
	@Autowired
	private DrinkListService drinkListService;

	@GetMapping
	public ResponseEntity<List<DrinkList>> findAll() {
		List<DrinkList> drinkLists = drinkListService.findAll();
		return ResponseEntity.ok().body(drinkLists);
	}
	@GetMapping(value="/{drinkListId}")
	public ResponseEntity<DrinkList> findById(@PathVariable Long drinkListId){
		DrinkList drinkList = drinkListService.findById(drinkListId);
		return ResponseEntity.ok().body(drinkList);
	}
}
