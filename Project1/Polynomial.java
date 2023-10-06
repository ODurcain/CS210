/**
 * CS210 Project 1 class PolynomialApp
 * 
 * @author Owen Durkin
 * @version July 1, 2023
 * 
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class Polynomial implements Comparable<Polynomial> {
  private List<Integer> coefficients;
  
    /**
   * This compareTo is vital for passing the array of polynomial objects to the Comparable interface above
   */
  
  @Override
  public int compareTo(Polynomial other) {
    if (this.coefficients.size() > other.coefficients.size()) { // degree comparison
      return 1;
    } else if (this.coefficients.size() < other.coefficients.size()) {
      return -1;
    }
    
    for (int i = this.coefficients.size() - 1; i >= 0; i--) { // if degrees are equal, then begin comparing coefficients starting at the highest power
      if (this.coefficients.get(i) > other.coefficients.get(i)) {
        return 1;
      } else if (this.coefficients.get(i) < other.coefficients.get(i)) {
        return -1;
      }
    }
    
    return 0; // for all coefficients being equal
  }
  
  /**
   * The polynomial constructor
   * @param Polynomial, coeff, coefficients, ArrayList
   */
  
  public Polynomial(int... coefficients) { // sets up variable size Polynomial
    this.coefficients = new ArrayList<>();
    for (int coeff : coefficients) {
      this.coefficients.add(coeff);
    }
    
    while (!this.coefficients.isEmpty() && this.coefficients.get(this.coefficients.size() - 1) == 0) {
      this.coefficients.remove(this.coefficients.size() - 1);
    }
  }
  
  /**
   * helper for checking coefficients = 0
   * @param coeff, coefficients
   * @return isZero
   */
  
  public boolean isZero() {
    for (int coeff : this.coefficients) {
      if (coeff != 0)
        return false;
    }
    return true;
  }
  
  /**
   * another helper function for root and general tests
   * @param i, x, coefficients
   * @return result
   */
  
  public double evaluate(double x) {
    double result = 0;
    for (int i = 0; i < coefficients.size(); i++) {
      result += coefficients.get(i) * Math.pow(x, i);
    }
    return result;
  }
  
  /**
   * 
   */ 
  
  @Override
  public String toString() {
    if (isZero()) {
      return ""; // zero polynomial case
    }
    String s = "";
    for (int i = coefficients.size() - 1; i >= 0; i--) {
      int coeff = coefficients.get(i);
      if (coeff == 0 && i == 0 && !s.isEmpty())
        continue; // Skip constant 0
      if (!s.isEmpty() && coeff >= 0)
        s += " + ";
      else if (!s.isEmpty() && coeff < 0) {
        s += " - ";
        coeff = -coeff;
      }
      s += coeff;
      if (i == 1)
        s += "x^1";
      else if (i > 1)
        s += "x^" + i;
      else if (i == 0)
        s += "x^0";
    }
    return s;
  }
  
  public boolean equals(Object otherObject) {
    if (otherObject instanceof Polynomial) { // checks if otherObject is a polynomial
      Polynomial otherPolynomial = (Polynomial) otherObject; // if yes, change from Object to Polynomial
      
      if (this.compareTo(otherPolynomial) == 0) { // checks if the Polynomials are the same
        return true; // true if they are the same
      }
    }
    
    return false; // if not a polynomial, or do not match
  }
  
  /**
   * returns the sum of the two polynoials
   * @param i, coefficients, sum, result
   * @return Polynomial(resultArray)
   */
  
  public Polynomial plus(Polynomial that) {
    List<Integer> result = new ArrayList<>(); // create list to store result of summation
    int i = 0;
    
    while (i < this.coefficients.size() || i < that.coefficients.size()) { // loop for iterating through coefficients
      int sum = 0; // sets sum to 0 for each iteration
      
      if (i < this.coefficients.size()) { // checks this polynomial for coefficientat current index
        sum += this.coefficients.get(i);
      }
      
      if (i < that.coefficients.size()) { // checks that polynomial for coefficient at current index
        sum += that.coefficients.get(i);
      }
      
      result.add(sum); // add sum at current index to result list and move on to next index
      i++;
    }
    
    int[] resultArray = new int[result.size()]; // takes results and makes them into a new polynomial
    for (int j = 0; j < result.size(); j++) {
      resultArray[j] = result.get(j);
    }
    
    return new Polynomial(resultArray); // new Polynomial from summation of this and that
  }
  
  /**
   * returns the difference of two polynomials. this is identical to addition except 
   * when checking for coefficient at current index for that polynomial it subtracts.
   * It also needs to check to see if all coefficients have become 0 from subtraction
   * @param i, coefficients, difference, result, allZero
   * @return Polynomial(resultArray)
   */
  
  public Polynomial minus(Polynomial that) {
    List<Integer> result = new ArrayList<>();
    
    int i = 0;
    while (i < this.coefficients.size() || i < that.coefficients.size()) {
      int difference = 0;
      
      if (i < this.coefficients.size()) {
        difference += this.coefficients.get(i);
      }
      
      if (i < that.coefficients.size()) { // this is the only difference from the addition class 
        difference -= that.coefficients.get(i);
      }
      
      result.add(difference);
      i++;
    }
    
    boolean allZero = true; // checks if coefficients are all zero after subtraction
    for (int coeff : result) {
      if (coeff != 0) {
        allZero = false;
        break;
      }
    }
    if (allZero) {
      return new Polynomial(); // Return a zero polynomial with no coefficients.
    }
    
    int[] resultArray = new int[result.size()];
    for (int j = 0; j < result.size(); j++) {
      resultArray[j] = result.get(j);
    }
    
    return new Polynomial(resultArray);
  }
  
  /**
   * returns the product of two polynomials
   * @param i, coefficients, result, newSize, productCoeffs, allZero, coeff
   * @return Polynomial(productCoeff)
   */
  
  public Polynomial multiply(Polynomial that) {
    int newSize = this.coefficients.size() + that.coefficients.size() - 1; // adjusts array size for higher degrees from multiplication. sum of degrees of multiplicands
    int[] productCoeffs = new int[newSize]; //initializes said array
    
    for (int i = 0; i < this.coefficients.size(); i++) {
      for (int j = 0; j < that.coefficients.size(); j++) {
        productCoeffs[i + j] += this.coefficients.get(i) * that.coefficients.get(j); // gets product of this and that at each iteration
      }
    }
    
    boolean allZero = true; // make sure all the coefficients aren't zero
    for (int coeff : productCoeffs) {
      if (coeff != 0) {
        allZero = false;
        break;
      }
    }
    if (allZero) {
      return null;
    }
    
    return new Polynomial(productCoeffs); // new polynomial of the product
  }
  
  /**
   * returns quotient of two polynomials
   * @param dividend, quotient, divisorCoefficients, i, quotientArray, remainderArray
   * @return Polynomial[]
   * 
   */
  
  public Polynomial[] divide(Polynomial divisor) {
    if (divisor.equals(new Polynomial(0))) {
      throw new ArithmeticException("Cannot divide by zero polynomial");
    }
    
    List<Integer> dividend = new ArrayList<>(this.coefficients);
    List<Integer> quotient = new ArrayList<>(Collections.nCopies(this.coefficients.size(), 0));
    List<Integer> divisorCoefficients = new ArrayList<>(divisor.coefficients);
    
    while (dividend.size() >= divisorCoefficients.size()) {
      int scale = dividend.get(dividend.size() - 1) / divisorCoefficients.get(divisorCoefficients.size() - 1);
      quotient.set(dividend.size() - divisorCoefficients.size(), scale);
      
      for (int i = 0; i < divisorCoefficients.size(); i++) {
        dividend.set(dividend.size() - i - 1, dividend.get(dividend.size() - i - 1)
                       - scale * divisorCoefficients.get(divisorCoefficients.size() - i - 1));
      }
      
      while (!dividend.isEmpty() && dividend.get(dividend.size() - 1) == 0) {
        dividend.remove(dividend.size() - 1);
      }
    }
    
    while (!quotient.isEmpty() && quotient.get(quotient.size() - 1) == 0) {
      quotient.remove(quotient.size() - 1);
    }
    
    int[] quotientArray = new int[quotient.size()];
    for (int i = 0; i < quotient.size(); i++) {
      quotientArray[i] = quotient.get(i);
    }
    
    int[] remainderArray = new int[dividend.size()];
    for (int i = 0; i < dividend.size(); i++) {
      remainderArray[i] = dividend.get(i);
    }
    
    return new Polynomial[] { new Polynomial(quotientArray), new Polynomial(remainderArray) };
  }
  
  /**
   * returns derivative of polynomial.
   * @param i, derivativeCoefficients, coefficients
   * @return Polynomial(DerivativeCoefficients)
   */
  
  public Polynomial derivative() {
    int[] derivativeCoefficients = new int[coefficients.size() - 1];
    for (int i = 1; i < coefficients.size(); i++) {
      derivativeCoefficients[i - 1] = coefficients.get(i) * i;
    }
    return new Polynomial(derivativeCoefficients);
  }
  
  /**
   * finds the roots of a polynomial through the newton-raphson method.
   * @param x, xNew, guess, tolerance, maxIteration, iteration, derivative
   * @return x
   */
  
  public double root(double guess, double tolerance, int maxIterations) {
    double x = guess;
    int iteration = 0;
    
    while (Math.abs(this.evaluate(x)) > tolerance && iteration < maxIterations) {
      double derivative = this.derivative().evaluate(x);
      
      if (Math.abs(derivative) < tolerance) {
        x += tolerance;
      } else {
        double xNew = x - this.evaluate(x) / derivative;
        x = xNew;
      }
      
      if (Math.abs(x) <= tolerance) {
        return 0.0;
      }
      
      iteration++;
    }
    
    return x;
  }
  
}