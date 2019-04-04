package looptoit.demo.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import looptoit.demo.domain.Car;
import looptoit.demo.services.CarService;


@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CarService carService;
	
	@Test
	public void getCar_ShouldReturnCar() throws Exception{
		
		//arrange
		given(carService.getCarDetails(anyString())).willReturn(new Car("prius", "hybrid"));
		
		//act
		mockMvc.perform(MockMvcRequestBuilders.get("/cars/prius"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("name").value("prius"))
		.andExpect(MockMvcResultMatchers.jsonPath("type").value("hybrid"));		

	}
}
