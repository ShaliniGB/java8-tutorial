package com.winterbe.java8.samples.Shal_java_8_demos.Java8DateTime;

import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }
    public Person(){}
    public Person(String name, LocalDate age){
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
