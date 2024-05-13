package org.example;

import java.util.*;

public class Algorithm {

    private Node sortedArrayToBST(int[] nums, int left, int right) {

        if (left > right) return null;
        if (left == right) return new Node(nums[left]);

        if (nums == null) return null;
        if (nums.length == 1) return new Node(nums[0]);

        int mid = left + (right - left) /2;

        Node node = new Node(nums[mid]);
        node.left = sortedArrayToBST(nums,left,mid-1);
        node.right = sortedArrayToBST(nums, mid+1, right);
        return node;

    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void topKquickort(int[] list, int lowIndex, int highIndex,int k) {

        if (lowIndex >= highIndex) { return; }

        int pivot = list[highIndex];
        int left = lowIndex;
        int right = highIndex;

        //partition the list
        while (left <right) {
            while ((left < right) && (list[left] >= pivot)) {
                left++;
            }
            while ((left < right) && (list[right] <= pivot)) {
                right--;
            }
            if (left < right) {
                swap(list, left, right);
            }
        }
        swap(list, left, highIndex);

        if (left>k-1)
            quickort(list,lowIndex,left-1);
        else
            quickort(list,left+1,highIndex);

    }

    public static void quickort(int[] list, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) { return; }

        int pivot = list[highIndex];
        int left = lowIndex;
        int right = highIndex;

        //partition the list
        while (left <right) {
            while ((left < right) && (list[left] <= pivot)) {
                left++;
            }
            while ((left < right) && (list[right] >= pivot)) {
                right--;
            }
            if (left < right) {
                swap(list, left, right);
            }
        }
        swap(list, left, highIndex);

        quickort(list,lowIndex,left-1);
        quickort(list,left+1,highIndex);

    }

    public static int[] twoSum(int[] nums, int target){

        if (nums == null) return null;

        Map<Integer,Integer> map = new HashMap<>();
        int complement = 0;;

        for (int i=0;i<nums.length;i++) {

            if (map.get(nums[i]) != null) {
                return new int[]{map.get(nums[i]),i};
            }

            complement = target - nums[i];

            map.putIfAbsent(complement, i);


        }

        return new int[]{};
    }


