package org.example;

import java.util.ArrayList;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        HashMap<Integer,String> myTable = new HashMap<>();
        myTable.put(1, "pj");
        myTable.put(2, "bobby");
        myTable.put(3, "juhe");
        myTable.put(4, "reteka");
        for (String s : myTable.values()) {
            System.out.println(s);
        }
         */
        for (int i=0; i<10; i++) {
            System.out.println(fibonacci(i));
        }

    }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        int prev = 0;
        int current = 1;
        for (int i=2; i<=n; i++)
        {
            int temp = prev + current;
            prev = current;
            current = temp;
        }
        return current;
    }
}