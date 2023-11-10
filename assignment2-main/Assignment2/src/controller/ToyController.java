package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import view.MenuView;

public class ToyController {
	private final String FILE_PATH = "res/toys.txt";
    private MenuView menuView;

    public ToyController() {
        this.menuView = new MenuView();
    }

    public void handleMainMenuOption(int mainMenuOption) {
        switch (mainMenuOption) {
            case 1:
                int subMenuOption = menuView.showSubMenu();
                // Handle sub-menu options here
                break;
            case 2:
                menuView.addNewToy(); // Call the non-static method on the menuView instance
                break;
            case 3:
                // Call methods to handle removing a toy
            	menuView.removeToy();
                break;
            case 4:
                // Handle saving and exiting
            	//Save();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
                break;
        }
    }
    
    //main menu option 4 Save and Exits 
    //private void Save() throws IOException {
		//System.out.println("Saving Data Into Database...");
		
		
		//File db = new File(FILE_PATH);
		//PrintWriter pw = new PrintWriter(db);
		
		//for (Player p: players) {
			//pw.println(p.format());
		//}
		//pw.close();
		//System.out.println("******* THANKS FOR VISITING US *******");
	//}
    
  
    }
