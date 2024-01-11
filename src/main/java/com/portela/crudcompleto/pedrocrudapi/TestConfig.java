package com.portela.crudcompleto.pedrocrudapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.portela.crudcompleto.pedrocrudapi.models.Drink;
import com.portela.crudcompleto.pedrocrudapi.models.TipoBebida;
import com.portela.crudcompleto.pedrocrudapi.repositories.DrinkRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private DrinkRepository drinkRepository;

	
	@Override
	public void run(String... args) throws Exception{
		Drink drink1 = new Drink (null, "hidromel", TipoBebida.VINHO, 1, "790ml", "80 reais");
		Drink drink2 = new Drink (null, "Portada", TipoBebida.VINHO, 1, "790ml", "140 reais");
		
		drinkRepository.saveAll(Arrays.asList(drink1,drink2));
	}
	
	
}
