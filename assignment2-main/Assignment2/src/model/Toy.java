package model;

public abstract class Toy {
	protected String serialNumber;
	protected String name;
	protected String brandName;
	private double price;
	private int availableCount;
	private int ageAppropriate;

public Toy(String serialNumber, String name, String brandName, double price, int availableCount, int ageAppropriate)
{
	//explanation comment
	this.name = name;
	this.serialNumber = serialNumber;
	this.brandName = brandName;
	this.price = price;
	this.availableCount = availableCount;
	this.ageAppropriate = ageAppropriate;	
}
// getters and setters 
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSerialNumber() {
	return this.serialNumber;
}
public void setSerialNumber(String serialNumber) {
	this.serialNumber = serialNumber;
}
public String getBrandName() {
	return this.brandName;
}
public void setBrandName(String brandName) {
	this.brandName = brandName;
}
public double getPrice() {
	return this.price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getAvailableCount() {
	return this.availableCount;
}
public void setAvailableCount(int availableCount) {
	this.availableCount = availableCount;
}
public int getAgeAppropriate() {
	return this.ageAppropriate;
}
public void setAgeAppropriate(int ageAppropriate) {
	this.ageAppropriate = ageAppropriate;
}
// to string: returns a string representation
public String toString() {
	return brandName;
	
}


public String format() {
	return serialNumber+";"+name+";"+brandName+";"+price+";"+availableCount+";"+ageAppropriate;
}


}
