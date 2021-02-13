package com.techelevator.view;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.VendingMachineItems;

public class VendingMachineItemsTests {

	private VendingMachineItems vendingMachineItems;
	
	@Before
	public void setup() {
		vendingMachineItems = new VendingMachineItems("A1", "Potato Crisps", 3.05, 5);
	}
	
	@Test
	public void testGetName() {
		Assert.assertTrue("Potato Crisps".equals(vendingMachineItems.getName()));
	}
	
	@Test
	public void testGetPrice() {
		Double expected = 3.05;
		Double result = vendingMachineItems.getPrice();
		assertEquals(expected, result);
	}
	
	@Test
	public void testGetSlot() {
		String expected = "A1";
		String result = vendingMachineItems.getSlot();
		assertEquals(expected, result);
	}
	
	@Test
	public void testGetType() {
		String expected = null;
		String result = vendingMachineItems.getType();
		assertEquals(expected, result);
	}
	
	@Test
	public void testGetSound() {
		String expected = null;
		String result = vendingMachineItems.getSound();
		assertEquals(expected, result);
	}
	
	@Test
	public void testGetCount() {
		int expected = 5;
		int result = vendingMachineItems.getCount();
		assertEquals(expected, result);
	}
	
	@Test
	public void testDecreaseCount() {
		int expected = 4;
		int result = vendingMachineItems.decreaseCount();
		assertEquals(expected, result);
	}
}
