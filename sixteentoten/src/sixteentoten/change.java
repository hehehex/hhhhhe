package sixteentoten;

import java.util.Scanner;

public class change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("input a hex:");
		String s = input.next();
		try {
			System.out.println(Integer.parseInt(s,16));
		}
		catch(Exception ex){
			System.out.println("not a hex");
		}
	}
}
