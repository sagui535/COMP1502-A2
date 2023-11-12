package model;

public class Figure extends Toy{
	
private String classification;
//private String serialNumber; //specific attribute 0,1

	public Figure(String serialNumber, String name, String brandName, double price, int availableCount, int ageAppropriate, String classification) {
		super(name, serialNumber, brandName, price, availableCount, ageAppropriate);
		this.classification = classification;
	}

	//getter and setter methods for figure attributes
	//classification
	public String getClassification() {
		return classification;
	}
	
	public void setClassification(String classification) {
			this.classification = classification;
	
	}
	
	public String toString() {
		//override common tostring method to include figure details
		return super.toString() + "\nclassification: " + classification;
	}
	
}
