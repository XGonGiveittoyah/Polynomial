public class PolynomialTest {

  public static void main(String[] args) {
    Polynomial a = new Polynomial(5.0);
    a.assign_coef(4.0, 1);
    a.assign_coef(3.0, 2);
    a.assign_coef(9.1, 3);
    System.out.println(a.toString());
    
    Polynomial b = new Polynomial(a);
    b.add_to_coef(10.0, 2);
    b.add_to_coef(2.0, 5);
    System.out.println(b.toString());
    System.out.println(b.coefficient(3));
    System.out.println(b.eval(4.0));                   
    
    Polynomial c = a.add(b);
    System.out.println(c.toString());
    
    Polynomial d = a.multiply(b);
    System.out.println(d.toString());
  }
}