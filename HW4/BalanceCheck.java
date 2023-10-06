import java.util.*;
import java.io.*;
import javax.swing.*;

public class BalanceCheck
{
  public static void main(String [] args)
  {
    Scanner file = null;
    JFileChooser myChooser = new JFileChooser();
    int status = myChooser.showOpenDialog(null);
    try
    {
      file = new Scanner(myChooser.getSelectedFile());
    }
    catch (Exception e)
    {
      System.out.println("Can not open File");
      System.exit(0);
    }
    
    // instantiate a stack to hold wrapper class Character objects
    // 1.  add a line of code here to do that
    Stack<Character> balanceStack = new Stack<>(); //instantiates the character stack
    
    char c1 = ' ';   // current character from the line
    char c2 = ' ';   // last {, (, or [ character (from stack)
    
    boolean error = false;
    while (!error && file.hasNext())
    {
      String line = file.nextLine();
      
      for (int i = 0; !error && i < line.length(); i++)
      {
        // 2.  add code here to do the balance check using the stack 
        c1=line.charAt(i); //sets c1 to current string character
        if (c1 == '{' || c1 == '(' || c1 == '['){ //boolean comparison to check for opeing delimiter
          balanceStack.push(c1); //pushes c1 to stack
        }
        else if (c1 == '}' || c1 == ')' || c1 == ']'){ //boolean comparison to check for closing delimitier
          c2 = (char)balanceStack.pop(); //pops top character off the stack
          if (!((c1 == '}' && c2 == '{') || (c1 == ')' && c2 == '(') || (c1 == ']' && c2 == '['))){
            error = true;
          }
        }
        //  System.out.println("stack: " + balanceStack); //checking the what is currently in the stack
        //    System.out.println("c2: " + c2);
        //      System.out.println("c1: " + c1);
      }
      
      
    }
    
    // 3.  add code here to print the results of the balance check
    //  if (!((c1 == '}' && c2 == '{') || (c1 == ')' && c2 == '(') || (c1 == ']' && c2 == '['))){
//      error = true;
    if(error){ //checks errors current true/false state
      System.out.println("There is a mismatch of delimiters.");//output for true
    }
    //   }
    else if (!balanceStack.isEmpty()){ //checks if the stack is empty
      // error = true; //sets error true
      //   if (error == true){ //checks errors current true/false state
      System.out.println("Balance check is not ok. A delimiter never closed.");//output for true
    }
    else {
      System.out.println("Balance check is ok. The stack is empty.");
    }
  } 
}
