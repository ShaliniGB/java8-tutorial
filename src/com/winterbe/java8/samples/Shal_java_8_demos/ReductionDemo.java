package com.winterbe.java8.samples.Shal_java_8_demos;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionDemo {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList();
        //Functional Interface
        Integer red1=list.stream().reduce(0,(l1,l2)-> l1+l2);

        //Method Reference
        Optional<Integer> red= list.stream().reduce(Integer::max);
        System.out.println(red);
//        System.out.println(red1);
    }
}
