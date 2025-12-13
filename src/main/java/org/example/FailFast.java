package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FailFast {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();//without this line the code will run fine no concurrent modification exception will be thrown
            System.out.println(number);
                // This will cause a ConcurrentModificationException
                numbers.add(6);
        }


    }
}
