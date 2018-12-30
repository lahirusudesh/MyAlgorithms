/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decimaltobinary;

/**
 *
 * @author Student
 */
public class DecimalToBinary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       StackArray sa = new StackArray(50);
       int div, rem;
       div =4;
       while(div!=0){
           rem = div%2;
           div=div/2;
           sa.push(rem);
       }
       sa.display();
    }
    
}
class StackArray {

    private int maxSize;
    private int[] stackData;
    private int top;

    public StackArray(int s) {
        top = -1;
        stackData = new int[s];
        maxSize = s;
    }

    public void push(int j) {

        if (isFull()) {
            System.out.println("Stack is Full!!");
        } else {
            //top++;
            stackData[++top] = j;
        }
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!! Can not Pop");
        } else {
            return stackData[top--];
        }
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!! Can not peek");
        } else {
            return stackData[top];
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Nothing to Display!");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.print(stackData[i] + " ");
            }
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return ((maxSize - 1) == top);
    }

}
