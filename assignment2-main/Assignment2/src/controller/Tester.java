package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList; //added

import java.util.Scanner;	//added

import model.Animal;
import model.Figure;
import model.Toy;
import view.MenuView;

/**
 * This class manages the game
 * Contains methods to play game, load and save player data
 * Search for players, and find top players
 */

public class Tester {
	//File path to save and load player data
	private final String FILE_PATH = "res/toys.txt";
	//ArrayList<Toy> toys = new ArrayList <>(); ?? this was here
	MenuView menView;
	public ArrayList<Toy> toys;
	//private Scanner enter;
	
	
	/**
     * Initializes the player list, main menu, and scanner for user input
     * Calls the loadData method to load existing players
	 * @throws FileNotFoundException 
     * 
     * @throws Exception if there is an error during initialization
     */
	
public void loadData() throws Exception {
	File db = new File(FILE_PATH);
	String currentLine;
	String[] splitLine;
	ArrayList<Toy> toys = new ArrayList <>();
	
	
	if (db.exists()) {
		Scanner fileReader = new Scanner(db);
		while (fileReader.hasNextLine() ) {
			currentLine = fileReader.nextLine();
			splitLine = currentLine.split(";");
			//checks serial number for different toy types
			String serialNumber = splitLine[0]; 
			char charOne = serialNumber.charAt(0); //checks first dig of serial num
			if (charOne =='0' || charOne == '1') {
				Figure t = new Figure(splitLine[0]), splitLine[1], splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]), splitLine[6]);
				toys.add(t);
			}
			
			
			//for sn if 
			Toy t = new Toy(splitLine[0], splitLine[1], splitLine[2], splitLine[3],Integer.parseInt(splitLine[4]), Integer.parseInt(splitLine[5]));
			toys.add(t);
	// 2835360879;Cow;Game Assassin;19.52;3;7;Plastic;M
		}
	}
}
	
	
	public Tester() throws Exception {
		toys = new ArrayList<>();
		menView = new MenuView();
		enter = new Scanner(System.in);
		loadData();
		launchApp();
	}

	 /**
     * Launches the game
     * Displays main menu and process user input.
     *
     * @throws Exception if there is an error during the game execution.
     */
	private void launchApp() throws Exception {
		boolean flag = true;
		
		while (flag) {
			int option = menView.showMainMenu();
			
			switch (option) {
			case 1:
				Search();
				//menView.showSubMenu();
				break;
			case 2:
				menView.addNewToy();
				break;
			case 3:
				menView.removeToy();
				break;
			case 4:
				flag = false;
				//Save();
				break;
			default:
				System.out.println("Invalid choice. Try again!");
			}
		}
	}
	



	/**
     * Manage search sub menu including finding top players,
     * searching name and returning to main menu
     */
	private void Search() {
	        int option = menView.showSubMenu();

	        switch (option) {
	            case 1:
	                findSerialNum();
	                break;
	            case 2:
	            	String name = menView.promtToyName();	       
	            	toys = searchByToyName(name);
	            	
	                //ArrayList<Toy> toyName = searchByToyName();
	                //for (Toy t: toyName) {
	                	//menView.showToyName(t);
	                //}
	                break;
	            case 3:
	            	break;
	            default:
					System.out.println("Invalid choice. Try again!");
					Search();
	        }
	}
	
	private Toy findSerialNum() {
		String sn = menView.promtSN();
		Toy serialNum = null;
		
		for (Toy t: toys) {
			if (t.getSerialNumber().equals(sn)) {
				serialNum = t;
				System.out.println(serialNum);
				break;
			}
		}
		
		return serialNum;
		
	}


	/**
     * Searches player name and displays wins and balance
     */
	public ArrayList<Toy> searchByToyName(String name) {
		Scanner input = new Scanner(System.in);
		//String name = menView.promtToyName();
		String name = input.nextLine();
		Toy toyName = null;
		ArrayList<Toy> matchedToys = new ArrayList<>();
		
		for (Toy t: toys) {
			if (t.getName().toLowerCase().contains(name.toLowerCase())) {
				toyName = t;
				matchedToys.add(t);
				break;
			}
		}
		if (!matchedToys.isEmpty()) {
	        //System.out.println(toyName.getName());
			System.out.println(toyName);
	        System.out.println("Press \"Enter\" to continue...");
		    enter.nextLine();
		    
		
		} else {
	        System.out.println("Toy name does not exist. Try again!");
	    }
		return matchedToys;
	}
	


	
	 /**
     * Saves player data to text file
     *
     * @throws IOException if error during the save operation.
     */
	//private void Save() throws IOException {
		//System.out.println("Saving Date Into Database...");
		
		
		//File db = new File(FILE_PATH);
		//PrintWriter pw = new PrintWriter(db);
		
		//for (Toy t: toys) {
			//pw.println(t.format());
		//}
		//pw.close();
		//System.out.println("Thanks for Visiting!");
	//}

	 /**
     * Loads player data from text file
     *
     * @throws Exception if error during the load operation
     */
	//private void loadData() throws Exception {
		//File db = new File(FILE_PATH);
		//String currentLine;
		//String[] splitLine;
		
		
		//if (db.exists()) {
			//Scanner fileReader = new Scanner(db);
			//while (fileReader.hasNextLine()) {
				//currentLine = fileReader.nextLine();
				//splitLine = currentLine.split(";");
				//Toy t = new Toy(splitLine[0], 0, currentLine, Double.parseDouble(splitLine[1]), Integer.parseInt(splitLine[2]), 0);
				//toys.add(t);
			//}
		//fileReader.close();
		//}
		
	//}
}
