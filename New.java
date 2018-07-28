/*
 Question. Sum Find:
 Given an array of integers A and an integer X, find a pair of elements in A whose sum is X. That is,
 Write a function:
 (int, int) solution (int[] A, int X)
 which, given an array of integers A and an integer X, returns the indices (i,j) of a pair of elements such that A[i] + A[j] == X, or (-1, -1) if no such pair exists.
 Examples:
 solution([7, 3, -1, 1], 6) returns (0, 2) solution([7, 3, -1, 1], 12) returns (-1, -1)
 Please give the time complexity of your solution.
 */

import java.util.*;

public class New{

    public static void main(String args[]){

        int[] arr = { 7, 3, -1, 1 };
        int sum = 6;

       int []i= pairsCount(arr, sum);
       printpairs(arr, sum);
       System.out.println(Arrays.toString(i));

    }

    //Time complixty O(n)

    public static int[] pairsCount(int[] arr, int sum)
    {

        // Notes: HashMap Key have to be Unique
        // HashMap can allow one null key + multiple null values
         HashMap <Integer,Integer> h = new HashMap<Integer,Integer>();

          // Adding values to HashMap as ("keys", "values")
          // Key will contain Array values and values will contain array index
         for(int i = 0; i < arr.length; i++){
            h.put(arr[i],i);
         }

        for(int i = 0; i < arr.length; i++){

            int temp=sum-arr[i];

            if(h.containsKey(temp)){
            // Accessing the contents of HashMap through Keys by get() method
            return new int[] {h.get(arr[i]), h.get(temp)};

            }

        }

        return new int[] {-1,-1};
    }


      //Time complixty O(n)
      static void printpairs(int arr[],int sum){

        //Note: HashSet allows only one null key
        // In HashSet Duplicates are not allowed
        // In the case of HashSet, the item isn't inserted.

        HashSet<Integer> s = new HashSet<Integer>();
        for (int i=0; i<arr.length; ++i){

            int temp = sum-arr[i];

            // checking for condition
            if (temp>=0 && s.contains(temp))
            {
                System.out.println("Pair with given sum " +
                                    sum + " is (" + arr[i] +
                                    ", "+temp+")");
            }
            s.add(arr[i]);
        }
      }
}
