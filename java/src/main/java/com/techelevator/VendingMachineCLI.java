package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.techelevator.view.Menu;

public class VendingMachineCLI {
	//MAIN MENU
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	//PURCHASE MENU
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY ="Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	
	private Menu menu;
	private Inventory inventory = new Inventory();
	private TreeMap<String, VendingMachineItems> inventoryItems; 
	private Logger logger = new Logger();
	
	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		FileReader fileReader = new FileReader();
		File file = new File("vendingmachine.csv");
		try {
			
			List<String[]> inventoryList = fileReader.getItems(file);
			inventoryItems = inventory.getInventory(inventoryList);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	public void run() throws FileNotFoundException {
		double balance = 0;
		double pastBalance = 0;
		Calculator calculator = new Calculator();
				
		
		
		boolean inTransaction = true;
		boolean inPurchase = true;

		while (inTransaction) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				for (Map.Entry<String, VendingMachineItems> item : inventoryItems.entrySet()) {
					System.out.println(item.getKey() + "|" + item.getValue().getName() + "|" + item.getValue().getPrice()+ "|" + item.getValue().getCount());
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				inPurchase = true;
				while(inPurchase) {
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						double insertedMoney = menu.feedMoney();
						pastBalance = balance;

						balance = calculator.insertMoney(insertedMoney, balance);
						
						try {
							logger.writeToLog("FEED MONEY: " + pastBalance + " " + balance + "\r");
						} catch (IOException e) {
							System.out.println("Error trying to log message.");
						}

						System.out.println("Current Money Provided: $" + balance);
					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						for(Map.Entry<String, VendingMachineItems> item : inventoryItems.entrySet()) {
							System.out.println(item.getKey() + "|" + item.getValue().getName() + "|" + item.getValue().getPrice() + "|" + item.getValue().getCount());
						}
						
						String itemChoice = null;
						while(itemChoice == null ) {
							try {
								itemChoice = menu.getChoice();
								
								VendingMachineItems chosenItem = inventoryItems.get(itemChoice);
							
								
							
								if (chosenItem.getPrice() > balance) {
									System.out.println("Insufficient funds to purchase " + chosenItem.getName());
								} else if (chosenItem.getCount() <= 0) {
									System.out.println("Sold out");
								} else {
									chosenItem.decreaseCount();
									pastBalance = balance;
									balance = calculator.chargeMoney(chosenItem.getPrice(), balance);
									System.out.println(chosenItem.getSound());
									System.out.println("Your balance is $" + balance);
									String itemName = chosenItem.getName();
									String itemSlot = chosenItem.getSlot();
									
									try {
										logger.writeToLog(itemName + " " + itemSlot + "$" + pastBalance + " $" + balance + "\r");
									} catch (IOException e) {
										System.out.println("Error trying to log message");
									}
								}
							}
								catch(Exception e) {
									System.out.println("Please provide valid choice");
								}
						}
					} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					System.out.println(calculator.makeChange(balance));
					balance = 0;
					inPurchase = false;
				}
					
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				inTransaction = false;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);

		try {
			cli.run();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
