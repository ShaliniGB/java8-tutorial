package com.winterbe.java8.samples.Shal_java_8_demos.Lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LamdaDemo {
    public static void main(String[] args){
        FileFilter fileFilter=new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".java");
            }
        };

        File files= new File("D:\\IntelliJ\\java8-tutorial\\src\\com\\winterbe\\java8\\samples\\Shal_java_8_demos\\Java8DateTime");
        File[] f= files.listFiles(fileFilter);
        for(File fi:f){
            System.out.println(fi);
        }
    //Using Lamda Expression
        FileFilter fileFilter2 =(File file)->
                file.getName().endsWith(".java");


        File[] fL= files.listFiles(fileFilter2);
        for(File fi:fL){
            System.out.println(fi);
        }

        Runnable runnable=() ->{
            for(int i=0; i<3;i++){
                System.out.println(Thread.currentThread().getName());
            }
        };

        Thread t= new Thread(runnable);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Comparator<String> comparator = (s1,s2) -> {
            return Integer.compare(s1.length(), s2.length());
        };

        List<String> stars= Arrays.asList("***","*","**","****","****");
        Collections.sort(stars, comparator);

        for(String s:stars){
            System.out.println(s);
        }
    }
}
