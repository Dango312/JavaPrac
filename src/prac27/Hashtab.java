package prac27;
//index = hashcode(elem) & (n-1)
public class Hashtab<K> {
    public int len;
    private int bucket = 2;
    private String[] elements = new String[bucket];

    public void add(K key, String value){
        if(is_filled()){
            extend();
        }
        int index = (key.hashCode()) & (bucket-1);
        elements[index] = value;
        len++;
    }

    public void print(){
        for(int i =0; i< len; i++){
            System.out.println(elements[i]);
        }
    }


    private void extend(){
        this.bucket *= 2;
        String[] newElements = new String[bucket];
        for (int i = 0; i < bucket/2; i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    public boolean is_filled(){
        if (len == bucket) {
            return true;
        }
        return false;
    }

    public boolean is_empty(){
        if (len==0){
            return true;
        }
        else{
            return false;
        }
    }
}

class Student{
    private int age;
    private String FIO;
    public Student(int age, String FIO) {
        this.age = age;
        this.FIO = FIO;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", FIO='" + FIO + '\'' +
                '}';
    }
}
