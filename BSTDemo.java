/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bstdemo;

public class BSTDemo {

   
    public static void main(String[] args) {
        BSTree t = new BSTree();
        t.addNode(7);
        t.addNode(6);
        t.addNode(10);
        t.addNode(9);
        t.addNode(1);
        t.addNode(5);
        t.addNode(8);
        t.addNode(11);
        t.addNode(2);
        t.remove(8);
        t.remove(5);
        System.out.println("inorder");
        t.inorderTraversal(t.root);
        System.out.println("preorder");
        t.preorderTraversal(t.root);
        System.out.println("postorder");
        t.postorderTraversal(t.root);
        System.out.println("find 1 = "+t.findNode(1));
    }
    
}
class BSTNode{
    int data;
    BSTNode leftChild;
    BSTNode rightChild;

    public BSTNode(int key){
        this.data=key;
    }
    @Override
    public String toString(){
        return "data -> "+data;
    }
    public BSTNode minNode(){
        if(this.leftChild==null){
            return this;
        }else{
            return this.leftChild.minNode();
        }
    }
    public boolean remove(int data, BSTNode parentNode){
        if(data<this.data){
            if(this.leftChild!=null){
                return leftChild.remove(data, this);
            }else
               return false;
            
        }else if(data>this.data){
            if(this.rightChild!=null){
                return rightChild.remove(data, this);
            }else
               return false;
        }else{
            if(leftChild!=null&&rightChild!=null){
                this.data=rightChild.minNode().data;
                rightChild.remove(this.data, rightChild);
            }else if(parentNode.leftChild==this){
              parentNode.leftChild=(this.leftChild!=null)?leftChild:rightChild;  
            }else if(parentNode.rightChild==this){
              parentNode.rightChild=(this.rightChild!=null)?rightChild:leftChild;
            }
            return true;
        }
    }
}
class BSTree {
    BSTNode root;
    public void addNode(int data) {
        BSTNode newNode = new BSTNode(data);
        if(root==null){
            root=newNode;
        }else{
            BSTNode parentNode;
            BSTNode currentNode=root;
            while(true){
              if(newNode.data<currentNode.data){
                  parentNode=currentNode;
                  currentNode=currentNode.leftChild;
                  if(currentNode==null){
                      parentNode.leftChild=newNode;
                      return;
                  }
              }else{
                  parentNode=currentNode;
                  currentNode=currentNode.rightChild;
                  if(currentNode==null){
                      parentNode.rightChild=newNode;
                      return;
                  }
              }  
            }
        }
    }
    public BSTNode findNode(int data) {
        BSTNode currentNode=root;
        while(currentNode.data!=data){
            if(data<currentNode.data){
                currentNode= currentNode.leftChild;
            }else{
                currentNode= currentNode.rightChild;
            }
            if(currentNode==null){
                return null;
            }
        }
        return currentNode;
    }
    public void inorderTraversal(BSTNode currentNode) {
        if(currentNode!=null){
            inorderTraversal(currentNode.leftChild);
            System.out.println(currentNode);
            inorderTraversal(currentNode.rightChild);
            
        }
    }
    public void postorderTraversal(BSTNode currentNode) {
        if(currentNode!=null){
            postorderTraversal(currentNode.leftChild);         
            postorderTraversal(currentNode.rightChild);
            System.out.println(currentNode);
            
        }
    }
    public void preorderTraversal(BSTNode currentNode) {
        if(currentNode!=null){
            System.out.println(currentNode);
            preorderTraversal(currentNode.leftChild);
            preorderTraversal(currentNode.rightChild);
            
        }
    }
    public boolean remove(int data){
    if(root==null)
        return false;
    else
        return root.remove(data,null);
    }
}

