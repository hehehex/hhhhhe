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
		System.out.println("��������Ϊ��"+ un);
		System.out.println("�����û���Ϊ��"+ nm);
	}
	public void create() {
		Scanner s = new Scanner(System.in);
		System.out.println("������������ʵ������");
		String un = s.nextLine();
		System.out.println("�������û���:");
		String nm = s.nextLine();
	    System.out.println("�����ɹ����Ƿ񷵻���ҳ��");
	    System.out.println("1.YES  2.NO");
	    int choose = s.nextInt();
	    if(choose == 1) {
	    }
	    else if(choose == 2)
	    {
	    	System.out.println("ллʹ�ã��ټ���");
	    }
	}
	public void find() {
		System.out.println("�����������˻���");
		Scanner s = new Scanner(System.in);
		String un = s.nextLine();
		System.out.println("����ǰ���Ϊ��"+account);
	}
	public void add() {
		System.out.println("�����������˻���");
		Scanner s = new Scanner(System.in);
		String un = s.nextLine();
		System.out.println("����������");
		double money = s.nextInt();
	    account += money;
		System.out.println("����ɹ���");
		System.out.println("����ǰ���Ϊ��"+account);
	}
	public void sub() {
		System.out.println("�����������˻���");
		Scanner s = new Scanner(System.in);
		String un = s.nextLine();
		System.out.println("������ȡ����");
		double money = s.nextInt();
		account -= money;
		System.out.println("ȡ��ɹ���");
		System.out.println("����ǰ���Ϊ��"+account);
	}
	public void cal() {
		double annualyield;
		double monthlyield;
		annualyield = account * yeararte;
		monthlyield = annualyield/12;
		System.out.println("����ǰ���Ϊ��"+account);
		System.out.println("��������ϢΪ��"+annualyield);
		System.out.println("��������ϢΪ��"+monthlyield);
	}
	
}
