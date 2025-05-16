public class Polynomial {
	double [] coeff;
	
	public Polynomial() {
		coeff = new double[0];
	}
	
	public Polynomial (double[] arr) {
		
		coeff = new double[arr.length];
		
		
		for(int i=0; i<arr.length; i++) {
			
			coeff[i]=arr[i];
		}
		
	}
	
	
	public Polynomial add(Polynomial x) {
		
		int c = x.coeff.length - this.coeff.length;
		int len=0;
		double [] res;
		
		if(c<=0) {
			
			len= this.coeff.length;
			res=new double[len];
			
			for(int i=0; i<this.coeff.length; i++) {
				
				res[i]=this.coeff[i];
				
				if(i<x.coeff.length) {
					res[i]+=x.coeff[i];
					
				}
				
				
			}
			
		}else {
			len= x.coeff.length;
			res= new double[len];
			for(int i=0; i<x.coeff.length; i++) {
				
				res[i]=x.coeff[i];
				
				if(i<this.coeff.length) {
					res[i]+=this.coeff[i];
					
				}
				
				
			}
		}
		
		return new Polynomial(res);
		
			
	}
	
	public double evaluate(double x) {
		 
		if(this.coeff.length==0) {
			return 0;
		}else {
		
		double res=this.coeff[0];
		
		for(int i =1; i < this.coeff.length; i++) {
			
			double curr=0;
			curr =x;
			
			for(int j=2; j<=i; j++) {
				curr=curr*x;
			}
			
			res= (curr*this.coeff[i]) +res;
			
		}
		
		return res;
		}
		
		
		
	}
	
	public boolean hasRoot (double root) {
		double check= evaluate(root);
		if(check==0) {
			return true;
			
		}
		
		return false;
	}
}