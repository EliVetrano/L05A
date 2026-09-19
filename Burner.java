/*
* Burner:
* It contains five different functions to make the main Stove code work and look like it's supposed to. It also takes from Settings for the display() function to look like it's intended.
* Authors: Eli Vetrano, Eric Casademont
* Sources: GeekforGeeks
* Date: 09/18/2026
* */


package L05A;

public class Burner{
	/** 
	 * Declare varibles and enum class
	 */
	public enum Temperature {BLAZING, HOT, WARM, COLD};
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	public static final int TIME_DURATION = 2;
	
	/** 
	 * Constructor for the burner
	 * Set temp and setting to lowest values
	 */
	public Burner() {
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
	}
	
	/** 
	 * Make mySetting variable increase to one higher level, and if at max keep the same
	 */
	public void plusButton() {
		switch (mySetting) {
			case Setting.OFF:
				mySetting = Setting.LOW;
				break;
			case Setting.LOW:
				mySetting = Setting.MEDIUM;
				break;
			case Setting.MEDIUM:
				mySetting = Setting.HIGH;
				break;
			case Setting.HIGH:
				break;
		}
		timer = TIME_DURATION;
	}
	
	/** 
	 * Make mySetting variable decrease to one lower level, and if at min keep the same
	 */
	public void minusButton() {
		switch (mySetting) {
			case Setting.HIGH:
				mySetting = Setting.MEDIUM;
				break;
			case Setting.MEDIUM:
				mySetting = Setting.LOW;
				break;
			case Setting.LOW:
				mySetting = Setting.OFF;
				break;
			case Setting.OFF:
				break;
		}
		timer = TIME_DURATION;
	}
	
	
	/** 
	 * Getter for myTemperature private variable
	 */
	public Temperature getTemperature() {
		return myTemperature;
	}
	
	/** 
	 * Make myTemperature variable decrease to one lower level, and if at min keep the same
	 */
	public void decreaseTemp() {
		switch (myTemperature) {
		case Temperature.COLD:
			break;
		case Temperature.WARM:
			myTemperature = Temperature.COLD;
			break;
		case Temperature.HOT:
			myTemperature = Temperature.WARM;
			break;
		case Temperature.BLAZING:
			myTemperature = Temperature.HOT;
			break;
		}
	}
	
	/** 
	 * Make myTemperature variable increase to one higher level, and if at max keep the same
	 */
	public void increaseTemp() {
		switch (myTemperature) {
		case Temperature.COLD:
			myTemperature = Temperature.WARM;
			break;
		case Temperature.WARM:
			myTemperature = Temperature.HOT;;
		case Temperature.HOT:
			myTemperature = Temperature.BLAZING;
			break;
		case Temperature.BLAZING:
			break;
		}
	}
	
	/** 
	 * Decrease the timer variable and if that sets timer to 0, run the main code and reset timer to 2
	 * The code will check where the mySetting variable value is, and move the myTemperature varibale
	 * down or up, depending on the value of mySetting compared to the myTemperature variable.
	 * If they are in the same value for their enums, nothing will change
	 */
	public void updateTemperature() {
		timer--;
		if(timer == 0) {
			timer = TIME_DURATION;
			switch (mySetting) {
			case Setting.OFF:
				if(myTemperature == Temperature.COLD) {
					break;
				} else {
					decreaseTemp();
				}
				break;
			case Setting.LOW:
				if(myTemperature == Temperature.HOT || myTemperature == Temperature.BLAZING) {
					decreaseTemp();
				} else if(myTemperature == Temperature.COLD){
					increaseTemp();
				} else {
					break;
				}
				break;
			case Setting.MEDIUM:
				if(myTemperature == Temperature.COLD || myTemperature == Temperature.WARM) {
					increaseTemp();
				} else if(myTemperature == Temperature.BLAZING){
					decreaseTemp();
				} else {
					break;
				}
				break;
			case Setting.HIGH:
				if(myTemperature == Temperature.BLAZING) {
					break;
				} else {
					increaseTemp();
				}
				break;
			}
		}
	}
	
	/** 
	 * Print out mySetting along with a preset message depending on the myTemperatrue currrent value
	 */
	public void display() {
		
		switch (myTemperature) {
		case Temperature.COLD:
			System.out.println(mySetting + ".....cooool");
			break;
		case Temperature.WARM:
			System.out.println(mySetting + ".....warm");
			break;
		case Temperature.HOT:
			System.out.println(mySetting + ".....CAREFUL");
			break;
		case Temperature.BLAZING:
			System.out.println(mySetting + ".....VERY HOT! DON'T TOUCH");
			break;
		}
	}
}
