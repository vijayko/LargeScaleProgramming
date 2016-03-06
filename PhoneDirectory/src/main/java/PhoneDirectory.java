package main.java;

import main.resources.*;

import java.io.*;
import java.util.*;

public class PhoneDirectory{
	//I am using the prop field.
	Properties prop = new Properties();
	FileInputStream inputStream;
	FileOutputStream output;
	File f;
	/*This method populate the prop object with the content in the phone.properties 
	 * It takes no parameter
	 * It simply loads the content of the phone.properties file 
	 * 
	 */
	public void populateFromFile() throws IOException {
		try {
			inputStream = new FileInputStream("/Users/vijay/Code/PhoneDirectory/src/main/resources/phone.properties");
			if (inputStream != null){
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("Not found!!!");
			}
		} catch (Exception e){
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}
	
	/*This method add new entry to prop object
	 * It takes two parameters name and number
	 * and add it to the prop object
	 */
	public void addEntry(String name, String number){
		if (prop.getProperty(name) == null){
			prop.put(name, number);
		}
		else {
			System.out.println("Already in the directory!");
		}
	}
	
	/*This method delete entry from the prop object
	 * this takes one parameter, name 
	 */
	public void deleteEntry(String name){
		if (prop.getProperty(name) != null){
			prop.remove(name);
		}
		else{
			System.out.println("Not in the directory");
		}
	}
	
	//This method gives the number for the given string
	public String getNumber(String name){
		String temp = prop.getProperty(name);
		if (temp != null){
			return temp;
		}
		else{
			return "Not in the directory!";
		}
	}
	
	//Updates the entry of the prop 
	public void changeEntry(String name, String number){
		prop.setProperty(name, number);
	}
	
	//it writes the content of prop to phone.properties
	public void storeIt() throws IOException{
		String propFileName = "/Users/vijay/Code/PhoneDirectory/src/main/resources/phone.properties";
		Set temps;
		String str, value;
		temps = prop.keySet();
		Properties p = new Properties();
		Iterator itr = temps.iterator();
		f = new File(propFileName);
		output = new FileOutputStream(f);
		while(itr.hasNext()){
			str = (String) itr.next();
			value = prop.getProperty(str);
			p.setProperty(str, value);
		}
		p.store(output, null);
		output.close();
	}
	
	//prints the content of prop
	public void printStates(){
		String str;
		Set temps;
		temps = prop.keySet();
		Iterator itr = temps.iterator();
		while(itr.hasNext()){
			str = (String) itr.next();
			System.out.println("Name: " + str + " Phone Number: " + prop.getProperty(str));
		}
		System.out.println();
		
	}
}