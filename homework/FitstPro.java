import java.util.*;

public class FitstPro {
	private static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("输入一个整数:");
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		add(n);
	}
	public static int add(int x) {
		System.out.println(x);
		if(x<5000) {
			add(2*x);
		}
		else{
			sub(x);
	}
		return x;
	}
	public static int sub(int x) {
		System.out.println(x);
		if(x>n) {
			sub(x/2);
		}
		return x;
	}
}