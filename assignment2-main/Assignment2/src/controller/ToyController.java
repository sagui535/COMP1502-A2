package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Animal;
import model.BoardGame;
import model.Figure;
import model.Puzzle;
import model.Toy;
import view.MenuView;

/**
 * Toy controller class
 * Manages toy store 
 */
public class ToyController {
	public ArrayList<Toy> toysList; //list of toys
	MenuView menView;
	private final String FILE_PATH = "res/toys.txt";
   
	/**
	 * ToyController object
	 * @throws Exception 
	 * 
	 */
    public ToyController() throws Exception {
        menView = new MenuView();
        loadData();
		launchApp();
    }
    
    public void loadData() throws FileNotFoundException {
    	toysList = new ArrayList<>();
    	File db = new File(FILE_PATH);
    	String currentLine;
    	String[] splitLine;
    	//ArrayList<Toy> toys = new ArrayList <>();
    	
    	if (db.exists()) {
    		Scanner fileReader = new Scanner(db);
    		while (fileReader.hasNextLine() ) {
    			currentLine = fileReader.nextLine();
    			splitLine = currentLine.split(";");
    			//need to check serial number for different toy types
    			String SerialNumber = splitLine[0];
				char firstchar = SerialNumber.charAt(0);
				if (firstchar == '0' || firstchar == '1') { // if toy is a figure
					Figure t = new Figure(splitLine[0],
					splitLine[1],
					splitLine[2],
					Double.parseDouble(splitLine[3]),
					Integer.parseInt(splitLine[4]),
					Integer.parseInt(splitLine[5]),
					splitLine[6]); // create a new Figure object
					toysList.add(t); // add the toy to the list
				}
				if (firstchar == '2' || firstchar == '3') { // if toy is an animal
					Animal t = new Animal(splitLine[0],
					splitLine[1],
					splitLine[2],
					Double.parseDouble(splitLine[3]),
					Integer.parseInt(splitLine[4]),
					Integer.parseInt(splitLine[5]),
					splitLine[6],splitLine[7]); // create a new Animal object
					toysList.add(t); 
				}
				if (firstchar == '4' || firstchar == '5' || firstchar == '6') {
					Puzzle t = new Puzzle(splitLine[0],
					splitLine[1],
					splitLine[2],
					Double.parseDouble(splitLine[3]),
					Integer.parseInt(splitLine[4]),
					Integer.parseInt(splitLine[5]),splitLine[6]);
					toysList.add(t);
				}
				if (firstchar == '7' || firstchar == '8' || firstchar == '9') {
					String[] maxmin = splitLine[6].split("-");
					BoardGame t = new BoardGame(splitLine[0],
					splitLine[1],
					splitLine[2],
					Double.parseDouble(splitLine[3]),
					Integer.parseInt(splitLine[4]),
					Integer.parseInt(splitLine[5]),
					Integer.parseInt(maxmin[1]),
					Integer.parseInt(maxmin[0]),splitLine[7]);
					toysList.add(t);
				}
    		}
    	fileReader.close();
    	}
    }
    
	public void launchApp() throws Exception {
		boolean flag = true;
		
		while (flag) {
			int option = menView.showMainMenu(); //displays main menu
			
			switch (option) {
			case 1:
				Search();
				break;
			case 2:
				menView.addNewToy();
				//NOT COMPLETED
				break;
			case 3:
				menView.removeToy();
				//NOT COMPLETED
				break;
			case 4:
				flag = false;
				Save();
				break;
			default:
				System.out.println("Invalid choice. Try again!");
			}
		}
	}
	/**
	 * Saves data
	 * @throws FileNotFoundException
	 */
	public void Save() throws FileNotFoundException {
		File db = new File(FILE_PATH);
		PrintWriter pw;
		pw = new PrintWriter(db);
		for (Toy t: toysList) {
			pw.println(t.format());
		}
		pw.close();	
	}

	public void Search() {
		boolean flag = true;
        int option = menView.showSubMenu(); //Display sub-menu
        ArrayList<Toy> toysList2;
        while (flag ) {
        //Toy customerToy;
        switch (option) {
            case 1:
            	String sn = menView.promtSN(); //asks user for SN
                toysList2 = searchToySN(sn);
            	if(toysList2.size() == 0) { //checks if SN is valid
            		menView.promtError(); //display error msg for invalid SN
            		break;
            	}
            	else {
            		menView.displayToys(toysList2);
            		break;
            	}
        
            case 2:
            	String name = menView.promtToyName();	       
            	toysList2 = searchByToyName(name);
            	if (toysList2.size()==0) {
            		menView.promtError(); //display error for invalid toy name
            		break;
            	}
            	else {
            		menView.displayToys(toysList2);
            		break;
            	}
            case 3:
            	//for type NOT COMPLETE
            	String type = menView.getType();
            	toysList2 = toyType(type);
            	if (toysList2.size()==0) {
            		menView.promtError();
            		break;
            	}
            	else {
            		menView.displayToys(toysList2);
            		break;
            	}
            case 4:
            	flag = false;
            	break;
            default:
				System.out.println("Invalid choice. Try again!");
				Search();
        }
        }
		
	}

	public ArrayList<Toy> toyType(String type) {
		ArrayList<Toy> toysList2 = new ArrayList<>();
		for(Toy t: toysList) {
			if(t.getClass().getName().toLowerCase().contains(type)) {
				toysList2.add(t);
			}
		}
		return toysList2;
	}

	public ArrayList<Toy> searchByToyName(String name) {
		ArrayList<Toy> toysList2 = new ArrayList<>();
		for (Toy t: toysList) {
			if (t.getName().toLowerCase().contains(name.toLowerCase())){
				toysList2.add(t);
			}
		}
		return toysList2;
	}

	public ArrayList<Toy> searchToySN(String sn) {
		ArrayList<Toy> toysList2 = new ArrayList<>();
		for (Toy t: toysList) {
			if(t.getSerialNumber().equals(sn)) {
				toysList2.add(t);
			}
		}
		// TODO Auto-generated method stub
		return toysList2;
	}
	

}

   
