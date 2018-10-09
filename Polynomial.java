/*
*@author Xavier Madera
**/

public class Polynomial {

    private double[] coeffs;

    /**
     * creates a new Polynomial and initializes coeffs to a new double array with length 0
     * 
     * no parameters
     * 
     * */
    public Polynomial() {
        this.coeffs = new double[0];
    }
    /**
     * creates a new Polynomial and initializes coeffs to a new double array with length 1, and
     * initializes the only element to the double parameter
     * 
     * @param a0 the initial array element value
     * 
     * */
    public Polynomial(double a0) {
        this.coeffs = new double[1];
        this.coeffs[0] = a0; 
    }

    /**
     * creates a Polynomial which is a copy of the parameter Polynomial
     * 
     * @param p the Polynomial which is being copied
     * 
     * */
    public Polynomial(Polynomial p) {
        this.coeffs = new double[p.coeffs.length];
        for (int i = 0; i < coeffs.length; i++) {
          this.coeffs[i] = p.coeffs[i];
        }
    }

    /**
     * adds the parameter amount to the specified parameter exponent in the calling object
     * 
     * @param amount the amount which is being added
     * @param exponent the element in the coeffs array which is being modified
     * 
     * */
    public void add_to_coef(double amount, int exponent) {
      if (exponent + 1 > this.coeffs.length) {
        double[] newArr = new double[exponent + 1];
        for (int i = 0; i < this.coeffs.length; i++) {
          newArr[i] = this.coeffs[i];
        }
        newArr[exponent] = amount;
        this.coeffs = newArr;
      }
      else {
        this.coeffs[exponent] = this.coeffs[exponent] + amount;
      }
    }

    /**
     * assigns the parameter amount to the specified parameter exponent in the calling object
     * 
     * @param amount the amount which is being assigned
     * @param exponent the element in the coeffs array which is being modified
     * 
     * */
    public void assign_coef(double amount, int exponent) {
      if (exponent + 1 > this.coeffs.length) {
        double[] newArr = new double[exponent + 1];
        for (int i = 0; i < this.coeffs.length; i++) {
          newArr[i] = this.coeffs[i];
        }
        newArr[exponent] = amount;
        this.coeffs = newArr;
      }
      else {
        this.coeffs[exponent] = amount;
      }
    }

    /**
     * returns the coefficient at the parameter exponent
     * 
     * @param exponent the element in the coeffs array which is being returned
     * 
     * @return double
     * 
     * */
    public double coefficient(int exponent) {
      double result = 0.0;
      if (exponent + 1 > this.coeffs.length) { result = 0.0; }
      else {
        result = this.coeffs[exponent];
      }
      return result;
    }
    
    /**
     * evaluates the Polynomial with a given double x
     * 
     * @param x the value for which the Polynomial is being evaluated with
     * 
     * @return double
     * 
     * */
    public double eval(double x) {
      double result = 0.0;
      for (int i = 0; i < this.coeffs.length; i++) {
        if (i == 0) { result += this.coeffs[0]; }
        else if (i == 1) { result += this.coeffs[1] * x; }
        else {
          x *= x;
          result += this.coeffs[i] * x;
        }
      }
      return result;
    }

    /**
     * visualizes the called object in the form of a string
     * 
     * no parameters
     * 
     * @return String
     * 
     * */
    public String toString() {
      String result = "";
      for (int i = this.coeffs.length - 1; i >= 0; i--) {
        if (i == 0) {
          if (this.coeffs[i] == 0.0) {
            result += "";
          }
          else {
            result += this.coeffs[i];
          }
        }
        else if (i == 1) {
          if (this.coeffs[i] == 0.0) {
            result += "";
          }
          else {
            result += this.coeffs[i] + "x + ";
          }
        }
        else { 
          if (this.coeffs[i] == 0.0) {
            result += "";
          }
          else {
            result += this.coeffs[i] + "x^" + i + " + ";
          }
        }
      }
      return result;
    }

    /**
     * creates and returns a new Polynomial which is the sum of the called
     * Polynomial and the parameter Polynomial
     * 
     * @param p a reference to the Polynomial that is being added to the calling 
     * object
     * 
     * @return Polynomial
     * 
     * */
    public Polynomial add(Polynomial p) {
      double[] shorter;
      double[] longer;
      if (this.coeffs.length < p.coeffs.length) { shorter = this.coeffs; longer = p.coeffs; }
      else { shorter = p.coeffs; longer = this.coeffs; }
      Polynomial newP = new Polynomial();
      newP.coeffs = new double[longer.length];
      for (int i = 0; i < longer.length; i++) {
        newP.coeffs[i] = longer[i];
      }
      for (int i = 0; i < shorter.length; i++) {
        newP.coeffs[i] += shorter[i];
      }
      return newP;
    }
    
    /**
     * creates and returns a new Polynomial which is the product of the called
     * Polynomial and the parameter Polynomial
     * 
     * @param p a reference to the Polynomial that is being multiplied by the
     * calling object
     * 
     * @return Polynomial
     * 
     * */
    public Polynomial multiply(Polynomial p) {
      Polynomial newP = new Polynomial();
      newP.coeffs = new double[this.coeffs.length + p.coeffs.length];
      
      if (this.coeffs.length > p.coeffs.length) {
        p.assign_coef(0.0, this.coeffs.length - 1);
      }
      else if (p.coeffs.length > this.coeffs.length) {
        this.assign_coef(0.0, p.coeffs.length - 1);
      }
      
      for(int i = this.coeffs.length - 1; i >= 0; i--) {
        for (int j = p.coeffs.length - 1; j >= 0; j--) {
          newP.add_to_coef(this.coeffs[i] * p.coeffs[j], i + j);
        }
      }
      return newP;
    }

}