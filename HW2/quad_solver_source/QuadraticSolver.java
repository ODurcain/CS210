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
  
    String result = null;
    
    // Write your code to build the correct return String here
    
    return result;
  }
}
