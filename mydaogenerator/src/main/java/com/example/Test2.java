package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2016/6/28.
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println("Hello World::"+names.toString());
     /*   Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });*/

        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        System.out.println("Hello ::"+names.toString());
    }
}
