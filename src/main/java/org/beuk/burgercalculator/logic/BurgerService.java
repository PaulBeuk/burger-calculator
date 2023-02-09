package org.beuk.burgercalculator.logic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.beuk.burgercalculator.logic.entity.*;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;

@Service
@Slf4j
@RequiredArgsConstructor
public class BurgerService {

	public String createBurger(String type) {
		Burger b = null;
		type = type.toUpperCase();
		switch (type) {
			case "BASIC":
				b = new BaseBurger();
				break;
			case "HEALTHY":
				b = new HealthyBurger();
				break;
			case "COMBO":
				b = new ComboBurger();
				break;

			default:
				throw new IllegalArgumentException("type not supported");
		}
		b.setBreadType(Hamburger.BreadTypes.BRIOCHE);
		b.setMeatType(Hamburger.MeatTypes.BLACKANGUS);
		b.setToppings(Hamburger.Toppings.SAUCES);
		b.setToppings(Hamburger.Toppings.AVOCADO);
		b.setToppings(Hamburger.Toppings.TOMATO);
		b.setToppings(Hamburger.Toppings.UNION);
		if(b.getType() == Hamburger.Type.HEALTHY) {
			b.setToppings(Hamburger.Toppings.CHEESE);
			b.setToppings(Hamburger.Toppings.LETTUCE);
		}
		return generateTicket(b,calculateTotalPrice(b));
	}

	private float calculateTotalPrice(Burger burger) {
		float price = 0f;
		price += burger.getMeatType().price;
		price += burger.getType().price;
		price += burger.getBreadType().price;
		price += burger.calculateToppingsPrice();
		return price;
	}

	private String generateTicket(Burger burger, float totalPrice) {
		NumberFormat formatter = new DecimalFormat("€0.00");
		StringBuffer sb = new StringBuffer();
		sb.append("Base price of the hamburger: ").append(formatter.format(burger.getType().price)).append("<br>");
		sb.append("Toppings: " + burger.getToppings()).append("<br>");
		sb.append("Toppings price: " + formatter.format(burger.calculateToppingsPrice())).append("<br>");
		sb.append("So that will be: ").append(formatter.format(totalPrice)).append(" for your ").append(burger.getType()).append("<br>");
		return sb.toString();
	}
}
