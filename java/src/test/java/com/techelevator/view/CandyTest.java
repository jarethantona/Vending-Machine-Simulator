package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.Beverage;
import com.techelevator.Candy;

public class CandyTest {

	private Candy candy;
	
	@Before
	public void setup() {
		candy = new Candy("B1", "Moonpie", 1.80, 5);
	}
	
	@Test
	public void getCorrectSound() {
		Assert.assertTrue("\"Munch Munch, Yum!\"".equals(candy.getSound()));
	}
	
	@Test
	public void getCorrectType() {
		Assert.assertTrue("Candy".equals(candy.getType()));
	}
}
