package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student implements Comparable<Student> {
    String name;
    int age;
    int grade;

    public Student(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    public int compareTo(Student o) {
        return Integer.compare(this.age, o.age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

class CompareByGrade implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.grade, o2.grade);
    }
}
public class CompareExample {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 22,2),
                new Student("Bob", 20,3),
                new Student("Cob", 20,2),
                new Student("Charlie", 23,1)
        );

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student.name + " - " + student.age + " - " + student.grade);
        }

        Collections.sort(students, new CompareByGrade());
        System.out.println("Sorted by grade:");
        for (Student student : students) {
            System.out.println(student.name + " - " + student.age + " - " + student.grade);
        }

        students.sort(Comparator.comparing(Student::getName));

        System.out.println("Sorted by name:");
        for (Student student : students) {
            System.out.println(student.name + " - " + student.age + " - " + student.grade);
        }

        students.sort(Comparator.comparing(Student::getAge).reversed().thenComparing(Student::getGrade));

        System.out.println("Sorted by age (desc) then by grade:");
        for (Student student : students) {
            System.out.println(student.name + " - " + student.age + " - " + student.grade);

        }


        Map<String,Integer> map = new HashMap<>();
        map.put("One",1);
        map.put("Two",2);
        map.put("Three",3);

        map.forEach((k,v) -> System.out.println(k + " : " + v));

        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2);
        Collections.sort(numbers, Comparator.reverseOrder());
        System.out.println("Sorted numbers in descending order: " + numbers);
    }
}
