package model;

public class BoardGame extends Toy{
	private int minPlayers;
	private int maxPlayers;
	private String designers;

	public BoardGame(String name, String serialNumber, String brandName, double price, int availableCount,
			int ageAppropriate, int minPlayers, int maxPlayers, String designers) {
		super(name, serialNumber, brandName, price, availableCount, ageAppropriate);
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.designers = designers;
		// TODO Auto-generated constructor stub
	}
	
	//getter and setter methods for boardgame attributes
	//minplayers, maxplayers, and designers
	public int getMinPlayers() {
		return minPlayers;
	}
	
	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}
	
	public int getMaxPlayers() {
		return maxPlayers;
	}
	
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	
	public String getDesigners() {
		return designers;
	}
	
	public void setDesigners(String designers) {
		this.designers = designers;
	}
	
	public String toString() {
		return super.toString() + "\nMinimum Players: " + minPlayers + "\nMaximum Players: " + maxPlayers + "\nDesigners: " + designers;
	}
	
	
}
