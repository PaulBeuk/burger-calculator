package org.beuk.burgercalculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloBurger {

	@GetMapping("/hello")
	public String hello() {
		return "hello burger";
	}
}
