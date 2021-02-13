package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.Chips;

public class ChipsTest {

private Chips chips;
	
	@Before
	public void setup() {
		chips = new Chips("A1", "Potato Crisps", 3.05, 5);
	}
	
	@Test
	public void getCorrectSound() {
		Assert.assertTrue("\"Crunch Crunch, Yum!\"".equals(chips.getSound()));
	}
	
	@Test
	public void getCorrectType() {
		Assert.assertTrue("Chip".equals(chips.getType()));
	}
}
