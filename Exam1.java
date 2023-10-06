import java.util.Stack ;
import java.util.Queue ;
import java.util.LinkedList ;

Stack<String> myStack = new Stack<String>() ;
Queue<String> myQueue = new LinkedList<String>() ;

myQueue.offer("Red") ;
myQueue.offer("Blue") ;
myQueue.offer("Yellow") ;
myQueue.offer("Green") ;

myStack.push(myQueue.poll()) ;
myStack.push(myQueue.peek()) ;
myStack.push(myQueue.peek()) ;
myStack.push(myQueue.poll()) ;

myQueue.offer(myStack.peek()) ;
myQueue.offer(myStack.pop()) ;

while(!myQueue.isEmpty())
    System.out.println(myQueue.poll()) ;

while(!myStack.isEmpty())
    System.out.println(myStack.pop()) ;