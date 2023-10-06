/*
 * @(#)QuadraticCLI.java 1.0
 *
 *
 * Command Line Interface for quadratic equation solver
 * Bob Wilson
 * 09/09/2009
 *
 */

import java.util.Scanner;

public class QuadraticCLI {
  public static void main(String[] arg) {
    // coefficients of the quadratic equation
    int a = 0;           
    int b = 0;
    int c = 0;

    // instantiate our scan object of Scanner class
    Scanner scan = new Scanner(System.in);

    // get the coefficients and solve for the roots of a quadratic equation
    System.out.println(
        "Enter three coefficients for quadratic equation to be solved");

    do {
    System.out.println("Enter coefficient a:");
    while (!scan.hasNextInt()) {
      scan.next(); // burn off any non-integer value as a string
    }
    // get the first coefficient as an integer
    a = scan.nextInt();

    System.out.println("Enter coefficient b:");
    while (!scan.hasNextInt()) {
      scan.next(); // burn off any non-integer value as a string
    }
    // get the second coefficient as an integer
    b = scan.nextInt();

    System.out.println("Enter coefficient c:");
    while (!scan.hasNextInt()) {
      scan.next(); // burn off any non-integer value as a string
    }
    // get the third coefficient and as an integer
    c = scan.nextInt();

    // use the solver to print the equation and its solution
    QuadraticSolver mySolver = new QuadraticSolver(a, b, c);
    System.out.println(mySolver.getEquation());
    System.out.println(mySolver.getSolution());
    
    // ask the user about solving another equation
    System.out.println("Do you want to solve another equation (y or n)?:");
    }
    while(scan.next().equals("y"));
    scan.close();
  }
}
