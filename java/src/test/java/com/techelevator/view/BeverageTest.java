package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.Beverage;

public class BeverageTest {
	
	private Beverage beverage;

	private Beverage beverage;
	
	@Before
	public void setup() {
		beverage = new Beverage("C1", "Cola", 1.25, 5);
	}
	
	@Test
	public void getCorrectSound() {
		Assert.assertTrue("\"Glug Glug, Yum!\"".equals(beverage.getSound()));
	}
	
	@Test
<<<<<<< HEAD
	public void testBeverage_withSound_shouldReturnSound() {
		Beverage beverage = new Beverage("C3", null, 0, 0);
		
		
=======
	public void getCorrectType() {
		Assert.assertTrue("Drink".equals(beverage.getType()));
>>>>>>> c1e10145a94ad38951f184dd860f616b32fc2c30
	}
}
