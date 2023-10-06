/*
 * @(#)Solver.java 1.0
 *
 *
 * Quadratic equation solver class
 * Bob Wilson
 * 12/29/2015
 *
 */

public class QuadraticSolver 
{ 
  private int a, b, c;            // coefficients of quadratic equation
  
  public QuadraticSolver(int a, int b, int c)
  {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public String getEquation()
  {

    return ("Solving: " + a + "x\u00b2 " + ( (b >= 0) ? "+ " : "") +
            b + "x " + ( (c >= 0) ? "+ " : "") + c + " = 0");
  }

  public String getSolution() 
  {
    String result = null; //initializes the string
    //String result; I learned I need to use stringbuffer to allow for a mutable string
    double r1, r2; //initialize the roots
    double disc = b * b - 4 * a * c; // initialize the discriminant. I know that the assignment recommends an int instead of a double, but this didn't cause me problems
    double q=Math.sqrt(Math.abs(disc)); //this is solely used for complex numbers
    
    if (disc > 0){
    
      r1 = (-b + Math.sqrt(disc))/2 * a;
      r2 = (-b - Math.sqrt(disc))/2 * a;
      result = String.format("The roots of the equation are real and different. \nRoot 1 is %.16f\nRoot 2 is %.16f", r1, r2); //output of roots if disc>0
      
    }
    
    else if (disc == 0){
      if(a==0){
        
      }
      double root = -b/(2.0*a);
      result = String.format("The roots of the equation are real and equal. \nThe only root is %.16f", root);  
      //result = System.out.println(-(double)b/(2*a)); This was me not understanding Java yet
    }
    else if (disc < 0){
      
      double real = -b/(2.0*a); // this is the real part of the number
      double imag = q/(2.0*a); // this is the imaginary part of the number
      result = String.format("The roots of the equation are complex and different. \nRoot 1 is %.16f + i %.16f\nRoot 2 is %.16f - i %.16f", real, imag, real, imag);
    }
   
    //this nested if loop is for the cases of variable a being equal to 0, and variable b & c being 0, or not 0. Essentially covering all bases for a being 0
    if(a==0){ // for a is equal zero
      if (b==0){ // for a & b equal zero
        if (c==0){ // for a, b, & c equal zero
          result = String.format("Any value for x is a solution");
        }
        else{ // for a & b equal zero, bbut c is not equal zero
          result = String.format("No value for x is a solution");
        }
       }
      else{ // for a equal zero, but b not equal zero 
        double root = -c / (double) b;
        result = String.format("The only root is %.16f", root);
      }
    }
    return result;
  }  
}