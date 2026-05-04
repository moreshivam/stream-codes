package org.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        // filter number starting with 1
        List<Integer> ones = List.of(12,122,233,1444,1555);

        List<Integer> ans6 = ones.stream()
                .filter(n-> String.valueOf(n).startsWith("1"))
                .collect(Collectors.toList());

        System.out.println(ans6);

        // flat list of list into single list
        List<List<String>> words1 = List.of(
                List.of("apple", "banana"),
                List.of("cat", "dog"),
                List.of("java", "spring")
        );

        List<String> ans7 = words1.stream()
                .flatMap(List :: stream)
                .toList();

        System.out.println(ans7);


       //split sentences into words
        List<String> sentences = List.of(
                "hello world",
                "java stream"
        );
        List<String> ans8 =  sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .toList();

        System.out.println(ans8);

        //filter first 10 even numbers
        List<Integer> ans9 = IntStream.range( 1 ,100)
                .filter(n -> n%2 == 0)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(ans9);

        //iterate over a Map
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 2);
        map.put("banana", 3);
        map.put("cherry", 5);

        map.entrySet()
                .stream()
               .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }
}


