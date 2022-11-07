package prac10;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentSort {
    public static void main(String[] args) {
        Student[] iDNumber = new Student[]{
                new Student("VladiSlave", "Karpov", "mathematician", "MBF-13", 3, 84),
                new Student("Jim", "Hawkins", "geology", "GTI-21", 2, 42),
                new Student("IVan", "Ismailov", "philosophy", "PGN-5", 4, 95),
                new Student("Billy", "Herrington", "mathematician", "MBF-12", 3,89)
        };

        outArray(iDNumber);
        qSort(iDNumber, iDNumber.length-1, 0);
        outArray(iDNumber);
    }

    public void setArray(){

    }

    public static void outArray(Student[] array){
        for (Student s : array){
            System.out.println(s);
        }
    }
    private static SortingStudentsByGPA comp = new SortingStudentsByGPA();

    public static void qSort(Object[] array, int high, int low) {
        if (array == null || array.length == 0) return;
        if (high <= low) return;

        Object middle = array[(low + high) / 2];
        ArrayList<Object> left = new ArrayList<>();
        ArrayList<Object> right = new ArrayList<>();
        ArrayList<Object> eq = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            if (comp.compare(array[i], middle) > 0) {
                right.add(array[i]);
            } else if (comp.compare(array[i], middle) < 0)
                left.add(array[i]);
            else eq.add(array[i]);
        }
        Object[] leftArr;
        Object[] rightArr;
        if (left.size() > 0) {
            leftArr = left.toArray();
            qSort(leftArr, left.size() - 1, 0);
            System.arraycopy(leftArr, 0, array, low, left.size());
        }
        System.arraycopy(eq.toArray(), 0, array, low + left.size(), eq.size());

        if (right.size() > 0) {
            rightArr = right.toArray();
            qSort(rightArr, right.size() - 1, 0);
            System.arraycopy(rightArr, 0, array, low + left.size() + eq.size(), right.size());

        }
    }
}


class Student {
    private String name, surname, specialty, group;
    private int course, GPA;

    public Student(String name, String surname, String specialty, String group, int course, int GPA) {
            this.name = name;
            this.surname = surname;
            this.specialty = specialty;
            this.group = group;
            this.course = course;
            this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", specialty='" + specialty + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", GPA=" + GPA +
                '}';
    }
}

class SortingStudentsByGPA implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (!(o1 instanceof Student && o2 instanceof Student))
            throw new IllegalArgumentException("Объекты не являются студентами!");

        return ((Student) o1).getGPA() - ((Student) o2).getGPA();
    }
}

