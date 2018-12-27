/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noduplonglinkedlistapp;

/**
 *
 * @author Student
 */
public class NoDupLongLinkedListApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.insert(12);
        a.insert(46);
        a.insert(15);
        a.insert(45);
        a.insert(32);
        a.display();
        a.reverse();
         a.display();
      
    }
    
}
class Node{
    public long value;
    public Node next;
    public Node(long value){
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
    public void insert(long value){
        if(find(value)){
            System.out.println("Value is alredy exist");
            return;
        }
        Node newNode = new Node(value);
        newNode.next= this.head;
        this.head=newNode;
    }
    public boolean find(long searchVal){
        Node current = head;
       
        while(current!=null){
            if(current.value==searchVal)
                return true;
            current = current.next;
        }
        return false;
    }
    public boolean delete(long dValue){
        Node current = head;
        Node prev = current;
        while(current!=null){
            if(current.value==dValue){
                if(current==head){
                    head=head.next;
                    return true;
                }else{
                prev.next= current.next;
                return true;
                }
            }
            prev=current;
            current=current.next;
        }
        return false;
     }
    public void display(){
        if(isEmpty()){
            System.out.println("List is empty. Nothing to print!");
        }
        Node current = head;
        while(current!=null){
            System.out.print(current.value+" ");
            current = current.next;
        }
        System.out.println();
    }
    public void reverse(){
        Node current=head;
        Node prev=null;
        Node nextnode=null;
        while (current!=null){
            nextnode=current.next;
            current.next=prev;
            prev=current;
            current=nextnode;
            
        }
        head=prev;
      
        
    }
}
