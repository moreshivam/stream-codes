package org.stream;

import java.util.Comparator;
import java.util.List;
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

    }
}