package looptoit.demo.services;

import org.springframework.stereotype.Service;

import looptoit.demo.domain.Car;

@Service
public class CarService {

	public Car getCarDetails(String name) {
		return new Car("prius", "hybrid");
	}

}
