/**
 * CS210 Project 1 class TestPolynomial
 * Edited by Chris Kelly for Fall 2017 
 * 
 * @author Bob Wilson
 * @version July 6, 2009
 * 
 */

import junit.framework.TestCase;

public class TestPolynomial extends TestCase
{
    // tolerance for double equality
    double TOLERANCE = 0.0001;           

    public void testGeneral()
    {
        Polynomial p1 = new Polynomial(1, 2, 3, -4);
        Polynomial p2 = new Polynomial(0, 1, 2, 3, 4, 5);
        
        assertEquals("-4x^3 + 3x^2 + 2x^1 + 1x^0", p1.toString());
        assertEquals("5x^5 + 4x^4 + 3x^3 + 2x^2 + 1x^1", p2.toString());

        assertEquals( -15.0, p1.evaluate(2), TOLERANCE);
        assertEquals(1641.0, p2.evaluate(3), TOLERANCE);
        
        // test compareTo with different degree polynomials
        assertTrue(p1.compareTo(p2) < 0);
        assertTrue(p2.compareTo(p1) > 0);
        
        // test compareTo with same degree but different polynomials
        p2 = new Polynomial(0, 1, 2, 3);     
        assertTrue(p1.compareTo(p2) < 0);
        assertTrue(p2.compareTo(p1) > 0);
        
        // test compareTo with equal polynomials
        p1 = new Polynomial(0, 1, 2, 3);     
        assertTrue(p1.compareTo(p2) == 0);
    }
    
    public void testPlus()
    {
        Polynomial p1 = new Polynomial(1, 2, 3, 4);
        Polynomial p2 = new Polynomial(0, 1, 2, 3, 4, 5);
        assertEquals("8x^3 + 6x^2 + 4x^1 + 2x^0", p1.plus(p1).toString());
        assertEquals("5x^5 + 4x^4 + 7x^3 + 5x^2 + 3x^1 + 1x^0", p1.plus(p2).toString());
        assertEquals("5x^5 + 4x^4 + 7x^3 + 5x^2 + 3x^1 + 1x^0", p2.plus(p1).toString());
        
    }
    
    public void testMinus()
    {
        Polynomial p1 = new Polynomial(1, 2, 3, 4);
        Polynomial p2 = new Polynomial(0, 1, 2, 3, 4, 5);
        assertEquals("",p1.minus(p1).toString());
        assertEquals("-5x^5 - 4x^4 + 1x^3 + 1x^2 + 1x^1 + 1x^0", p1.minus(p2).toString());
        assertEquals("5x^5 + 4x^4 - 1x^3 - 1x^2 - 1x^1 - 1x^0", p2.minus(p1).toString());
        
    }
    
    public void testMultiply()
    {
        Polynomial p1 = new Polynomial(1,1);
        Polynomial p2 = new Polynomial(1, 2, 1);
        Polynomial p3 = new Polynomial(1, 3, 3, 1);
        assertTrue(p2.compareTo(p1.multiply(p1)) == 0);
        assertTrue(p3.compareTo(p2.multiply(p1)) == 0);
    }
    
    public void testDivide()
    {
        final int quotient = 0;
        final int remainder = 1;
        Polynomial p0 = new Polynomial(0);
        Polynomial p1 = new Polynomial(1, 1);
        Polynomial p2 = new Polynomial(1, 2, 1);
        Polynomial p3 = new Polynomial(1, 3, 3, 1);
        Polynomial [] r = p1.divide(p2);
        assertTrue(p0.equals(r[quotient]));
        assertTrue(p1.equals(r[remainder]));
        r = p2.divide(p1);
        assertTrue(p1.equals(r[quotient]));
        assertTrue(p0.equals(r[remainder]));
        
        try {
            r = p1.divide(p0);
            assertTrue(false);        // Shouldn't get here
        }
        catch (ArithmeticException e) {
            ;                         // Should come here, but nothing to do
        }
    }
    
    public void testDerivative()
    {
        Polynomial p0 = new Polynomial(0);
        Polynomial p1 = new Polynomial(6);
        Polynomial p2 = new Polynomial(6, 6);
        Polynomial p3 = new Polynomial(3, 6, 3);
        Polynomial p4 = new Polynomial(1, 3, 3, 1);
        assertTrue(p0.equals(p1.derivative()));
        assertTrue(p1.equals(p2.derivative()));
        assertTrue(p2.equals(p3.derivative()));
        assertTrue(p3.equals(p4.derivative()));
    }
        
    public void testRoot()
    {
        // roots = +1 and -1
        Polynomial p1 = new Polynomial(1, 0, -1);   
        double x = p1.root(1.5, TOLERANCE, 10);
        assertTrue(Math.abs(x - 1) < TOLERANCE);
        assertTrue(Math.abs(p1.evaluate(x)) < TOLERANCE);
        
        x = p1.root(-1.5, TOLERANCE, 10);
        assertTrue(Math.abs(x + 1) < TOLERANCE);
        assertTrue(Math.abs(p1.evaluate(x)) < TOLERANCE);
        

        x = p1.root(0.0, TOLERANCE, 10);
        assertTrue(x == 0.0);                      // should return original guess
        
        x = p1.root(100000.0, TOLERANCE, 10);      // original guess too far to converge in 10 iterations
        System.out.println(x);
        assertFalse(Math.abs(x - 1) < TOLERANCE);
    }
}