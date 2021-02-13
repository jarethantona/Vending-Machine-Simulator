package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.Beverage;
import com.techelevator.Gum;

public class GumTest {

private Gum gum;
	
	@Before
	public void setup() {
		gum = new Gum("D1", "U-Chews", 0.85, 5);
	}
	
	@Test
	public void getCorrectSound() {
		Assert.assertTrue("\"Chew Chew, Yum!\"".equals(gum.getSound()));
	}
	
	@Test
	public void getCorrectType() {
		Assert.assertTrue("Gum".equals(gum.getType()));
	}
}
