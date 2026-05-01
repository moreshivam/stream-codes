package org.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println ("Hello world!");

        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);

        List<Integer> ans = list.stream()
                .filter(n -> n%2 ==0)
                .collect(Collectors.toList());

        System.out.println(ans);
    }
}