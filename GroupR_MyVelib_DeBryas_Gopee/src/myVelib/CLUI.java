package myVelib;

import java.util.Scanner;

public class CLUI {
	
	public static void main(String[] args) {
		
		while(true) {
			
			Scanner scan = new Scanner(System.in);
			LineToFunction lineToFunction = new LineToFunction();

			
			String s = scan.next();
			
			if(s=="EXIT")break;
			
			//int i = scan.nextInt();
					
			try {
				lineToFunction.Execute(s);
			} catch (Exception e) {
				System.out.println("didn't arrived to execute the line to function transformation");
				e.printStackTrace();
			}
			
		}
		
	}	
	
	
}
