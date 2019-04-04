package looptoit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import looptoit.demo.domain.Car;
import looptoit.demo.services.CarService;

@RestController
public class HelloWorldController {

	@Autowired 
	CarService carService;
	
	
	@GetMapping("/cars/{name}")
	public Car helloWorld(@PathVariable String name){		
		return carService.getCarDetails(name);
	}

}
