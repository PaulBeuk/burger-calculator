package org.beuk.burgercalculator.logic.entity;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Hamburger implements Burger {

	@Override
	public float calculateToppingsPrice() {

		return toppings.stream().map( t -> t.price ).reduce(0f, (a, b) -> a + b);
	}

	@Override public BreadTypes getBreadType() {

		return breadType;
	}
	private Hamburger.MeatTypes meatType;
	private Hamburger.BreadTypes breadType;
	private Type type;
	private int maxToppings;

	public boolean hasAdditional() {

		return hasChipsAndDrinks;
	}

	public void setHasChipsAndDrinks(boolean hasChipsAndDrinks) {

		this.hasChipsAndDrinks = hasChipsAndDrinks;
	}

	private boolean hasChipsAndDrinks;

	private String name;
	private float price;

	private ArrayList<Hamburger.Toppings> toppings;

	public void setBreadType(Hamburger.BreadTypes breadType) {
		this.breadType = breadType;
	}

	@Override public Type getType() {

		return type;
	}

	@Override
	public void setToppings(Toppings topic) {
		toppings.add(topic);
	}

	@Override
	public String getToppings() {
		return toppings.stream().map(Object::toString).collect(Collectors.joining(","));
	}

	public int getMaxToppings() {

		return maxToppings;
	}

	public void setMaxToppings(int maxToppings) {

		this.maxToppings = maxToppings;
	}

	protected Hamburger(Type type) {
		toppings = new ArrayList<>();
		this.type = type;
		this.hasChipsAndDrinks = false;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public float getPrice() {

		return price;
	}

	public void setPrice(float price) {

		this.price = price;
	}

	@Override public MeatTypes getMeatType() {

		return meatType;
	}

	@Override public void setMeatType(MeatTypes meatType) {

		this.meatType = meatType;
	}

	public enum Type {
		BASIC(2.0f, "Base burger"),
		HEALTHY(3.5f, "Healthy burger"),
		COMBO(5.5f, "Combo burger");

		public final float price;

		public final String name;

		Type(float price, String name) {

			this.price = price;
			this.name = name;
		}
	}
	public enum Toppings {
		CHEESE(2.0f, "Cheese"),
		SAUCES(1.2f, "Sauce"),
		LETTUCE(1.8f, "Lettuce"),
		TOMATO(1.5f, "Tomato"),
		UNION(1.0f, "Union"),
		AVOCADO(2.1f, "Avocado");

		public final float price;
		public final String name;

		Toppings(float price, String name) {

			this.price = price;

			this.name = name;
		}
	}

	public enum BreadTypes {
		WHOLEGRAIN(1.5f,"Wholegrain"),
		WHITE(1.3f, "While"),
		BRIOCHE(1.8f, "Brioche"),
		CIABATTA(2.1f, "Ciabatta");

		public final float price;
		final String name;

		BreadTypes(float price, String name) {

			this.price = price;
			this.name = name;
		}
	}
	public enum MeatTypes {
		BLACKANGUS(4.5f, "Black angus patty"),
		KOBEBEEF(5.2f, "Kobe beef patty"),
		VEGAN(4.2f, "Vegan patty"),
		FISH(4.8f, " Fish patty");

		public final float price;
		public final String name;

		MeatTypes(float price, String name) {

			this.price = price;
			this.name = name;
		}
	}
}
