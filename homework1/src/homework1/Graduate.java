package homework1;

public class Graduate implements StudentManage,TeacherManage{
	String name;
	String sex;
	int age;
	double fee;
	double pay;
	Graduate(String n,String s,int a){
		this.name = n;
		this.sex = s;
		this.age = a;
	}
	public void setFee(double f) {
		fee = f;
	}
	public double getFee() {
		return fee;
	}
	public void setPay(double p) {
		pay = p;
	}
	public double getPay() {
		return pay;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graduate g1 = new Graduate("zhangsan","ÄÐ",23);
		g1.setFee(5000);
		g1.setPay(1000);
		if((g1.getPay()*12-g1.getFee())<2000) {
			System.out.println("Provide a loan");
		}
		else {
			System.out.println("Enough");
		}
	}

}
