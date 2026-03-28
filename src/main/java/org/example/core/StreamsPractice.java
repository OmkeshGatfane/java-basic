package org.example.core;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPractice {

    public static void main(String[] args) {
        String val = "sdadgfasfsdfs";

        // remove duplicate
        Arrays.stream(val.split("")).distinct().forEach(System.out::print);

        //find letter with highest length
        val = "the length of the string can be determine and needs to be printed";
        String ans = Arrays.stream(val.split(" ")).sorted(Comparator.comparing(String::length).reversed()).findFirst().get();
        System.out.println();
        System.out.println(ans);

        //find letter with second-highest length
        val = "find the length of all the letter and find the 2nd highest letter in the string";
        ans = Arrays.stream(val.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();

        System.out.println(ans);

        // find 2nd highest letter from string if 2 letter are with same length take alphabetical first.
        val = "find the length of all the letter and find the 2nd highest letter in the atring";
        ans = Arrays.stream(val.split(" ")).sorted().sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();
        System.out.println(ans);
        System.out.println("-----------------------");

        // find word with specific number of vowels
        val = "I am Learning Stream API in Java";
        Arrays.stream(val.split(" ")).filter(x -> x.replaceAll("[^aeiouAEIOU]", "").length() == 2).forEach(System.out::println);

        // Given a list of integers, divide it into two lists of even and odd number
        int[] listOfNumbers = {1, 2, 3, 4, 5, 6, 7, 8};

        Map<Boolean, List<Integer>> mapOfIntList = Arrays.stream(listOfNumbers).boxed().collect(Collectors.groupingBy(x -> x % 2 == 0));
        //System.out.println(mapOfIntList);
        List<List<Integer>> li = mapOfIntList.entrySet().stream().map(x -> x.getValue()).toList();
        System.out.println(li);

        //Given a word, find the occurrence of each character
        Map<String, Long> output = Arrays.stream(val.replaceAll(" ", "").split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(output);

        int[] randomListOfNumbers = {1, 324, 5, 675, 3, 32, 6, 8, 7, 4, 43, 43, 6, 99};
        // Arrange the numbers in Ascending
        Arrays.stream(randomListOfNumbers).sorted().forEach(System.out::println);
        //  Arrange the numbers in Descending
        Arrays.stream(randomListOfNumbers).mapToObj(x -> x).sorted(Collections.reverseOrder()).forEach(System.out::println);

        System.out.println("-----------------------");

        // Given an array, find the sum of unique elements
        System.out.println(Arrays.stream(randomListOfNumbers).distinct().sum());

        // Given a string, find the first non-repeated character
        String finalVal = "Hello World";
        Arrays.stream(finalVal.replace(" ","").split(""))
                .filter(c-> finalVal.indexOf(c) == finalVal.lastIndexOf(c)).forEach(System.out::println);
        System.out.println("-----------------------");

        //Given a string, find the first non-repeated character
        String a = Arrays.stream(finalVal.replace(" ","").split("")).
                collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting())).
                entrySet().stream().filter(m->m.getValue() == 1).map(m->m.getKey()).findFirst().get();
        System.out.println(a);

        //Given a string, find the first repeated character
        String b = Arrays.stream(finalVal.replace(" ","").split("")).
                collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting())).
                entrySet().stream().filter(m->m.getValue() >1 ).map(m->m.getKey()).findFirst().get();
        System.out.println(b);

        System.out.println("-----------------------");

        //Given a list of strings, create a list that contains only integers
        String[] s = {"abc","123","450","xyv"};
        Arrays.stream(s).filter(x -> x.matches("[0-9]+")).map(Integer::valueOf).forEach(System.out::println);

        //Find the products of the first two elements in an array.
        System.out.println(Arrays.stream(randomListOfNumbers).boxed().limit(2).reduce(1,(x,y)->x*y));


    }
}
