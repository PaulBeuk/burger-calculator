package org.beuk.burgercalculator.logic.entity;

public class HealthyBurger extends Hamburger {
	public HealthyBurger() {

		super(Type.HEALTHY);
		setMaxToppings(6);
	}
}
