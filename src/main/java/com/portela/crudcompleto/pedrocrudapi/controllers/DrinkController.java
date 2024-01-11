package com.portela.crudcompleto.pedrocrudapi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.portela.crudcompleto.pedrocrudapi.models.Drink;
import com.portela.crudcompleto.pedrocrudapi.repositories.DrinkRepository;

@RestController
@RequestMapping("/drinks")
public class DrinkController {
	//anotação final é pra indicar que é um objeto constante, uma vez atribuido n pode mudar de objeto e quando chegar outro 
	//objeto, ele será uma nova instancia
	private final DrinkRepository drinkRepository;
	
	public DrinkController(DrinkRepository drinkRepository) {
		this.drinkRepository = drinkRepository;
	}
	
	@GetMapping
	public List<Drink> listar() {
		return drinkRepository.findAll();
	}
	//com o drinkId, o programa já entende que é o id da classe drink
	@GetMapping("/{drinkId}")
	public ResponseEntity<Drink> findById(@PathVariable Long drinkId) {
		//o map pega um objeto do tipo drink e transforma em um objeto do tipo response contendo o drink, caso n
		//encontre ele retorna no orElse com o status notFound
		return drinkRepository.findById(drinkId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Drink cadastrar(@RequestBody Drink  drink) {
		return drinkRepository.save(drink);
	}
	@PutMapping("/{drinkId}")
	public ResponseEntity<Drink> atualizar(@PathVariable Long drinkId,@RequestBody Drink drink){
		if(!drinkRepository.existsById(drinkId)) {
			return ResponseEntity.notFound().build();
		}
		drink.setId(drinkId);
		Drink drinkAtualizado = drinkRepository.save(drink);
		return ResponseEntity.ok(drinkAtualizado);
	}
}