    public static List<List<String>> groupAnagrams(String[] strings) {

        String hashKey = "";
        Map<String,List<String>> map = new HashMap<>();
        List<String> anagrams;

        for (String s : strings ) {

            //generate hask key for each string
            hashKey = generateHashkey(s);
            anagrams = map.get(hashKey);
            //add thta string into the hashmap
            if (anagrams != null) {
                anagrams.add(s);
                map.replace(hashKey,anagrams);
            }
            else {
                anagrams = new ArrayList<>();
                anagrams.add(s);
                map.put(hashKey,anagrams);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (String key : map.keySet()){
            result.add(map.get(key));
        }

        return result;
    }


    private static String generateHashkey(String s) {

        char[] arr = new char[26];
        for (char c: s.toCharArray()) {
            arr[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        char c='a';
        for (int i: arr) {
            sb.append(c);
            sb.append(i);
            ++c;
        }

        return sb.toString();
    }



    public static TreeNode lca(TreeNode n, int x, int y) {
        if (n == null) { return null;}
        if (n.val == x || n.val == y) { return n;}
        TreeNode left = lca(n.left, x, y);
        TreeNode right = lca(n.right, x, y);
        if (left == null && right == null) { return null;}
        if (left == null) { return right;}
        if (right == null) { return left;}
        return n;
    }
    public static boolean isBinaryTree(TreeNode root, int minVal, int maxVal) {
        if (root == null) {return true;}

        if (maxVal != -1) {
            if (root.val > maxVal) return false;
        }
        if (minVal != -1) {
            if (root.val < minVal) return false;
        }

        boolean left = true;
        boolean right = true;

        if (root.left != null) {
            if (root.val >= root.left.val) left = true; else left = false;

        }
        if (root.right != null) {

            if (root.val < root.right.val) right = true; else right = false;
        }
        return left && right && isBinaryTree(root.left,minVal,root.val) && isBinaryTree(root.right,root.val,maxVal);
    }



    public static class Cell {
        public int row;
        public int col;
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void rotateInplace(int[][] matrix) {

        for (int i = 0; i < matrix.length / 2; i++) {
            rotateOuterRingV2(matrix,i);
        }
    }

    private static void rotateOuterRingV2(int[][] matrix, int start) {

        int[] temp = new int[4];
        for (int i = start; i < matrix.length - 1 - start; i++) {
            temp[0] = matrix[start][i];
            temp[1] = matrix[start+i][matrix.length - 1 - start];
            temp[2] = matrix[matrix.length - 1-start][matrix.length - 1-i];
            temp[3] = matrix[matrix.length - 1-start -i][start];

            matrix[start+i][matrix.length - 1 - start] = temp[0];
            matrix[matrix.length - 1-start][matrix.length - 1-i] = temp[1];
            matrix[matrix.length - 1-start -i][start] = temp[2];
            matrix[start][i] = temp[3];
        }
    }


    public static int[][] rotateV2(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        int newRow = -1;
        int newCol = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                //new row
                newRow = j;
                //new column
                newCol = matrix.length - 1 - i;

                //set result
                result[newRow][newCol] = matrix[i][j];
            }
        }
        return result;
    }

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n / 2; i++) {
            rotateOuterRing(matrix,result,i);
        }
        result[n/2][n/2] = matrix[n/2][n/2];

       return result;

    }

    private static void rotateOuterRing(int[][] matrix, int[][] result, int start) {

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int length = rowLen - start;
        int row;
        int col;


        //rotate right - row becomes column
        row = start;
        col = start;
        for (int i = 0; i < length; i++) {
            result[start+i][start + length - 1] = matrix[row][col+i];
        }

       //rotate down - column becomes row
        row = start;
        col = start+length - 1;
        for (int i = 0; i < length; i++) {
            result[start+length-1][start+length - 1 -i] = matrix[row+i][col];
        }
        //rotate left - rows become columns
        row = start+length - 1;;
        col = start;
        for (int i = 0; i < length; i++) {
            result[start+i][start] = matrix[row][col+i];
        }

        //rotate up - column become row
        row = start;;
        col = start;
        for (int i = 0; i < length; i++) {
            result[start][start + length -1 -i] = matrix[row+i][col];
        }
    }

    public static void click(int[][] field, int row, int col) {

        ArrayList<Cell> list = getAdjCells(field,row,col);
        clickRecursive(field,list);
    }

    private static void clickRecursive(int[][] field, ArrayList<Cell> list) {

        if (list.isEmpty()) return;
        //BFS
        Cell cell = list.removeFirst();
        field[cell.row][cell.col] = -2;
        ArrayList<Cell> tempList = getAdjCells(field,cell.row,cell.col);
        for (Cell c : tempList) {
            if (field[c.row][c.col] == 0) {
                list.add(new Cell(c.row,c.col));
            }
        }
        clickRecursive(field,list);
    }

    private static ArrayList<Cell> getAdjCells(int[][] arr, int row, int col) {
        ArrayList<Cell> list = new ArrayList<>();
        int rowleft = row - 1;
        int rowright = row + 1;
        int colleft = col - 1;
        int colright = col + 1;

        //check for boundaries
        if (rowleft < 0) rowleft = 0;
        if (rowright > arr.length - 1) rowright = arr.length - 1;
        if (colleft < 0) colleft = 0;
        if (colright > arr[0].length - 1) colright = arr[0].length - 1;

        for (int i = rowleft; i <= rowright; i++) {
            for (int j = colleft; j <= colright; j++) {
                if (arr[i][j] == 0) {
                    list.add(new Cell(i, j));
                }
            }
        }
        return list;
    }

    public static int[][] assignNumbersInMinesweeper(ArrayList<Cell> bombs, int numRows, int numColumns){

        int[][] grid = new int[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                grid[i][j] = 0;
            }
        }

        //update bomb cells
        for (Cell c : bombs ) {
            grid[c.row][c.col] = -1;
        }
        //update cell with bomb count
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                int count = 0;
                if (grid[i][j] != -1) {
                    if (j+1 < numColumns) {
                        if (grid[i][j+1] == -1) count++;
                    }
                    if (j-1 >= 0) {
                        if (grid[i][j-1] == -1) count++;
                    }
                    if (i+1 < numRows) {
                        if (grid[i+1][j] == -1) count++;
                    }
                    if ((i+1 < numRows) && (j-1 >=0)) {
                        if (grid[i+1][j-1] == -1) count++;
                    }
                    if ((i+1 < numRows) && (j+1< numColumns)) {
                        if (grid[i+1][j+1] == -1) count++;
                    }
                    if (i-1 > 0) {
                        if (grid[i-1][j] == -1) count++;
                    }
                    if ((i-1 > 0) && (j-1>0)){
                        if (grid[i-1][j-1] == -1) count++;
                    }
                    if ((i-1 > 0) && (j+1<numColumns)){
                        if (grid[i-1][j+1] == -1) count++;
                    }

                    grid[i][j] = count;
                }
            }
        }
        return grid;

    }
    //one edit away string
    public static boolean oneAwayString(String s1, String s2) {

        int length1 =  s1.length();
        int length2 = s2.length();

        if ((length1 - length2 >= 2) || ((length2 - length1) >= 2)) return  false;

        else if (length1 == length2) //update
        {
            int counter = 0;
            for (int i = 0; i < length1; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    counter++;
                }
            }
            return counter <= 1;
        }
        else if (length1 > length2) //delete
        {
            int counter = 0;
            for (int i = 0; i < length1; i++) {
                int j= i-counter;
                if (j < length2) {
                    if (s1.charAt(i) != s2.charAt(j)) {
                        counter++;
                    }
                }
                else counter++;

            }
            return counter <= 1;
        }
        else { //insert
            int counter = 0;
            for (int i = 0; i < length2; i++) {
                int j= i-counter;
                if (j < length1) {
                    if (s2.charAt(i) != s1.charAt(j)) {
                        counter++;
                    }
                }
                else counter++;

            }
            return counter <= 1;
        }
    }

    //array rotation
    public static boolean isOneArrayRotationOfAnother(int[] arr1, int[] arr2)
    {

        int index = -1;
        int j=0;

         if (arr1.length != arr2.length) return false;
         //check first element of array 1 with matching element in array 2
         for (int k = 0; k < arr2.length; k++)
         {
             if (arr1[0] == arr2[k])
             {
                 index=k;
                 break;
             }
         }
         if (index == -1) return false; //elements dont match

        //validate for rotation
         for (int k = 0; k < arr1.length; k++){
             j = (index + k) % arr2.length;
             if (arr1[k] != arr2[j]) return false;
         }
         return true;

    }
    public static ArrayList<Integer> commonElementsInTwoSortedArray(int[] arr1, int[] arr2)
    {
        int sizeofarray1 = arr1.length;
        int sizeofarray2 = arr2.length;
        int i=0;
        int j=0;
        ArrayList<Integer> list1 = new ArrayList<>();

        while (i < sizeofarray1 && j < sizeofarray2) {
            if (arr1[i] == arr2[j]) {//common element
                list1.add(arr1[i]);
                i++;
                j++;
            }
            else if (arr1[i] < arr2[j]) {
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                j++;
            }
        }
      return list1;
    }
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
