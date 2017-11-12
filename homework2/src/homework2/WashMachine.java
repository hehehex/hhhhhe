package homework2;

public class WashMachine implements ComputeWeight{
	  double wweight;  
	  WashMachine(double w){
		  this.wweight=w;
		  }  
	  public double ComputeWeight(){
		  return wweight;  
		  }
}
