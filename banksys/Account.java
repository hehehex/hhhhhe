package ceshi;

import java.util.Scanner;

class Account {

	private String username;
	private String name;
	private double account = 5000;
	static double yeararte = 0.023;
	public static void main(String[] args) {
		Account saver = new Account("Zhangsan","1234567890");
		saver.cal();
	   }
	
	public Account(String un,String nm) {
		username = un;
		name = nm;
		System.out.println("您的姓名为："+ un);
		System.out.println("您的用户名为："+ nm);
	}
	public void create() {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入您的真实姓名：");
		String un = s.nextLine();
		System.out.println("请输入用户名:");
		String nm = s.nextLine();
	    System.out.println("开户成功！是否返回首页？");
	    System.out.println("1.YES  2.NO");
	    int choose = s.nextInt();
	    if(choose == 1) {
	    }
	    else if(choose == 2)
	    {
	    	System.out.println("谢谢使用，再见！");
	    }
	}
	public void find() {
		System.out.println("请输入您的账户：");
		Scanner s = new Scanner(System.in);
		String un = s.nextLine();
		System.out.println("您当前余额为："+account);
	}
	public void add() {
		System.out.println("请输入您的账户：");
		Scanner s = new Scanner(System.in);
		String un = s.nextLine();
		System.out.println("请输入存入金额：");
		double money = s.nextInt();
	    account += money;
		System.out.println("存入成功！");
		System.out.println("您当前余额为："+account);
	}
	public void sub() {
		System.out.println("请输入您的账户：");
		Scanner s = new Scanner(System.in);
		String un = s.nextLine();
		System.out.println("请输入取出金额：");
		double money = s.nextInt();
		account -= money;
		System.out.println("取款成功！");
		System.out.println("您当前余额为："+account);
	}
	public void cal() {
		double annualyield;
		double monthlyield;
		annualyield = account * yeararte;
		monthlyield = annualyield/12;
		System.out.println("您当前余额为："+account);
		System.out.println("您的年利息为："+annualyield);
		System.out.println("您的年月息为："+monthlyield);
	}
	
}
