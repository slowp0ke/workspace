public class Stack implements IStack {
      public int top;
      private int[] storage;
 
      Stack(int capacity) {
            if (capacity <= 0)
                  throw new IllegalArgumentException(
                             "Stack's capacity must be positive");
            storage = new int[capacity];
            top = -1;
      }
 
      public void push(int value) {
            if (top == storage.length)
                  throw new StackException("Stack's underlying storage is overflow");
            top++;
            storage[top] = value;
      }
 
       
     
      public int size(){
    	  if (top == -1)
              throw new StackException("Stack is empty");
    	  int amount = top + 1;
    	  System.out.println("size is " + amount);
    	  return amount;
      }
 
      public void pop() {
            if (top == -1)
                  throw new StackException("Stack is empty");
            top--;
      }
 
      boolean isEmpty() {		
            return (top == -1);
      }
 
      public class StackException extends RuntimeException {
            public StackException(String message) {
                  super(message);
            }
      }
      public static void main (String[] args){
  		
    	  Stack test = new Stack(10);
    	  
    	  test.push(1);
    	  test.size();
    	  test.push(4);
    	  test.size();
    	  test.push(12);
    	  test.size();
    	  test.pop();
    	  test.size();
    	  test.pop();
    	  test.size();
    	  test.pop();
    	  test.size();
    	  
  	}
    
}

