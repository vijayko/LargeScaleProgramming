package test;

import main.PhoneDirectory;
import java.io.*;
import java.util.*;

public class Test{
	public static void main(String[] args) throws Exception{
		String propFileName = "phone.properties";
		//FileOutputStream output = new FileOutputStream("config.properties");
		//FileInputStream input = new FileInputStream("config.properties");
		PhoneDirectory p = new PhoneDirectory();
		p.populateFromFile(propFileName);
		p.printStates();
		
//		System.out.println("Enter name: ");
//		Scanner scan = new Scanner(System.in);
//		String newName = scan.nextLine();
//		System.out.println("Enter phone: ");
//		scan = new Scanner(System.in);
//		String newPhone = scan.nextLine();
//		p.addEntry(newName, newPhone);
//		p.printStates();
//		
//		System.out.println("Enter name: ");
//		Scanner scan1 = new Scanner(System.in);
//		String newName1 = scan1.nextLine();
//		System.out.println("Enter phone: ");
//		scan1 = new Scanner(System.in);
//		String newPhone1 = scan1.nextLine();
//		p.ChangeEntry(newName1, newPhone1);
//		p.printStates();
		
		//let's add some numbers 
		String response = "y";
		String name, number, res;
		do {
			System.out.println("Add (a) or Delete(d) or Get_Number(g) or Update(u): ");
			Scanner scan = new Scanner(System.in);
			res = scan.nextLine();
			//System.out.println(res == "d");
			if (res.equals("a")){
				System.out.println("Enter the name: ");
				//Scanner scan1 = new Scanner(System.in);
				name = scan.nextLine();
				System.out.println("Enter the number: ");
				//Scanner scan2 = new Scanner("System.in");
				number = scan.nextLine();
				p.addEntry(name, number);
			} else if(res.equals("d")){
				System.out.println("Enter the name you want to delete: ");
				//Scanner scan3 = new Scanner("System.in");
				name = scan.nextLine();
				p.deleteEntry(name);
			} else if(res.equals("g")){
				System.out.println("Enter the name you are looking for: ");
				//Scanner scan5 = new Scanner(System.in);
				name = scan.nextLine();
				System.out.println(p.getNumber(name));
			} else if(res.equals("u")){
				System.out.println("Enter the name you want to update: ");
				//Scanner scan6 = new Scanner("System.in");
				name = scan.nextLine();
				System.out.println("Enter the new phone number: ");
				//Scanner scan7 = new Scanner("System.in");
				number = scan.nextLine();
				p.ChangeEntry(name, number);
			} 
			System.out.println("You want to continue (y/n): ");
			//Scanner scan8 = new Scanner("System.in");
			response = scan.nextLine();
		} while(!response.equals("n"));
		
		p.storeIt("src/phone.properties");
		p.printStates();
		
//		PhoneDirectory newP = new PhoneDirectory();
//		newP.populateFromFile("phone.properties");
//		newP.printStates();
//		System.out.println("Done!!");
		//output.close();
	}
}