/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackdemo;

import java.util.LinkedList;

/**
 *
 * @author Student
 */
public class StackDemoLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        StackArray sa = new StackArray(5);
        sa.push(26);
        sa.push(27);
        sa.push(56);
        try{
        System.out.println("Peek is "+ sa.peek());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        sa.push(85);
        sa.push(89);
        sa.push(89);
        sa.display();
        try{
        sa.pop();
        sa.pop();
        sa.pop();
        sa.pop();
        sa.pop();
        sa.pop();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
        sa.peek();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        sa.display();
        StackDemo sd = new StackDemo();
        sd.conversion(16);
    }
    public void conversion(int value){
    StackArray sa = new StackArray(50);
       int div, rem;
       div =value;
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
    private LinkedList<Integer> stackData;
    private int top;

    public StackArray(int s) {
        top = -1;
        stackData = new LinkedList<Integer>();
        maxSize = s;
    }

    public void push(int j) {

        if (isFull()) {
            System.out.println("Stack is Full!!");
        } else {
            ++top;
            stackData.add(j);
        }
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!! Can not Pop");
        } else {
           // return stackData[top--];
           return stackData.get(top--);
        }
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!! Can not peek");
        } else {
           // return stackData[top];
           return stackData.get(top);
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Nothing to Display!");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.print(stackData.get(i) + " ");
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
