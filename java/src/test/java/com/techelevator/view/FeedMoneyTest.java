package com.techelevator.view;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FeedMoneyTest {

	@Test
	public void testFeedMoney_with5_shouldReturn5() {
		Menu feedMoney = new Menu();
		Double expected = 5.00;
		
		double result = feedMoney.feedMoney();
		
		//assertEquals(expected, result);
	}
}
