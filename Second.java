
public class Second {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			Student s = new Student("hexue",20,"");
			s.show();
			Undergraduate u = new Undergraduate("Computer");
			u.show();
			Graduate g = new Graduate("I don't know");
			g.show();

	}

}

class Student {
	
    String name;
	int age;
	String education;
	
	public Student(String n,int a,String e) {
		name = n;
		age = a;
		education = e;
	}
	public void show() {
		System.out.println("neme:" + name);
		System.out.println("age:" + age);
		System.out.println("education:" + education);
	}

	
}
class Undergraduate extends Student{
	private String specialty;
	
	public Undergraduate(String s) {
		super("",0,"Undergraduate");
		specialty = s;
	}
	public void show() {
		System.out.println("specialty:" + specialty);
	}
	
}
class Graduate extends Student{
	private String direction;
	public Graduate(String d) {
		super("",0,"Graduate");
		direction = d;
	}
	public void show() {
		System.out.println("direction:" + direction);
	}
}

