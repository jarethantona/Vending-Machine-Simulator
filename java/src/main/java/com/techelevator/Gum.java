package com.techelevator;

public class Gum extends VendingMachineItems {

	private String type =  "Gum";
	private String sound = "\"Chew Chew, Yum!\"";

	public Gum(String slot, String name, double price, int count) {
		super(slot, name, price, count);
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public String getSound() {
		return this.sound;
	}
	
	
	

}
