/*
* Setting:
* This file contains the code for the settings of the stove, with an  enum to make the extraction of values more accessible and readable for an external person.
* Authors: Eli Vetrano, Eric Casademont
* Date: 09/18/2026
* */


package L05A;

public enum Setting { 
	/** 
	 * Declare the possible variables for Setting with different output values
	 */
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	private String value;
	
	/** 
	 * Constructor for Setting enum. Sets the value to the given attribute
	 */
	Setting (String aValue) {
		value = aValue;
	}
	
	/** 
	 * Override toString to output the value variable
	 */
	public String toString() {
		return "[" + value + "]";
	}
	
}

