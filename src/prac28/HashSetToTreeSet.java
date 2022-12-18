package prac28;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class HashSetToTreeSet {
    public static <T> Set<T> getInstance(Set<T> hashSet){
        Set<T> treeSet = hashSet.stream().collect(Collectors.toCollection(TreeSet::new));
        return treeSet;
    }

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Car");
        hashSet.add("Plane");
        hashSet.add("Ship");
        hashSet.add("Bicycle");

        Set<String> treeSet = getInstance(hashSet);
        System.out.println(treeSet);
    }
}