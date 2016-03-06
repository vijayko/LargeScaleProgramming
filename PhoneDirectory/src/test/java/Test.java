package test.java;

import main.resources.*;
import main.java.PhoneDirectory;
import java.io.*;
import java.util.*;

public class Test{
	public static void main(String[] args) throws Exception{

		PhoneDirectory phoneBook = new PhoneDirectory();
		phoneBook.populateFromFile();
		phoneBook.addEntry("John", "2025678901");
		phoneBook.addEntry("Anu", "5718907890");
		phoneBook.changeEntry("Anu", "1245690909");
		phoneBook.changeEntry("John", "5712792121");
		phoneBook.addEntry("Biswa", "9091235678");
		phoneBook.getNumber("Ashok");
		phoneBook.deleteEntry("Sam");
		
		phoneBook.storeIt(); 
		phoneBook.printStates();
		
	}
}