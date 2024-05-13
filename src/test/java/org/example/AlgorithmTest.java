package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmTest {


   @Test
   void twoSum(){

       System.out.println(Arrays.toString(Algorithm.twoSum(new int[]{2, 7, 11, 15}, 9)));
       System.out.println(Arrays.toString(Algorithm.twoSum(new int[]{3, 2, 4}, 6)));
       System.out.println(Arrays.toString(Algorithm.twoSum(new int[]{3, 3}, 6)));
       System.out.println(Arrays.toString(Algorithm.twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
       System.out.println(Arrays.toString(Algorithm.twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
       System.out.println(Arrays.toString(Algorithm.twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
       System.out.println(Arrays.toString(Algorithm.twoSum(new int[]{}, 0)));
   }
    @Test
    void groupAnagrams()
    {
        String[] strings = {"listen", "silent", "triangle", "integral", "garden", "ranged"};

        List<List<String>> arr = Algorithm.groupAnagrams(strings);

        for (List<String> list : arr) {
            System.out.println(list);
        }
    }
    @Test
    void isBinaryTree() {
        //given
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        //when

        boolean result = Algorithm.isBinaryTree(root,-1, -1);
        //then
        assertTrue(result);
    }
    @Test
    void rotateInplace(){
        //given
        int[][] arr = { {1,2,3}, {4,5,6}, {7,8,9}};
        //when
        Algorithm.rotateInplace(arr);

        //then
        for (int i=0;i<3;i++){
            System.out.println();
            for (int j=0;j<3;j++){
                System.out.print(arr[i][j]+" ");
            }
        }
    }


    @Test
    void rotateV2(){
        //given
        int[][] arr = { {1,2,3}, {4,5,6}, {7,8,9}};
        //when
        int[][] result = Algorithm.rotateV2(arr);

        //then
        for (int i=0;i<3;i++){
            System.out.println();
            for (int j=0;j<3;j++){
                System.out.print(result[i][j]+" ");
            }
        }
    }

    @Test
  void rotate(){
      //given
      int[][] arr = { {1,2,3}, {4,5,6}, {7,8,9}};
      //when
      int[][] result = Algorithm.rotate(arr);

      //then
      for (int i=0;i<3;i++){
          System.out.println();
          for (int j=0;j<3;j++){
              System.out.print(result[i][j]+" ");
          }
      }
  }
   @Test
   void click(){
       //given
        int[][] arr = { {0,0,0,0,0}, {0,1,1,1,0}, {0,1,-1,1,0}};
       //when
       Algorithm.click(arr,0,1);

       //then
       for (int i=0;i<3;i++){
           System.out.println();
           for (int j=0;j<5;j++){
               System.out.print(arr[i][j]+" ");
           }
       }
   }
    @Test
    void assignNumbersInMinesweeper(){
        //given
        ArrayList<Algorithm.Cell> bombs = new ArrayList<>();
        bombs.add(new Algorithm.Cell(0,0));
        bombs.add(new Algorithm.Cell(0,1));

        //when
        int[][] result = Algorithm.assignNumbersInMinesweeper(bombs,3,4);

        //then
        for (int i=0;i<3;i++){
            System.out.println();
            for (int j=0;j<4;j++){
                System.out.print(result[i][j]+" ");
            }
        }
    }
    @Test
    void oneAwayString(){
        //given
        String s1 = "abcde";
        String s2 = "abde";

        //when
        boolean result = Algorithm.oneAwayString(s1,s2);

        //then
        assertTrue(result);
    }


    @Test
   void isOneArrayRotationOfAnother(){
       //given
       int[] arr1 = {1,2,3,5,7,9};
       int[] arr2 = {5,7,9,1,2};

       //when
       boolean result = Algorithm.isOneArrayRotationOfAnother(arr1, arr2);

       //then
       assertTrue(result);
   }
    @Test
    void commonElementsInTwoSortedArray()
    {
        //given
       int[] arr1 = {1,2,3,4,9,10};
       int[] arr2 = {4,5,6,7,8};

        //when
        ArrayList<Integer> result = Algorithm.commonElementsInTwoSortedArray(arr1,arr2);

        //then
        for (int value : result) System.out.println(value);
    }
    @Test
    void LCS(){
        //given
        String a = "abcde";
        String b = "cde";

        //when
        int count = Algorithm.LCS(a,b);

        //then
        assertEquals(3,count);

    }

    @Test
    void topKString()
    {
        //given
        String[] arr = {"ab", "abc", "abcd", "xyz", "b", "a", "a", "xyz", "xyz", "xyz", "b"};

        //when
        String[] result = Algorithm.topKString(arr,3);

        //then
        for (String s : result){
            System.out.println(s);
        }
    }

    @Test
    void topKquickort() {
        int[] arr = {1,2,7,3,4,6,8,0, 9, 5};
        Algorithm.topKquickort(arr,0,arr.length-1,3);
        for (int i: arr) System.out.println(i);
    }
    @Test
    void quicksort(){
       int[] arr = {1,2,7,3,4,6,8,0, 9, 5};
       Algorithm.quickort(arr,0,arr.length-1);

       for (int i: arr) System.out.println(i);
    }

}