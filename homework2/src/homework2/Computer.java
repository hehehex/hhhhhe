package homework2;

public class Computer implements ComputeWeight{
	double cweight;  
    Computer(double c){  
        this.cweight = c;  
    }  
	public double ComputeWeight() {
		return cweight;
	}
}
