package Account;

import java.util.Scanner;

public class ATM {
	static String un;
	static String nm;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("��ӭʹ��");
		display();
	}
//�������
	public static void display() {
		System.out.println("1.����     2.��ѯ���    3.���   4.ȡ��   5.��ѯ��Ϣ");
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
	
		private String username;   //�û���
		private String name;    //����
		private static double account;    //�˻����
		static double yeararte = 0.023;   //������
//��ʼ������
		public DepositAccount(String un,String nm) {
			username = un;
			name = nm;
		}
//��ʼ������
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
		    	ATM.display();
		    }
		    else if(choose == 2)
		    {
		    	System.out.println("ллʹ�ã��ټ���");
		    }
		}
//��ѯ���
		public void find() {
			System.out.println("�����������˻���");
			Scanner s = new Scanner(System.in);
			String un = s.nextLine();
			System.out.println("����ǰ���Ϊ��"+account);
			ATM.display();
		}
//���
		public void add() {
			System.out.println("�����������˻���");
			Scanner s = new Scanner(System.in);
			String un = s.nextLine();
			System.out.println("����������");
			double money = s.nextInt();
		    account += money;
			System.out.println("����ɹ���");
			System.out.println("����ǰ���Ϊ��"+account);
			ATM.display();
		}
//ȡ��
		public void sub() {
			System.out.println("�����������˻���");
			Scanner s = new Scanner(System.in);
			String un = s.nextLine();
			System.out.println("������ȡ����");
			double money = s.nextInt();
			account -= money;
			System.out.println("ȡ��ɹ���");
			System.out.println("����ǰ���Ϊ��"+account);
			ATM.display();
		}
//������Ϣ
		public void cal() {
			double annualyield;
			double monthlyield;
			annualyield = DepositAccount.account * yeararte;  //��������Ϣ
			monthlyield = annualyield/12;   //��������Ϣ
			System.out.println("��������ϢΪ��"+annualyield);
			System.out.println("��������ϢΪ��"+monthlyield);
			ATM.display();
		}
}
