package org.beuk.burgercalculator.logic;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.beuk.burgercalculator.logic.entity.ShopService;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BurgerServiceTest {

	BurgerService sut;

	ShopService shop;
	@BeforeAll
	public void setup() {
		shop = mock(ShopService.class);
		sut = new BurgerService(shop);
	}

	@Test

	void canNotOrderABurderShop() {
		boolean isShopOpen = false;
		when(shop.isShopOpen()).thenReturn(isShopOpen);
		Assertions.assertEquals("out of order",sut.createBurger("Healthy"));
	}

	@Test
	@DisplayName("expect fail while ordering at the shop closed")
	void canNotOrderABurgerAtClosedShop() {
		boolean isShopOpen = false;
		when(shop.isShopOpen()).thenReturn(isShopOpen);
		Assertions.assertEquals("out of order",sut.createBurger("Healthy"));
	}

	@Test
	@DisplayName("expect no order because burger is not on the menu")
	void requestedBurgerIsNotOnTheMenu() {
		boolean isShopOpen = true;
		String burgerName = "Cheese";
		when(shop.isShopOpen()).thenReturn(isShopOpen);
		Assertions.assertEquals("Sorry, not on the menu",sut.createBurger(burgerName));
	}
}
