package org.beuk.burgercalculator.logic.entity;

public class ComboBurger extends Hamburger {
	public ComboBurger() {

		super(Type.COMBO);
		setMaxToppings(4);
		setHasChipsAndDrinks(true);
	}
}
