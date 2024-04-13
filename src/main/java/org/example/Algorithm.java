package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Algorithm {

//longest common sequence
    public static int LCS(String str1, String str2) {
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        return LCSRecursion(a, b,0,0);
    }

    public static String[] topKString(String[] arr,int k){
        Map<String,Integer> map = new HashMap();
        for (String s: arr) {
            if (map.get(s) == null){
                map.put(s,1);
            }
            else {
                int count = map.get(s);
                map.replace(s,count+1);
            }
        }
        //put these keys into a heap(priority queue) descending order
        PriorityQueue<String> pq = new PriorityQueue<String>(
                (a,b) -> { //b element is being added to the queue
                    if (map.get(a) == map.get(b)) {
                        return a.compareTo(b);
                    }
                    else return map.get(b) - map.get(a);

                }
        );
        for (String s:map.keySet()){
            pq.add(s);
        }

        //get top K elements from the heap and return
        String[] result = new String[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    private static int LCSRecursion(char[] a, char[] b, int i, int j) {
        if (i == a.length || j == b.length) { //end of string
            return 0;
        }
        else if (a[i] == b[j]) { //match found
            return 1 + LCSRecursion(a, b, i + 1, j + 1);
        }
        else { //no match
            return Integer.max(LCSRecursion(a, b,i+1, j), LCSRecursion(a,b,i,j+1));
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
