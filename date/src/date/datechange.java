package date;

import java.util.*;
import java.text.*;

public class datechange {
	
	static Date t;
	static int flag = 1;
	
	static void change() {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		try {
			t = ft.parse(input);
		}
		catch(ParseException e) {
			flag = 0;
			System.out.println("Unparseable using" + ft);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub$
		System.out.print("input date:");
		datechange d = new datechange();
		d.change();
		if(flag == 1) {
			System.out.println(t);
		}
		else if(flag == 0){
			System.out.println("wrong input");
		}
	}
}
