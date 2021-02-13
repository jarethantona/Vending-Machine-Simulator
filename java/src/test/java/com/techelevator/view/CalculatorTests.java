package com.techelevator.view;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.Calculator;

import junit.framework.Assert;

public class CalculatorTests {

	private Calculator calculator;
	
	@Before
	public void setup() {
		calculator = new Calculator();
	}
	
	@Test
	public void correctlyInsertMoney() {
		Double expected = 10.0;
		Double result = calculator.insertMoney(5.0, 5.0);
		assertEquals(expected, result);
	}
	
	@Test
	public void testChargeMoney() {
		Double expected = 2.20;
		Double result = calculator.insertMoney(2.0, 0.20);
		assertEquals(expected, result);
	}
	
	@Test
	public void testMakeChangeWithQuarters() {
		String expected = "Your change is: \n" + "Quarters: " + 2 + " Dimes: " + 0 + " Nickels: " + 0;
		String result = calculator.makeChange(0.50);
		assertEquals(expected, result);
	}
	
	@Test
	public void testMakeChangeWithDimes() {
		String expected = "Your change is: \n" + "Quarters: " + 0 + " Dimes: " + 2 + " Nickels: " + 0;
		String result = calculator.makeChange(0.20);
		assertEquals(expected, result);
	}
	
	@Test
<<<<<<< HEAD
	public void testInsertMoney_with5_shouldReturnBalance() {
		//ARRANGE
		Calculator object = new Calculator();
		//double expected = 
		//ACT
		
		//ASSERT
		
=======
	public void testMakeChangeWithNickels() {
		String expected = "Your change is: \n" + "Quarters: " + 0 + " Dimes: " + 0 + " Nickels: " + 1;
		String result = calculator.makeChange(0.05);
		assertEquals(expected, result);
>>>>>>> c1e10145a94ad38951f184dd860f616b32fc2c30
	}
	
	
	
}
