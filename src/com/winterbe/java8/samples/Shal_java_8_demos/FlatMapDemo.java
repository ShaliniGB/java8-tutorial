package com.winterbe.java8.samples.Shal_java_8_demos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapDemo {
    public static void main(String[] args){
        List<Integer> l1 = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> l2 = Arrays.asList(2,4,6);
        List<Integer> l3 = Arrays.asList(1,3,5,7);

        List<List<Integer>> allList= Arrays.asList(l1,l2,l3);
        System.out.println(allList);

        Function<List<?>, Integer> size = List::size;
        Function<List<Integer>, Stream<Integer>> flatmapper= l->l.stream();

        allList.stream().map(a-> a.size()).forEach(System.out::println);

        allList.stream().map(flatmapper).forEach(System.out::println);

        allList.stream().flatMap(flatmapper).forEach(System.out::println);
    }
}
