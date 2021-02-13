package com.techelevator.view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}
	
	public Menu() {
		
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}
	
	public String getChoice() {
		System.out.println("Please Select Product");
		return in.nextLine().toUpperCase();
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}
	
	public double feedMoney() {
		System.out.println("How much money are you inputing: $1, $2, $5, or $10?");;
		while(in.hasNextLine()) {
			String choice = in.nextLine();
			if(choice.equals("1")) {
				return 1.00;
			} else if (choice.equals("2")) {
				return 2.00;
			} else if(choice.equals("5")) {
				return 5.00;
			} else if(choice.equals("10")) {
				return 10.00;
			} else {
				out.println("Please enter a valid amount of money.");
				out.flush();
			}
		}
		 return 0.0;
	}
	
	
		
}
