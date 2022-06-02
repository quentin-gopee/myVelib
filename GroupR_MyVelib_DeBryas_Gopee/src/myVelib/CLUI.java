package myVelib;

import java.util.Scanner;

public class CLUI {
	
	public static void main(String[] args) {
		LineToFunction lineToFunction = new LineToFunction();
		while(true) {
			System.out.println("Enter a command:");
			
			Scanner scan = new Scanner(System.in);
			
			
			String s = scan.nextLine();
			
			if(s.equals("EXIT")) {
				break;
			}
					
			try {
				lineToFunction.Execute(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("exit with success");
		
	}	
	
	
}
