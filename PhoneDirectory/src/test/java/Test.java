package test.java;

import main.java.PhoneDirectory;
import java.io.*;
import java.util.*;

public class Test{
	public static void main(String[] args) throws Exception{
		String propFileName = "phone.properties";
		PhoneDirectory p = new PhoneDirectory();
		p.populateFromFile(propFileName);
		p.printStates();
		
		
		//let's add some numbers 
		String response = "y";
		String name, number, res;
		do {
			System.out.println("Add (a) or Delete(d) or Get_Number(g) or Update(u): ");
			Scanner scan = new Scanner(System.in);
			res = scan.nextLine();
			if (res.equals("a")){
				System.out.println("Enter the name: ");
				name = scan.nextLine();
				System.out.println("Enter the number: ");
				number = scan.nextLine();
				p.addEntry(name, number);
			} else if(res.equals("d")){
				System.out.println("Enter the name you want to delete: ");
				name = scan.nextLine();
				p.deleteEntry(name);
			} else if(res.equals("g")){
				System.out.println("Enter the name you are looking for: ");
				name = scan.nextLine();
				System.out.println(p.getNumber(name));
			} else if(res.equals("u")){
				System.out.println("Enter the name you want to update: ");
				name = scan.nextLine();
				System.out.println("Enter the new phone number: ");
				number = scan.nextLine();
				p.ChangeEntry(name, number);
			} 
			System.out.println("You want to continue (y/n): ");
			response = scan.nextLine();
		} while(!response.equals("n"));
		
		p.storeIt("src/phone.properties");
		p.printStates();
		
	}
}