package org.beuk.burgercalculator.logic.entity;

public class BaseBurger extends Hamburger {

	public BaseBurger() {
		super(Type.BASIC);
		setMaxToppings(4);
	}
}
