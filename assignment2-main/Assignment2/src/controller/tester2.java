package controller;

import java.io.File;
import java.io.FileNotFoundException;
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
 * This class manages the toy store and implements the functionality of searching, purchasing, adding and removing toys.
 */
public class tester2 {
	public ArrayList <Toy> listOfToys; // list of all toys in the store
	MenuView appMen; // menu interface
	private final String FILE_PATH = "res/toys.txt"; // file path for storing toy data
	
	/**
	 * Creates a new StoreManager object with a new instance of the AppMenu class.
	 */
	public tester2(){
		appMen = new MenuView();
	}
	
	/**
	 * Loads toy data from a file and populates the listOfToys ArrayList.
	 * @throws Exception if there is an error while reading from the file.
	 */
	public void loadData() throws Exception {
		listOfToys = new ArrayList<>(); // initialize list of toys
		File info = new File(FILE_PATH); // create file object
		String currentLine;
		String[] splittedLine;
		if(info.exists()) { // check if file exists
			Scanner fileReader = new Scanner(info); // create file reader object
			while (fileReader.hasNextLine()){ // loop through file
				currentLine = fileReader.nextLine(); // read a line
				splittedLine = currentLine.split(";"); // split the line by semicolon
				String SerialNumber = splittedLine[0];
				char firstchar = SerialNumber.charAt(0);
				if (firstchar == '0' || firstchar == '1') { // if toy is a figure
					Figure t = new Figure(splittedLine[0],
					splittedLine[1],
					splittedLine[2],
					Double.parseDouble(splittedLine[3]),
					Integer.parseInt(splittedLine[4]),
					Integer.parseInt(splittedLine[5]),
					splittedLine[6]); // create a new Figure object
					listOfToys.add(t); // add the toy to the list
				}
				if (firstchar == '2' || firstchar == '3') { // if toy is an animal
					Animal t = new Animal(splittedLine[0],
					splittedLine[1],
					splittedLine[2],
					Double.parseDouble(splittedLine[3]),
					Integer.parseInt(splittedLine[4]),
					Integer.parseInt(splittedLine[5]),
					splittedLine[6],splittedLine[7]); // create a new Animal object
					listOfToys.add(t); 
				}
				if (firstchar == '4' || firstchar == '5' || firstchar == '6') {
					Puzzle t = new Puzzle(splittedLine[0],
					splittedLine[1],
					splittedLine[2],
					Double.parseDouble(splittedLine[3]),
					Integer.parseInt(splittedLine[4]),
					Integer.parseInt(splittedLine[5]),splittedLine[6]);
					listOfToys.add(t);
				}
				if (firstchar == '7' || firstchar == '8' || firstchar == '9') {
					String[] maxmin = splittedLine[6].split("-");
					BoardGame t = new BoardGame(splittedLine[0],
					splittedLine[1],
					splittedLine[2],
					Double.parseDouble(splittedLine[3]),
					Integer.parseInt(splittedLine[4]),
					Integer.parseInt(splittedLine[5]),
					Integer.parseInt(maxmin[1]),
					Integer.parseInt(maxmin[0]),splittedLine[7]);
					listOfToys.add(t);
				}
			
		}
		fileReader.close();
	}	
		else {
			System.out.print("File Not Found\n");
		}
		
	}

	public void lauch() throws FileNotFoundException{
		boolean flag = true;
		int option;
		while(flag){
			option = appMen.showMainMenu();
			switch(option){
			case 1 :
				searchAndPurchase();
				break;
			case 2 :
				Toy t = appMen.addNewToy();
				break;
			case 3 :
				String rem = appMen.removeToy();
				break;
			case 4 :
				Save();
				flag = false;
				break;

				
			}
		}
	}
	public void searchAndPurchase(){
		boolean flag = true;
		int option;
		ArrayList<Toy> toys;
		while (flag){
			option = appMen.showSubMenu();
			Toy selectedtoy;
			switch(option){
				case 1 :
					String SN = appMen.promtSN();
					toys = getToyBySerialNumber(SN);
					if (toys.size() == 0){
						appMen.promtError();
						break;
					} else{
						appMen.printToys(toys);
						selectedtoy = appMen.PurchaseListIndex(toys);
						purchaseToy(selectedtoy);
						break;
					}
				case 2 :
					String name = appMen.getToyName();
					toys = searchByName(name);
					if (toys.size() == 0){
						appMen.notValid();
						break;
					} else{
						appMen.printToys(toys);
						selectedtoy = appMen.PurchaseListIndex(toys);
						purchaseToy(selectedtoy);
						break;
					}
				case 3 :
					String type = appMen.getType();
					toys = ByType(type);
					if (toys.size() == 0){
						appMen.notValid();
						break;
					} else{
					appMen.printToys(toys);
					selectedtoy = appMen.PurchaseListIndex(toys);
					purchaseToy(selectedtoy);
					break;
					}
				case 4 :
					flag = false;
					break;
	
					
			}
		}
	}
	public void purchaseToy(Toy selectedToy){
		if (selectedToy == null){
			return ;
		}
		for (Toy t:listOfToys) {
            if (t.getSerialNumber().equals(selectedToy.getSerialNumber())) {
				int count = t.getAvailableCount();
				count = count -1;
                t.setAvailableCount(count);
				appMen.purchaseComplete();
			}
		}
	}
	public ArrayList <Toy> getToyBySerialNumber(String serialNumber) {
        ArrayList<Toy> toys = new ArrayList<>();
		for (Toy t:listOfToys) {
            if (t.getSerialNumber().equals(serialNumber)) {
                toys.add(t);
			}
		}
		return toys;
	}

	public ArrayList <Toy> ByType(String type){
		ArrayList<Toy> toys = new ArrayList<>();
		for(Toy t: listOfToys){
			if(t.getClass().getName().toLowerCase().contains(type)){
				toys.add(t);
			}
		}
		return toys;
	}
	


	public ArrayList <Toy> searchByName(String name) {
		ArrayList<Toy> toys = new ArrayList<>();
		for(Toy t: listOfToys){
			if (t.getName().toLowerCase().contains(name.toLowerCase())){
				toys.add(t);
			}
			
		}
		return toys;
	}

	
	public void Save() throws FileNotFoundException {
		File info = new File(FILE_PATH );
		PrintWriter pw;
		pw = new PrintWriter(info);
		for (Toy t: listOfToys) {
			pw.println(t.formatToFile());
		}
		pw.close();
	}


}
	
