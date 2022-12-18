package prac30;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class HaffmanAlg {
    public static void main(String[] args) {
        HaffmanTree hTree = new HaffmanTree("Huffman.Tree");
        hTree.displayEncodingArray();
    }
}
class HaffmanNode {
    private int frequence;//частота
    private char letter;//буква
    private HaffmanNode leftChild;//левый потомок
    private HaffmanNode rightChild;//правый потомок

    public HaffmanNode(char letter, int frequence) { //собственно, конструктор
        this.letter = letter;
        this.frequence = frequence;
    }

    public HaffmanNode() {}//перегрузка конструтора для безымянных узлов(см. выше в разделе о построении дерева Хаффмана)
    public void addChild(HaffmanNode newNode) {//добавить потомка
        if (leftChild == null)//если левый пустой=> правый тоже=> добавляем в левый
            leftChild = newNode;
        else {
            if (leftChild.getFrequence() <= newNode.getFrequence()) //в общем, левым потомком
                rightChild = newNode;//станет тот, у кого меньше частота
            else {
                rightChild = leftChild;
                leftChild = newNode;
            }
        }

        frequence += newNode.getFrequence();//итоговая частота
    }

    public HaffmanNode getLeftChild() {
        return leftChild;
    }

    public HaffmanNode getRightChild() {
        return rightChild;
    }

    public int getFrequence() {
        return frequence;
    }

    public char getLetter() {
        return letter;
    }

    public boolean isLeaf() {//проверка на лист
        return leftChild == null && rightChild == null;
    }
}
class BinaryTree {
    private HaffmanNode root;

    public BinaryTree() {
        root = new HaffmanNode();
    }

    public BinaryTree(HaffmanNode root) {
        this.root = root;
    }

    public int getFrequence() {
        return root.getFrequence();
    }

    public HaffmanNode getRoot() {
        return root;
    }
    public void printTree(){
        Queue<HaffmanNode> currentLevel = new LinkedList<HaffmanNode>();
        Queue<HaffmanNode> nextLevel = new LinkedList<HaffmanNode>();
        currentLevel.add(this.root);
        while(!currentLevel.isEmpty()){
            Iterator<HaffmanNode> iter = currentLevel.iterator();
            while(iter.hasNext()){
                HaffmanNode currentNode = iter.next();
                if(currentNode.getLeftChild() != null){
                    nextLevel.add(currentNode.getLeftChild());
                }
                if(currentNode.getRightChild() != null){
                    nextLevel.add(currentNode.getRightChild());
                }
                System.out.print(currentNode.getFrequence()+" ");
            }
            System.out.println(" ");
            currentLevel = nextLevel;
            nextLevel = new LinkedList<HaffmanNode>();
        }
    }
}


class PriorityQueue {
    private ArrayList<BinaryTree> data;//список очереди
    private int nElems;//кол-во элементов в очереди

    public PriorityQueue() {
        data = new ArrayList<BinaryTree>();
        nElems = 0;
    }

    public void insert(BinaryTree newTree) {//вставка
        if (nElems == 0)
            data.add(newTree);
        else {
            for (int i = 0; i < nElems; i++) {
                if (data.get(i).getFrequence() > newTree.getFrequence()) {//если частота вставляемого дерева меньше
                    data.add(i, newTree);//чем част. текущего, то cдвигаем все деревья на позициях справа на 1 ячейку
                    break;//затем ставим новое дерево на позицию текущего
                }
                if (i == nElems - 1)
                    data.add(newTree);
            }
        }
        nElems++;
    }

    public BinaryTree remove() {//удаление из очереди
        BinaryTree tmp = data.get(0);//копируем удаляемый элемент
        data.remove(0);//собственно, удаляем
        nElems--;//уменьшаем кол-во элементов на 1
        return tmp;//возвращаем удаленный элемент(элемент с наименьшей частотой)
    }
}
class HaffmanTree {
    private final byte ENCODING_TABLE_SIZE = 127;//длина кодировочной таблицы
    private String myString;//сообщение
    private BinaryTree huffmanTree;//дерево Хаффмана
    private int[] freqArray;//частотная таблица
    private String[] encodingArray;//кодировочная таблица


    //----------------constructor----------------------
    public HaffmanTree(String newString) {
        myString = newString;

        freqArray = new int[ENCODING_TABLE_SIZE];
        fillFrequenceArray();

        huffmanTree = getHuffmanTree();

        encodingArray = new String[ENCODING_TABLE_SIZE];
        fillEncodingArray(huffmanTree.getRoot(), "", "");
    }

    //--------------------frequence array------------------------
    private void fillFrequenceArray() {
        for (int i = 0; i < myString.length(); i++) {
            freqArray[(int)myString.charAt(i)]++;
        }
    }

    public int[] getFrequenceArray() {
        return freqArray;
    }

    //------------------------huffman tree creation------------------
    public BinaryTree getHuffmanTree() {
        PriorityQueue pq = new PriorityQueue();
        //алгоритм описан выше
        for (int i = 0; i < ENCODING_TABLE_SIZE; i++) {
            if (freqArray[i] != 0) {//если символ существует в строке
                HaffmanNode newNode = new HaffmanNode((char) i, freqArray[i]);//то создать для него Node
                BinaryTree newTree = new BinaryTree(newNode);//а для Node создать BinaryTree
                pq.insert(newTree);//вставить в очередь
            }
        }

        while (true) {
            BinaryTree tree1 = pq.remove();//извлечь из очереди первое дерево.

            try {
                BinaryTree tree2 = pq.remove();//извлечь из очереди второе дерево

                HaffmanNode newNode = new HaffmanNode();//создать новый Node
                newNode.addChild(tree1.getRoot());//сделать его потомками два извлеченных дерева
                newNode.addChild(tree2.getRoot());

                pq.insert(new BinaryTree(newNode));
            } catch (IndexOutOfBoundsException e) {//осталось одно дерево в очереди
                return tree1;
            }
        }
    }

    public BinaryTree getTree() {
        return huffmanTree;
    }

    void fillEncodingArray(HaffmanNode node, String codeBefore, String direction) {//заполнить кодировочную таблицу
        if (node.isLeaf()) {
            encodingArray[(int)node.getLetter()] = codeBefore + direction;
        } else {
            fillEncodingArray(node.getLeftChild(), codeBefore + direction, "0");
            fillEncodingArray(node.getRightChild(), codeBefore + direction, "1");
        }
    }

    String[] getEncodingArray() {
        return encodingArray;
    }

    public void displayEncodingArray() {
        fillEncodingArray(huffmanTree.getRoot(), "", "");

        for (int i = 0; i < ENCODING_TABLE_SIZE; i++) {
            if (freqArray[i] != 0) {
                System.out.print((char)i + " ");
                System.out.println(encodingArray[i]);
            }
        }
    }
    String getOriginalString() {
        return myString;
    }
}