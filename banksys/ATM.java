package Account;

import java.util.Scanner;

public class ATM {
	static String un;
	static String nm;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("欢迎使用");
		display();
	}
//输出函数
	public static void display() {
		System.out.println("1.开户     2.查询余额    3.存款   4.取款   5.查询利息");
		Scanner s = new Scanner(System.in);
	    int chooses = s.nextInt();
		DepositAccount a = new DepositAccount(un, nm);
		switch(chooses) {
		case 1: a.create(); break;
		case 2: a.find(); break;
		case 3: a.add(); break;
		case 4: a.sub(); break;
		case 5: a.cal(); break;
		}
	}
}
	
class DepositAccount {
	
		private String username;   //用户名
		private String name;    //姓名
		private static double account;    //账户余额
		static double yeararte = 0.023;   //年利率
//初始化函数
		public DepositAccount(String un,String nm) {
			username = un;
			name = nm;
		}
//初始化函数
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
		    	ATM.display();
		    }
		    else if(choose == 2)
		    {
		    	System.out.println("谢谢使用，再见！");
		    }
		}
//查询余额
		public void find() {
			System.out.println("请输入您的账户：");
			Scanner s = new Scanner(System.in);
			String un = s.nextLine();
			System.out.println("您当前余额为："+account);
			ATM.display();
		}
//存款
		public void add() {
			System.out.println("请输入您的账户：");
			Scanner s = new Scanner(System.in);
			String un = s.nextLine();
			System.out.println("请输入存入金额：");
			double money = s.nextInt();
		    account += money;
			System.out.println("存入成功！");
			System.out.println("您当前余额为："+account);
			ATM.display();
		}
//取款
		public void sub() {
			System.out.println("请输入您的账户：");
			Scanner s = new Scanner(System.in);
			String un = s.nextLine();
			System.out.println("请输入取出金额：");
			double money = s.nextInt();
			account -= money;
			System.out.println("取款成功！");
			System.out.println("您当前余额为："+account);
			ATM.display();
		}
//计算利息
		public void cal() {
			double annualyield;
			double monthlyield;
			annualyield = DepositAccount.account * yeararte;  //计算年利息
			monthlyield = annualyield/12;   //计算月利息
			System.out.println("您的年利息为："+annualyield);
			System.out.println("您的年月息为："+monthlyield);
			ATM.display();
		}
}
