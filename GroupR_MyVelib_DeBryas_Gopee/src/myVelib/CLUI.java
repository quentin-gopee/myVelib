package myVelib;

import java.util.Scanner;

public class CLUI {
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("Enter a command:");
			
			Scanner scan = new Scanner(System.in);
			LineToFunction lineToFunction = new LineToFunction();

			
			String s = scan.nextLine();
			System.out.println(s);
			
			if(s=="EXIT") {
				System.out.println("exit with success");
				break;
			}
			
			//int i = scan.nextInt();
					
			try {
				lineToFunction.Execute(s);
				System.out.println("ok");
			} catch (Exception e) {
				System.out.println("didn't arrived to execute the line to function transformation");
				e.printStackTrace();
			}
			
		}
		
	}	
	
	
}
