package com.winterbe.java8.samples.Shal_java_8_demos.Java8DateTime;



import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class DateTimeDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Date d=new Date();
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\IntelliJ\\java8-tutorial\\src\\com\\winterbe\\java8\\samples\\Shal_java_8_demos\\Java8DateTime\\peopleDOB.txt")));
             Stream<String> stream = bf.lines();
        ) {
            stream.map(line -> {
                String[] p = line.split(" ");
                Integer year = Integer.parseInt(p[1]);
                Month month = Month.of(Integer.parseInt(p[2]));
                Integer day = Integer.parseInt(p[3]);
                Person per = new Person(p[0].trim(), LocalDate.of(year,month,day));
                persons.add(per);
                return per;
            }).forEach(System.out::println);

            LocalDate now = LocalDate.of(2018,Month.DECEMBER,17);
            persons.stream().forEach(p->{
                        Period period = Period.between(p.getAge(), now);
                        System.out.println(p.getName()+"  Was born "+ period.get(ChronoUnit.YEARS)+" Years and "
                               + period.get(ChronoUnit.MONTHS)+" Months [ "   + p.getAge().until(now, ChronoUnit.MONTHS) +" ]" );
                    }

            );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
