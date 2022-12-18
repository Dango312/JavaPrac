package prac30;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BSTTreeTester {
    public static void main(String[] args) {
        int[] values  = {100,4,2,5,1,101, 1203, 12, 7,9};
        BSTTree bsttree = new BSTTree(values);
        bsttree.printTree();
        bsttree.deleteNode(12);
        bsttree.printTree();
    }
}
class BSTTree{
    private Node<Integer> root;


    public BSTTree(int[] values){
        for(int value : values){
            addElement(value);
        }
    }
    public void addElement(int value){
        Node<Integer> node = new Node<Integer>(value);
        if(this.root == null){
            this.root = node;
            return;
        }
        Node<Integer> currentNode = this.root;
        while(true){
            if(value > currentNode.getValue()) {
                if(currentNode.getRightChild() == null) {
                    node.setParent(currentNode);
                    currentNode.setRight(node);
                    return;
                }
                currentNode = currentNode.getRightChild();
            }
            else {
                if(currentNode.getLeftChild() == null){
                    node.setParent(currentNode);
                    currentNode.setLeft(node);
                    return;
                }
                currentNode = currentNode.getLeftChild();
            }
        }
    }
    public void printTree(){
        Queue<Node<Integer>> currentLevel = new LinkedList<Node<Integer>>();
        Queue<Node<Integer>> nextLevel = new LinkedList<Node<Integer>>();
        currentLevel.add(this.root);
        while(!currentLevel.isEmpty()){
            Iterator<Node<Integer>> iter = currentLevel.iterator();
            while(iter.hasNext()){
                Node<Integer> currentNode = iter.next();
                if(currentNode.getLeftChild() != null){
                    nextLevel.add(currentNode.getLeftChild());
                }
                if(currentNode.getRightChild() != null){
                    nextLevel.add(currentNode.getRightChild());
                }
                System.out.print(currentNode.getInfo()+" ");
            }
            System.out.println(" ");
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node<Integer>>();
        }
    }
    private Node<Integer> searchMinElement(Node<Integer> tmpRoot){
        Node<Integer> current = tmpRoot;
        while(current.getLeftChild() != null){
            current = current.getLeftChild();
        }
        return current;
    }
    public void deleteNode(int value){
        if(root == null){
            return;
        }
        Node<Integer> currentNode = root;

        while (true){
            if(currentNode.getValue() == value){
                if(!currentNode.isHaveChild()){
                    System.out.println("first");
                    if(value > currentNode.getParent().getValue()){
                        currentNode.getParent().setRight(null);
                    } else{
                        currentNode.getParent().setLeft(null);
                    }
                } else if (currentNode.getRightChild() != null && currentNode.getLeftChild() != null) {
                    System.out.println("Second");
                    Node<Integer> minElement = searchMinElement(currentNode);
                    minElement.setLeft(currentNode.getLeftChild());
                    minElement.setRight(currentNode.getRightChild());
                    if(value > currentNode.getParent().getValue()){
                        currentNode.getParent().setRight(minElement);
                    } else{
                        currentNode.getParent().setLeft(minElement);
                    }
                } else if(currentNode.getRightChild() != null){
                    System.out.println("Third");
                    if(value > currentNode.getParent().getValue()){
                        currentNode.getParent().setRight(currentNode.getRightChild());
                    } else{
                        currentNode.getParent().setLeft(currentNode.getRightChild());
                    }
                } else{
                    System.out.println("Forth");
                    if(value > currentNode.getParent().getValue()){
                        currentNode.getParent().setRight(currentNode.getLeftChild());
                    } else{
                        currentNode.getParent().setLeft(currentNode.getLeftChild());
                    }
                }
                return;
            }
            if(value > currentNode.getValue()){
                if(currentNode.getLeftChild() != null){
                    currentNode = currentNode.getLeftChild();
                } else{
                    return;
                }
            } else{
                if(currentNode.getRightChild() != null){
                    currentNode = currentNode.getRightChild();
                } else {
                    return;
                }
            }
        }

    }
}