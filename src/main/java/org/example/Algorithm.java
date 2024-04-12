package org.example;

public class Algorithm {

//longest common sequence
    public static int LCS(String str1, String str2) {
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        return LCSRecursion(a, b,0,0);
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
