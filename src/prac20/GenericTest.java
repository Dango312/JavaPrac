package prac20;

import prac6.Printable;

import java.io.Serializable;

public class GenericTest {
    public static void main(String[] args){
        GenericClass g1 = new GenericClass(213, "MEMREA", "RTU");
        g1.getType();
    }
}

class Animal<K>{

}

class GenericClass<T, V, K>  extends Animal<K> implements Comparable<T>, Serializable {

    private T param;
    private V value;
    private K key;

    public GenericClass(T param, V value, K key) {
        this.param = param;
        this.value = value;
        this.key = key;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void getType(){
        System.out.println(param.getClass() + "; " + key.getClass() + "; " + value.getClass());
    }

    @Override
    public int compareTo(T o) {
        return 432;
    }
}