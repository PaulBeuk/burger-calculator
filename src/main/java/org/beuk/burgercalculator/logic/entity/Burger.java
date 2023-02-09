package org.beuk.burgercalculator.logic.entity;

public interface Burger {
	public void setToppings(Hamburger.Toppings topic);
	public String getToppings();
	public Hamburger.Type getType();

	public void setBreadType(Hamburger.BreadTypes breadType);
	public Hamburger.BreadTypes getBreadType();
	public boolean hasAdditional();

	public void setMeatType(Hamburger.MeatTypes meatType);
	public Hamburger.MeatTypes getMeatType();

	float calculateToppingsPrice();
}
