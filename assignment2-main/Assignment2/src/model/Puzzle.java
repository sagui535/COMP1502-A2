package model;

public class Puzzle extends Toy{
	private String puzzleType;
	
	public Puzzle(String name, String serialNumber, String brandName, double price, int availableCount,
			int ageAppropriate, String puzzleType) {
		super(name, serialNumber, brandName, price, availableCount, ageAppropriate);
		this.puzzleType = puzzleType;
		// TODO Auto-generated constructor stub
	}
	
	public String getPuzzleType() {
		return puzzleType;
	}
	
	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}
	
	public String toString() {
		return super.toString() + "\nPuzzle Type: " + puzzleType;
	}

}
