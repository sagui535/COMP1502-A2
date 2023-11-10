package model;

public class Animal extends Toy {

	private String material;
	private String size;

	public Animal(String name, String serialNumber, String brandName, double price, int availableCount,
			int ageAppropriate, String material, String size) {
		super(name, serialNumber, brandName, price, availableCount, ageAppropriate);
		this.material = material;
		this.size = size;
		
		// TODO Auto-generated constructor stub
	}
	
	//getter and setter methods for animal attributes

	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material ) {
		this.material = material;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public String toString() {
		return super.toString() + "\nMaterial: " + material + "\nSize: " + size;
	}
}
