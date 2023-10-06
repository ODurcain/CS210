/**
 * CS210 Project 1 class PolynomialApp
 * Edited by Chris Kelly for Fall 2017 
 * 
 * @author Bob Wilson
 * @version July 6, 2009
 * 
 */

import java.util.Arrays;

public class PolynomialApp
{
  public static void main(String [] args)
  {
    // Change the 5 to another number (> 5)
    Polynomial [] polynomials = new Polynomial[5];
    
    // 1. Choose different sets of coefficients, 
    //    other than those provided below
    // 2. Add *more* lines to the below, as needed
    polynomials[0] = new Polynomial(2, 2, 2, 2);  
    polynomials[1] = new Polynomial(2, 2, 2);  
    polynomials[2] = new Polynomial(2, 2, 1);  
    polynomials[3] = new Polynomial(2, 1, 2); 
    polynomials[4] = new Polynomial(1, 2, 2);
    
    
    
    
    System.out.println("Before sorting:");
    // Loop through the array polynomials, printing
    // each on a separate line:
    for (Polynomial p : polynomials) {
      System.out.println(p.toString());
    }
    Arrays.sort(polynomials);
    
    
    
    
    
    // Use the Arrays.sort method to sort the 
    //    array polynomials
    // Polynomial [] will be widened to 
    //    Comparable<Polynomial> []
    
    
    
    
    
    System.out.println("\nAfter sorting:");
    // Loop through the array polynomials, printing
    // each on a separate line:
    for (Polynomial p : polynomials) {
      System.out.println(p.toString());
    }
    
    
    
    
    System.out.println("\nDerivatives:");
    // Loop through the array polynomials, printing
    // the derivative of each polynomial on a 
    // separate line:
    for (Polynomial p : polynomials) {
      System.out.println(p.derivative().toString());
    }
    
    
    
    
  }
}