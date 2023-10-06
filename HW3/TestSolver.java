import junit.framework.TestCase;

public class TestSolver extends TestCase {
  private QuadraticSolver root;
  
  public TestSolver()
  {
// nothing needed here
  }
  
  public void test2RealRoots()
  {
    root = new QuadraticSolver(1, 0, -3);
    
    assertEquals("Solving: 1x\u00b2 + 0x -3 = 0", root.getEquation());
    assertEquals("Root 1 is 1.7320508075688772\nRoot 2 is -1.7320508075688772", root.getSolution());
  }
  
  public void test2ImaginaryRoots()
  {
    root = new QuadraticSolver(1, 1, 1);
    assertEquals("Solving: 1x\u00b2 + 1x + 1 = 0", root.getEquation());
    assertEquals("Root 1 is -0.5 + i 0.8660254037844386\nRoot 2 is -0.5 - i 0.8660254037844386", root.getSolution());
    
  }
  
  public void testOnly1Root()
  {
    root = new QuadraticSolver(1, 2, 1);
    assertEquals("Solving: 1x\u00b2 + 2x + 1 = 0", root.getEquation());
    assertEquals("The only root is -1.0", root.getSolution());
    
  }
  
  public void testLinear()
  {
    root = new QuadraticSolver(0, 2, 4);
    assertEquals("Solving: 0x\u00b2 + 2x + 4 = 0", root.getEquation());
    assertEquals("The only root is -2.0", root.getSolution());
    
  }
  
  public void testNoSolution()
  {
    root = new QuadraticSolver(0, 0, 6);
    assertEquals("Solving: 0x\u00b2 + 0x + 6 = 0", root.getEquation());
    assertEquals("No value for x is a solution", root.getSolution());
    
  }
  
  public void testAnySoution()
  {
    root = new QuadraticSolver(0, 0, 0);
    assertEquals("Solving: 0x\u00b2 + 0x + 0 = 0", root.getEquation());
    assertEquals("Any value for x is a solution", root.getSolution());
    
  }
}