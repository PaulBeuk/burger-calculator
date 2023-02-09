package org.beuk.burgercalculator.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.beuk.burgercalculator.logic.BurgerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = "api/v1/burger")
@RequiredArgsConstructor
public class OrderBurger {

	private final BurgerService burgerService;

	@GetMapping("/order")
	public String orderBurger(@RequestParam String type) {
		log.info("type: " + type);
		String orderStatus = "something went really wrong";
		try {
			orderStatus = burgerService.createBurger(type);
		} catch (Exception e) {
			orderStatus = "Sorry, not on the menu";
		} finally {
			return orderStatus;
		}
	}
}
