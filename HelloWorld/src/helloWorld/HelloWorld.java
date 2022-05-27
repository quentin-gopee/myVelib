package helloWorld;
import java.util.Scanner;
import java.util.Random;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name:");
		String userName = scan.nextLine();
		System.out.println("User Name:" + userName);
		System.out.println(Math.PI);
		System.out.println("Enter an integer:");
		int n = scan.nextInt();
		int r = new Random().nextInt(n+1);
		System.out.println(r);
		scan.close();
	}

}
