package prac30;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinTree{
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        Tree<Integer> tree2 = new Tree<Integer>();
        for(int i = 0; i < 10; i++){
            tree.addNode(i, i+15);
            tree2.addNode(i,i+16);
        }
        tree.printTree();
        tree2.printTree();
        System.out.println(tree.getTreeWidth());
        System.out.println(tree.getCountOfNodes());
        System.out.println(tree.compareTrees(tree2));
    }
}
class Tree<T>{
    private Node<T> rootNode; // корневой узел

    public Tree() { // Пустое дерево
        rootNode = null;
    }

    public void addNode(int key, T value){
        Node<T> node = new Node<T>(key,value);
        if(this.rootNode == null){
            this.rootNode = node;
            return;
        }
        Queue<Node<T>> currentLevel = new LinkedList<Node<T>>();
        currentLevel.add(this.rootNode);
        Queue<Node<T>> nextLevel = new LinkedList<Node<T>>();
        while(true){
            Iterator<Node<T>> iter = currentLevel.iterator();
            while(iter.hasNext()){
                Node<T> currentNode = iter.next();
                if(currentNode.getLeftChild() == null){
                    currentNode.setLeft(node);
                    return;
                }
                if(currentNode.getRightChild() == null){
                    currentNode.setRight(node);
                    return;
                }
                if(currentNode.getLeftChild() != null){
                    nextLevel.add(currentNode.getLeftChild());
                }
                if(currentNode.getRightChild() != null){
                    nextLevel.add(currentNode.getRightChild());
                }
            }
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node<T>>();
        }
    }
    public void printTree(){
        Queue<Node<T>> currentLevel = new LinkedList<Node<T>>();
        Queue<Node<T>> nextLevel = new LinkedList<Node<T>>();
        currentLevel.add(this.rootNode);
        while(!currentLevel.isEmpty()){
            Iterator<Node<T>> iter = currentLevel.iterator();
            while(iter.hasNext()){
                Node<T> currentNode = iter.next();
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
            nextLevel = new LinkedList<Node<T>>();
        }
    }
    public int getDeep(){
        int deep = 0;
        if(this.rootNode == null){
            return 0;
        }
        Queue<Node<T>> currentLevel = new LinkedList<Node<T>>();
        Queue<Node<T>> nextLevel = new LinkedList<Node<T>>();
        currentLevel.add(this.rootNode);
        while(!currentLevel.isEmpty()){
            Iterator<Node<T>> iter = currentLevel.iterator();
            while(iter.hasNext()){
                Node<T> currentNode = iter.next();
                if(currentNode.getLeftChild() != null){
                    nextLevel.add(currentNode.getLeftChild());
                }
                if(currentNode.getRightChild() != null){
                    nextLevel.add(currentNode.getRightChild());
                }
            }
            deep++;
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node<T>>();
        }
        return deep;
    }
    public void reverseTree(){
        Queue<Node<T>> currentLevel = new LinkedList<Node<T>>();
        Queue<Node<T>> nextLevel = new LinkedList<Node<T>>();
        currentLevel.add(this.rootNode);
        while(!currentLevel.isEmpty()){
            Iterator<Node<T>> iter = currentLevel.iterator();
            while(iter.hasNext()){
                Node<T> currentNode = iter.next();
                if(currentNode.getLeftChild() != null){
                    nextLevel.add(currentNode.getLeftChild());
                }
                if(currentNode.getRightChild() != null){
                    nextLevel.add(currentNode.getRightChild());
                }
                Node<T> container = currentNode.getLeftChild();
                currentNode.setLeft(currentNode.getRightChild());
                currentNode.setRight(container);
            }
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node<T>>();
        }
    }
    public String searchElement(int key){
        Queue<Node<T>> currentLevel = new LinkedList<Node<T>>();
        Queue<Node<T>> nextLevel = new LinkedList<Node<T>>();
        currentLevel.add(this.rootNode);
        while(!currentLevel.isEmpty()){
            Iterator<Node<T>> iter = currentLevel.iterator();
            while(iter.hasNext()){
                Node<T> currentNode = iter.next();
                if(currentNode.getLeftChild() != null){
                    nextLevel.add(currentNode.getLeftChild());
                }
                if(currentNode.getRightChild() != null){
                    nextLevel.add(currentNode.getRightChild());
                }
                if(currentNode.getKey() == key){
                    return currentNode.getInfo();
                }
            }
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node<T>>();
        }
        return "Invalid key";
    }
    public int getTreeWidth(){
        Queue<Node<T>> currentLevel = new LinkedList<Node<T>>();
        Queue<Node<T>> nextLevel = new LinkedList<Node<T>>();
        currentLevel.add(this.rootNode);
        int width=0;
        while(!currentLevel.isEmpty()){
            Iterator<Node<T>> iter = currentLevel.iterator();
            int tmpWidth = 0;
            while(iter.hasNext()){
                Node<T> currentNode = iter.next();
                tmpWidth++;
                if(currentNode.getLeftChild() != null){
                    nextLevel.add(currentNode.getLeftChild());
                }
                if(currentNode.getRightChild() != null){
                    nextLevel.add(currentNode.getRightChild());
                }
            }
            if(tmpWidth > width){
                width = tmpWidth;
            }
            tmpWidth = 0;
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node<T>>();
        }
        return width;
    }
    public int getCountOfNodes(){
        int countOfNodes = 0;
        Queue<Node<T>> currentLevel = new LinkedList<Node<T>>();
        Queue<Node<T>> nextLevel = new LinkedList<Node<T>>();
        currentLevel.add(this.rootNode);
        while(!currentLevel.isEmpty()){
            Iterator<Node<T>> iter = currentLevel.iterator();
            while(iter.hasNext()){
                Node<T> currentNode = iter.next();
                if(currentNode.getLeftChild() != null){
                    nextLevel.add(currentNode.getLeftChild());
                }
                if(currentNode.getRightChild() != null){
                    nextLevel.add(currentNode.getRightChild());
                }
                if(currentNode.isHaveChild()){
                    countOfNodes++;
                }
            }
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node<T>>();
        }
        return countOfNodes;
    }
    public boolean compareTrees(Tree<T> tree){
        Queue<Node<T>> currentLevel = new LinkedList<Node<T>>();
        Queue<Node<T>> nextLevel = new LinkedList<Node<T>>();
        Queue<Node<T>> currentLevel2 = new LinkedList<Node<T>>();
        Queue<Node<T>> nextLevel2 = new LinkedList<Node<T>>();
        currentLevel.add(this.rootNode);
        currentLevel2.add(tree.getRoot());
        while(!currentLevel.isEmpty()){
            Iterator<Node<T>> iter = currentLevel.iterator();
            Iterator<Node<T>> iter2 = currentLevel2.iterator();
            while(iter.hasNext()){
                Node<T> currentNode = iter.next();
                if(!iter2.hasNext()){
                    return false;
                }
                Node<T> currentNode2 = iter2.next();
                if(currentNode.getLeftChild() != null){
                    nextLevel.add(currentNode.getLeftChild());
                    nextLevel2.add(currentNode2.getLeftChild());
                }
                if(currentNode.getRightChild() != null){
                    nextLevel.add(currentNode.getRightChild());
                    nextLevel2.add(currentNode2.getRightChild());
                }
                if(!currentNode.getInfo().equals(currentNode2.getInfo())){
                    return false;
                }
            }
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node<T>>();
            currentLevel2 = nextLevel2;
            nextLevel2 = new LinkedList<Node<T>>();
        }
        return true;
    }
    public Node<T> getRoot(){
        return this.rootNode;
    }
}
class Node<T>{
    T info;
    int key;
    Node<T> left = null;
    Node<T> right = null;
    Node<T> parent = null;
    public Node(int key, T info){
        this.key = key;
        this.info = info;
    }
    public Node(T info){
        this.info = info;
    }
    public Node<T> getLeftChild() {
        return left;
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }
    public Node<T> getRightChild() {
        return right;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }
    public boolean isHaveChild(){
        if(this.right == null && this.left == null){
            return false;
        }
        return true;
    }
    public String getInfo(){
        return String.valueOf(this.info);
    }
    public int getKey(){
        return key;
    }
    public int getValue(){
        return Integer.parseInt(String.valueOf(this.info));
    }
    public Node<T> getParent(){
        return this.parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
}