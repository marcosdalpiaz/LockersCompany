package com.simplilearn.assessment;

import java.util.Scanner;

public class Menu {

	private Scanner shortcut;
	private FileManagement fm = new FileManagement();
	
	public void starting() {
		System.out.println("\n\n### Welcome to LockedMe.com ###\n### Company Lockers Pvt. Ltd. software. ###\n### Developed by Marcos Varallo ###");
		menuFiles();
	}
	// Menu functionalities
	private void menuFiles() {
		
		int option = 0;
		Scanner menu = new Scanner (System.in);
		do {
			System.out.println("\n                  =====================================");
			System.out.println("                  |    1 - List all existing files:   |");
			System.out.println("                  |    2 - Business Level Operations: |");
			System.out.println("                  |    0 - Exit!                      |");
			System.out.println("                  =====================================\n");

			option = menu.nextInt();
			System.out.print("\n");
			switch (option) {
			case 1:
				listFiles();
				break;
			case 2:				
				System.out.print("Select one of the Operations below:\n\n");
				System.out.print("1 - Add file.\n");
				System.out.print("2 - Delete file.\n");
				System.out.print("3 - Search for a file.\n");
				System.out.print("0 - Main Menu.\n");
				shortcut = new Scanner(System.in);
				
				int optionSelected = shortcut.nextInt();
				if (optionSelected == 1) {
					addFileOperation();
				} else if (optionSelected == 2) {
					deleteFileOperation();
				} else if (optionSelected == 3) {
					searchFileOperation();
				} else if (optionSelected == 0) {
					this.menuFiles();
				}
				break;	        
			case 0:
				System.out.println("Thank you for believe in Lockers. See you soon!");
				System.exit(1);
			default:
				System.out.println("Invalid Option!");
				this.menuFiles();
			}
		} while (option != 0);
		
	}
	
	// Method to list the files inside the directory
	public void listFiles() {
		fm.listFiles();
	}
	
	// Method to add a new file
	public void addFileOperation() {
		shortcut = new Scanner(System.in);
		System.out.println("Inform the name of the new file file that you want to add:");
		String name = shortcut.next();
		System.out.println("Inform a type for this file:");
		String type = shortcut.next();
		String file = name.concat("." + type);
		fm.addFile(file);
	}
	
	// Method to delete a file
	public void deleteFileOperation() {
		shortcut = new Scanner(System.in);
		System.out.println("Inform the name of the new file file that you want to delete:");
		String name = shortcut.next();
		System.out.println("Inform the type of this file:");
		String type = shortcut.next();
		String file = name.concat("." + type);
		fm.deleteFile(file);
	}
	
	// Method to search for a file
	public void searchFileOperation() {
		shortcut = new Scanner(System.in);
		System.out.println("Inform the name of the to be searched:");
		String name = shortcut.next();
		System.out.println("Inform the type of this file:");
		String type = shortcut.next();
		String file = name.concat("." + type);
		fm.searchFile(file);
	}
	
}
