package com.example;

/**
 * Created by Administrator on 2016/5/19.
 */
public class TestMain {
    public static void main(String[] args) {
        method();
    }

    static void method() {
        int[] a = {};
        try {
            a[0] = a[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(2);
        } finally {
            {
                try {
                    throw new MyExce();
                } catch (MyExce e) {
                    System.out.println(7);
                }
            }
        }
    }


    static class MyExce extends Exception {
        public MyExce() {
            System.out.println(4);
        }
    }
}
