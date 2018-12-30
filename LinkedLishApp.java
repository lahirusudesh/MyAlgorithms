/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlishapp;

/**
 *
 * @author Student
 */
public class LinkedLishApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.insertFirst(12);
        a.insertFirst(14);
        a.insertFirst(15);
        a.insertFirst(45);  
        a.insertFirst(20);
       
    }
    
}

class Node{
    public int value;
    public Node next;
    public Node(int value){
        this.value=value;
        this.next=null;
    }
}
class LinkedList{
    private Node head;
    public LinkedList(){
        head=null;
    }
    public boolean isEmpty(){
        return (head==null);
    }
    public void insertFirst(int i){
        Node newNode = new Node(i);
        newNode.next= this.head;
        this.head=newNode;
    }
    public Node deleteFirst(){
        if (isEmpty()){
            System.out.println("List Empty! Can not delete");
            return null;
        }   
        Node temp = head;
        this.head = head.next;
        System.out.println("Value Deleted!");
        return temp;
    }
    public void displayList(){
        if(isEmpty()){
            System.out.println("List is empty. Nothing to print!");
        }
        Node current = head;
        while(current!=null){
            System.out.println(current.value+" ");
            current = current.next;
        }
        System.out.println();
    }
    public Node find(int key){
        Node current = head;
        int i = 1;
        while(current!=null){
            if(key==i)
                return current;
            current = current.next;
            i++;
        }
        return null;
    }
     public void delete(int key){
         Node current = head;
         Node prev = current;
        int i = 1;
        while(current!=null){
            if(key==i){
                if(current==head){
                    head=head.next;
                    return;
                }else{
                prev.next= current.next;
                System.out.println(i+"th location deleted");
                return;
                }
            }
            prev=current;
            current=current.next;
            i++;
        }
     }
}
