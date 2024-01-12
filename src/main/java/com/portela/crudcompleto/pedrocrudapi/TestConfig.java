package com.portela.crudcompleto.pedrocrudapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.portela.crudcompleto.pedrocrudapi.models.Drink;
import com.portela.crudcompleto.pedrocrudapi.models.DrinkList;
import com.portela.crudcompleto.pedrocrudapi.models.TipoBebida;
import com.portela.crudcompleto.pedrocrudapi.repositories.DrinkListRepository;
import com.portela.crudcompleto.pedrocrudapi.repositories.DrinkRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private DrinkRepository drinkRepository;
	@Autowired
	private DrinkListRepository drinkListRepository;

	
	@Override
	public void run(String... args) throws Exception{
		Drink drink1 = new Drink (null, "hidromel", TipoBebida.VINHO, 1, "790ml", "80 reais");
		Drink drink2 = new Drink (null, "Portada", TipoBebida.VINHO, 1, "790ml", "140 reais");
		Drink drink3 = new Drink (null, "Suco de uva", TipoBebida.SUCO, 1, "1L", "12 reais");
		Drink drink4 = new Drink (null, "Pepsi", TipoBebida.REFRIGERANTE, 1, "1L", "8 reais");
		Drink drink5 = new Drink (null, "Black Label", TipoBebida.WHISKY, 1, "790ml", "220 reais");
		Drink drink6 = new Drink (null, "Heineken", TipoBebida.CERVEJA, 1, "190ml", "5 reais");
		Drink drink7 = new Drink (null, "Suco de Laranja", TipoBebida.SUCO, 1, "1L", "140 reais");
		Drink drink8 = new Drink (null, "Pepsi com Johny Walker", TipoBebida.WHISKY, 1, "330ml", "10 reais");
		
		DrinkList drinkList1 = new DrinkList(null,"Não Alcoolicos");
		DrinkList drinkList2 = new DrinkList(null,"Degustação");
		DrinkList drinkList3 = new DrinkList(null,"Churrasco");
		DrinkList drinkList4 = new DrinkList(null,"18tão");
		
		drinkRepository.saveAll(Arrays.asList(drink1,drink2,drink3,drink4,drink5,drink6,drink7,drink8));
		
		drinkListRepository.saveAll(Arrays.asList(drinkList1,drinkList2,drinkList3,drinkList4));
		
		drink1.getDrinkList().add(drinkList2);
		drink2.getDrinkList().add(drinkList2);
		drink3.getDrinkList().add(drinkList1);
		drink4.getDrinkList().add(drinkList1);
		drink5.getDrinkList().add(drinkList4);
		drink6.getDrinkList().add(drinkList3);
		drink7.getDrinkList().add(drinkList1);
		drink8.getDrinkList().add(drinkList4);
		drink8.getDrinkList().add(drinkList3);
		
		drinkRepository.saveAll(Arrays.asList(drink1,drink2,drink3,drink4,drink5,drink6,drink7,drink8));
	}
	
	
}
