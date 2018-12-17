package com.winterbe.java8.samples.Shal_java_8_demos;

import java.io.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReductionExample {
    public static void main(String[] args){
        List<Person> persons = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\IntelliJ\\java8-tutorial\\src\\com\\winterbe\\java8\\samples\\Shal_java_8_demos\\people.txt")));
             Stream<String> stream= bf.lines();
        ) {
            stream.map(line-> {
              String[] p= line.split(" ");
              Person per = new Person(p[0].trim(),Integer.parseInt(p[1]));
              persons.add(per);
              return per;
            }).forEach(System.out::println);
            Stream<Person> stream1 = persons.stream();
            Optional<Person> opt = stream1.filter(person -> person
                    .getAge()>=20).min(Comparator.comparing(Person::getAge));
            System.out.println(opt);

            Optional<Person> opt2 = persons.stream().filter(person -> person.getAge()>=20).max(Comparator.comparing(Person::getAge));
            System.out.println(opt2);

            Map<Integer, Long> map= persons.stream().collect(
                    Collectors.groupingBy(Person::getAge,
                            Collectors.counting())
            );
            System.out.println(map);

            Map<Integer, List<String>> map1= persons.stream().collect(
                    Collectors.groupingBy(Person::getAge,
                            Collectors.mapping(Person::getName, Collectors.toList()))

            );
            System.out.println(map1);

            // to sort the name based on age
            Map<Integer, Set<String>> map2= persons.stream().collect(
                    Collectors.groupingBy(Person::getAge,
                            Collectors.mapping(Person::getName, Collectors.toCollection(TreeSet::new)))

            );
            System.out.println(map2);
            //to Put this in String
            Map<Integer, String> map3= persons.stream().collect(
                    Collectors.groupingBy(Person::getAge,
                            Collectors.mapping(Person::getName, Collectors.joining(",")))

            );
            System.out.println(map3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
