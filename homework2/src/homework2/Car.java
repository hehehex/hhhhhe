package homework2;

public class Car {
	ComputeWeight[] cargo;
	double cargocount = 0;
	Car (ComputeWeight[] cargo)  
    {  
    this.cargo = cargo;  
    }  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ComputeWeight[] cargo = new ComputeWeight[3];
	     cargo[0]=new Television(100); //上转型对象  
	     cargo[1]=new Computer(200);  
	     cargo[2]=new WashMachine(300);  
	     Car car=new Car(cargo);  
	     double cargocount;  
	     cargocount=cargo[0].ComputeWeight()+cargo[1].ComputeWeight()+cargo[2].ComputeWeight();  
	     System.out.println("所装载的货物的总重量为:"+cargocount);  
	}

}
