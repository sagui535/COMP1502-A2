package view;

import java.util.Scanner;

import model.Toy;

/**
 * MenuView Class
 * 
 */
public class MenuView {
    //private static Scanner input = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
	

    public int showMainMenu() {
    	//prints welcome message
    	System.out.println("*****************************************");
        System.out.println("*	WELCOME TO TOY STORE COMPANY!	*");
        System.out.println("*****************************************\n");
        
        //print main menu options to user
        System.out.println("How May We Help You?\n");
        System.out.println("\t(1) Search Inventory and Purchase Toy");
        System.out.println("\t(2) Add New Toy");
        System.out.println("\t(3) Remove Toy");
        System.out.println("\t(4) Save & Exit\n");
        System.out.print("Enter Option: \n");
    	int option = input.nextInt();
		return option;
    }

    	//print search options to user
    public int showSubMenu() {
        System.out.println("Find Toys With:\n");
        System.out.println("\t(1) Serial Number(SN)");
        System.out.println("\t(2) Toy Name");
        System.out.println("\t(3) Type");
        System.out.println("\t(4) Back to Main menu\n");
        System.out.println("Enter option: \n");
    	int option = input.nextInt();
    	
		return option;
    }
    
    //method when mainmenu option 2 selected
    // this method add new toys and asks user
    //serial num, toy name, brand, price avail, age, num players, 
    //and designer names
    public Toy addNewToy() {
        // Prompts for adding a new toy
        System.out.print("Enter Serial Number: ");
        input.nextLine();  // Consume the newline character
        String serialNumber = input.nextLine();

        System.out.print("Enter Toy Name: ");
        String toyName = input.nextLine();
        
        System.out.print("Enter Toy Brand: ");
        double toyBrand = input.nextDouble();

        System.out.print("Enter Toy Price: ");
        double toyPrice = input.nextDouble();

        System.out.print("Enter Available Counts: ");
        int availableCounts = input.nextInt();

        System.out.print("Enter Appropriate Age: ");
        int appropriateAge = input.nextInt();

        System.out.print("Enter Minimum Number of Players: ");
        int minNumOfPlayers = input.nextInt();

        System.out.print("Enter Maximum Number of Players: ");
        int maxNumOfPlayers = input.nextInt();

        input.nextLine();  // Consume the newline character

        System.out.print("Enter Designer Names (Use ',' to seperate the names if there is more than one name): ");
        String designingNames = input.nextLine();

        System.out.println("New Toy Added!");
        System.out.println("Press Enter to Continue...");
        input.nextLine();
		return null;
    }

    //main menu option 3
    //removes toy NOT COMPLETED
    public String removeToy() {
    	System.out.print("Enter Serial Number: ");
        String serialNumber = input.nextLine();  // Consume the newline character
        return serialNumber;
    	
    }
    
	public void showToyName(Toy toyName) {
		System.out.println(toyName);
	}

	public String promtToyName() {
		System.out.println("Enter name of toy: ");
		String name = input.nextLine();
		return name;
	}
	
	public String promtSN() {
		System.out.println("Enter Serial Number:");
		String sn = input.nextLine();
		return sn;
	}
	
	public void promtError() {
		System.out.println("Please try again.");
		input.nextLine();
	}

}
