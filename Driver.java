public class Driver {
public static void main(String [] args) {

double [] c1 = {1,2,3};   
int [] e1 = {1,2,3};
double [] c2= {1,4,-1};
int [] e2 = {3,1,0};


Polynomial p1 = new Polynomial(c1,e1);
Polynomial p2 = new Polynomial(c2,e2);

p1.multiply(p2);









}
}