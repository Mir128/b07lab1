import java.io.BufferedReader;
import java.io.FileReader;

public class Polynomial {
	double [] coefficients;
	int [] exponents;
	
	public Polynomial() {
		coefficients = new double[]{-1,1}; 
		exponents = new int[]{0,0};
	}
	
	
	public Polynomial (double[] arr1, int[] arr2) {
		int len=arr1.length;
		
		for(int i=0; i<arr1.length; i++) {
			
			if(arr1[i]==0) {
				len=len-1;
				
			}
			
		}
		
		coefficients = new double[len];
		exponents = new int[len];
		
		int w=0;
		for(int i=0; i<arr1.length; i++) {
			
			if(arr1[i]!=0) {
			coefficients[w]=arr1[i];
			exponents[w]=arr2[i];
			w++;
			}
		}
		
	}
	
	/*
	public Polynomial(File file) {
		
		
		
		
		
	}*/
	
	public void saveToFile(String name) {
		
		String t="";
		
		for(int i=0; i<coefficients.length; i++) {
			
			if(exponents[i]==0) {
				
				if(coefficients[i]>0) {
					if(i>0) {
					t = t+ "+"+ coefficients[i];
					}else {
						t = t+ coefficients[i];
					}
				}else {
					t = t+  coefficients[i];
				}
			}else {
				
				if(coefficients[i]>0) {
					if(i>0) {
					t = t+ "+"+ coefficients[i] + "x" + exponents[i];
					}else {
						t = t+  coefficients[i] + "x" + exponents[i];
					}
				}else {
					t = t+ coefficients[i] + "x" + exponents[i];
				}
				
				
				
			}
		}
		
		FileWriter output = new FileWriter(name, false);        
		output.write(t);
		
	}
	
	public int unique(int [] arr) {
		int c=arr.length;
		int [] copy = new int[c];
		
		for(int i=0; i<c; i++) {
			
			copy[i] = arr[i];
			
		}
		
		
		for(int i =0; i<arr.length; i++) {
			
			for(int j=i+1; j<arr.length; j++) {
				
				if(copy[i]==arr[j] && copy[i]!=-1) {
					c=c-1;
					copy[j]=-1;
				}
			}
		}
		
		return c;
	}
	
	public void multiply(Polynomial x) {
		int len = x.coefficients.length * this.coefficients.length;
		double [] c1= new double[len];
		int [] e1 = new int[len];
		
		int c = x.coefficients.length - this.coefficients.length;

		
			
			
			int w=0;
			
			for(int i=0; i<x.coefficients.length; i++) {
				
				for(int j=0; j<this.coefficients.length; j++) {
					c1[w] = x.coefficients[i]*this.coefficients[j];
					e1[w] = x.exponents[i]+this.exponents[j];
					w++;
				}
				
			}
			
			
			
			
			int newlen = unique(e1);
			
			double [] newCoeff = new double[newlen];
			double [] newExp = new double[newlen];
			int q=0;
			
			for(int i =0; i<e1.length; i++) {
				
				for(int j=i+1; j<e1.length; j++) {
					
					if(e1[i]==e1[j] && c1[i]!=0) {
						c1[i] += c1[j];
						
						c1[j]=0;
						
					}
				}
				
				
			}
			
			for(int i=0; i<e1.length; i++) {
				
				if(c1[i]!=0) {
					newCoeff[q] = c1[i];
					newExp[q] = e1[i];
					q++;
					
					
				}
				
			}
			
			
			
		
	}
	
	public Polynomial add(Polynomial x) {
		
		int c = x.coefficients.length - this.coefficients.length;
		int len=0;
		double [] res;
		
		if(c<=0) {
			
			len= this.coefficients.length;
			res=new double[len];
			
			for(int i=0; i<this.coefficients.length; i++) {
				
				res[i]=this.coefficients[i];
				
				
				
				if(i<x.coefficients.length) {
					
					for(int j=0; j<x.exponents.length; j++) {
						
						if(this.exponents[i]==x.exponents[j]) {
							res[i]+=x.coefficients[j];
							
							
							
						}
					}
					
				}
				
				
			}
			
			return new Polynomial(res, this.exponents);
			
		}else {
			len= x.coefficients.length;
			res= new double[len];
			for(int i=0; i<x.coefficients.length; i++) {
				
				res[i]=x.coefficients[i];
				
				
				if(i<this.coefficients.length) {
					
					for(int j=0; j<this.exponents.length; j++) {
						
						if(x.exponents[i]==this.exponents[j]) {
							
							res[i]+=this.coefficients[j];

							
						}
					}
					
				}
				
				
			}
			
			return new Polynomial(res, x.exponents);
		}
		
		
		
			
	}
	
	public double evaluate(double x) {
		 
		if(this.coefficients.length==0) {
			return 0;
		}else {
		
		double res=0;
		
		for(int i =0; i < this.coefficients.length; i++) {
			
			double curr=0;
			curr =x;
			
			for(int j=1; j<this.exponents[i]; j++) {
				curr=curr*x;
			}
			
			if(this.exponents[i]==0) {
				curr=1;
			}
			
			res+=(curr*this.coefficients[i]);
			
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