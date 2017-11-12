package homework2;

public class Television implements ComputeWeight{
	double tweight;  
    Television(double t){  
        this.tweight = t;  
    }  
	public double ComputeWeight() {
		return tweight;
	}
}
