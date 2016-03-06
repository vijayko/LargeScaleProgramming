package main;

import java.io.*;
import java.util.*;

public class PhoneDirectory{
	Properties prop = new Properties();
	//Set temps;
	InputStream inputStream;
	FileInputStream in;
	FileOutputStream output;
	File f;
	public void populateFromFile(String propFileName) throws IOException {
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
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
	
	public void addEntry(String name, String number){
		if (prop.getProperty(name) == null){
			prop.put(name, number);
		}
		else {
			System.out.println("Already in the directory!");
		}
	}
	public void deleteEntry(String name){
		if (prop.getProperty(name) != null){
			prop.remove(name);
		}
		else{
			System.out.println("Not in the directory");
		}
	}
	public String getNumber(String name){
		String temp = prop.getProperty(name);
		if (temp != null){
			return temp;
		}
		else{
			return "Not in the directory!";
		}
	}
	public void ChangeEntry(String name, String number){
		prop.setProperty(name, number);
	}
	
	public void storeIt(String propFileName) throws IOException{
		Set temps;
		String str, value;
		temps = prop.keySet();
		Properties p = new Properties();
		Iterator itr = temps.iterator();
		in = new FileInputStream(propFileName);
		p.load(in);
		in.close();
		f = new File(propFileName);
		output = new FileOutputStream(f);
		while(itr.hasNext()){
			str = (String) itr.next();
			value = prop.getProperty(str);
			p.setProperty(str, value);
			System.out.println(str +" " + p.getProperty(str));
		}
		p.store(output, null);
		output.close();
	}
	
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