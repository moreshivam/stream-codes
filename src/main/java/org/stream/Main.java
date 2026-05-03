package org.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println ("Hello world!");

        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);

       //find all even numbers
        List<Integer> ans = list.stream()
                .filter(n -> n%2 ==0)
                .collect(Collectors.toList());

        System.out.println(ans);

        //find the second largest number
        int ans2 = list.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElse(-1);

        System.out.println(ans2);

        //count frequency of each word in a list
        List<String> list2 = List.of("apple", "banana", "cherry", "date", "elderberry");

        Map<String, Long> ans3 = list2.stream()
                .collect(Collectors.groupingBy(
                        Function.identity() ,
                        Collectors.counting()

        )
        );

        System.out.println(ans3);
        //You have a List of words (Strings) and want to sort them based on the 2nd character.
        List<String> ans4 = list2.stream()
                .sorted(Comparator.comparing(s -> s.charAt(2)))
                .collect(Collectors.toList());

        System.out.println(ans4);

        //Count Frequency of Words in a Sentence
        String words = "hello world hello java stream stream stream";

        Map<Character, Long> ans5 = words.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        System.out.println(ans5);
    }
}