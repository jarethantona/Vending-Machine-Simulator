package com.techelevator;
import java.util.List;
import java.util.TreeMap;
public class Inventory {
	
	// Constants
	private static final int SLOT_LOCATION = 0;
	private static final int PRODUCT_NAME = 1;
	private static final int PRICE = 2;
	private static final int TYPE = 3;
	
	public TreeMap<String, VendingMachineItems> inventory;
	
	public TreeMap<String, VendingMachineItems> getInventory(List<String[]> items){
		TreeMap<String, VendingMachineItems> inventory = new TreeMap<String, VendingMachineItems>();
		
		for(String[] itemLine : items) {
			 
			if(itemLine[TYPE].equals("Chip")) {
				double price = Double.parseDouble(itemLine[PRICE]);
				Chips chip = new Chips(itemLine[SLOT_LOCATION], itemLine[PRODUCT_NAME], price, 5);
				inventory.put(itemLine[SLOT_LOCATION], chip);
			} else if (itemLine[TYPE].equals("Candy")) {
				double price = Double.parseDouble(itemLine[PRICE]);
				Candy candy = new Candy(itemLine[SLOT_LOCATION], itemLine[PRODUCT_NAME], price, 5);
				inventory.put(itemLine[SLOT_LOCATION], candy);
			} else if (itemLine[TYPE].equals("Drink")) {
				double price = Double.parseDouble(itemLine[PRICE]);
				Beverage drink = new Beverage(itemLine[SLOT_LOCATION], itemLine[PRODUCT_NAME], price, 5);
				inventory.put(itemLine[SLOT_LOCATION], drink);
			} else if (itemLine[TYPE].equals("Gum")) {
				double price = Double.parseDouble(itemLine[PRICE]);
				Gum gum = new Gum(itemLine[SLOT_LOCATION], itemLine[PRODUCT_NAME], price, 5);
				inventory.put(itemLine[SLOT_LOCATION], gum);
			}
		
		}
		return inventory;
	}
	
	
}
	
	
	

