package com.techelevator.view;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.Beverage;
import com.techelevator.Candy;
import com.techelevator.Chips;
import com.techelevator.Gum;

import com.techelevator.Inventory;
import com.techelevator.VendingMachineItems;


public class InventoryTest {

	private Inventory inventory;
	
	@Before
	public void setup() {
		inventory = new Inventory();
	}
	
	@Test
	public void testGetInventoryGetSlot() {
		List<String []> inventoryList = new ArrayList();
		String[] inventoryItem1 = {"D4", "Snickers", "1.0", "Candy", "5"};  
		String[] inventoryItem2 = {"C1", "Cola", "2.0", "Drink", "4"};
		inventoryList.add(inventoryItem1);
		inventoryList.add(inventoryItem2);
		
		VendingMachineItems expected1 = new VendingMachineItems("D4", "Snickers", 1.0, 5);
		VendingMachineItems expected2 = new VendingMachineItems("C1", "Cola", 2.0, 4);
		
		TreeMap<String, VendingMachineItems> expected = new TreeMap<>();
		expected.put("D4", expected1);
		expected.put("C1", expected2);
		
		TreeMap<String, VendingMachineItems> result = inventory.getInventory(inventoryList);
		
		assertEquals(expected.get("D4").getSlot(), result.get("D4").getSlot());
	}
	
	@Test
	public void testGetInventory_withBeverage() {
		List<String []> inventoryList = new ArrayList();
		String[] inventoryItem1 = {"C2", "Dr. Salt", "1.0", "Drink", "5"};  
		String[] inventoryItem2 = {"C1", "Cola", "2.0", "Drink", "4"};
		inventoryList.add(inventoryItem1);
		inventoryList.add(inventoryItem2);
		
		Beverage expected1 = new Beverage("C2", "Dr. Salt", 1.50, 5);
		Beverage expected2 = new Beverage("C1", "Cola", 2.0, 4);
		
		TreeMap<String, VendingMachineItems> expected = new TreeMap<>();
		expected.put("C2", expected1);
		expected.put("C1", expected2);
		
		TreeMap<String, VendingMachineItems> result = inventory.getInventory(inventoryList);
		
		assertEquals(expected.get("C2").getSlot(), result.get("C2").getSlot());
	}
	
	@Test
	public void testGetInventory_withChips() {
		List<String []> inventoryList = new ArrayList();
		String[] inventoryItem1 = {"A1", "Potato Crisps", "1.0", "Chip", "5"};  
		String[] inventoryItem2 = {"A2", "Stackers", "2.0", "Chip", "4"};
		inventoryList.add(inventoryItem1);
		inventoryList.add(inventoryItem2);
		
		Chips expected1 = new Chips("A1", "Potato Crisps", 1.0, 5);
		Chips expected2 = new Chips("A2", "Stackers", 2.0, 4);
		
		TreeMap<String, VendingMachineItems> expected = new TreeMap<>();
		expected.put("A1", expected1);
		expected.put("A2", expected2);
		
		TreeMap<String, VendingMachineItems> result = inventory.getInventory(inventoryList);
		
		assertEquals(expected.get("A1").getSlot(), result.get("A1").getSlot());
	}
	
	@Test
	public void testGetInventory_withCandy() {
		List<String []> inventoryList = new ArrayList();
		String[] inventoryItem1 = {"B1", "Moonpie", "1.0", "Candy", "5"};  
		String[] inventoryItem2 = {"B2", "Cowtales", "2.0", "Candy", "4"};
		inventoryList.add(inventoryItem1);
		inventoryList.add(inventoryItem2);
		
		Candy expected1 = new Candy("B1", "Moonpie", 1.0, 5);
		Candy expected2 = new Candy("B2", "Cowtales", 2.0, 4);
		
		TreeMap<String, VendingMachineItems> expected = new TreeMap<>();
		expected.put("B1", expected1);
		expected.put("B2", expected2);
		
		TreeMap<String, VendingMachineItems> result = inventory.getInventory(inventoryList);
		
		assertEquals(expected.get("B1").getSlot(), result.get("B1").getSlot());
	}
	
	@Test
	public void testGetInventory_withGum() {
		List<String []> inventoryList = new ArrayList();
		String[] inventoryItem1 = {"D3", "Chiclets", "1.0", "Chip", "5"};  
		String[] inventoryItem2 = {"D4", "Triplemint", "2.0", "Chip", "4"};
		inventoryList.add(inventoryItem1);
		inventoryList.add(inventoryItem2);
		
		Gum expected1 = new Gum("D3", "Chiclets", 1.0, 5);
		Gum expected2 = new Gum("D4", "Triplemint", 2.0, 4);
		
		TreeMap<String, VendingMachineItems> expected = new TreeMap<>();
		expected.put("D3", expected1);
		expected.put("D4", expected2);
		
		TreeMap<String, VendingMachineItems> result = inventory.getInventory(inventoryList);
		
		assertEquals(expected.get("D3").getSlot(), result.get("D3").getSlot());
	}
}
