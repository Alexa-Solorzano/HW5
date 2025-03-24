/******************************************************************
 *
 *   Alexa Solorzano COMP 272 001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;
import java.util.HashSet;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The method will return TRUE if ALL THE ELEMENTS IN ARRAY B ARE FOUND IN ARRAY A
     * The method will return FALSE if ANY ELEMENT IN ARRAY B IS NOT FOUND IN ARRAY A
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     * Using a Hash Table is smart because it lets us do constant-time look-up O(1) thanks to the hashing function 
     * 
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     *
     * Pseudocode: 
     * Initialize HashSet to store all elements of array A
     * Add all elements of list1 (array A) into HashSet
     * Loop through list2 (array B) 
     * check if each element is in the HashSet 
     * If it is not found (the elements in array B is NOT found in array a), 
     * then we return false 
     * Otherwise, all elements in array B are also in array A,
     * then we return true 
     */

    public boolean isSubset(int list1[], int list2[]) {
        HashSet<Integer> baseSet = new HashSet<>(); //create a HashSet to store elements of list1

        //add all elements from list1 to the hashSet
        for(int i = 0; i < list1.length; i++){ //loop through each element of array A (list1)
            baseSet.add(list1[i]); //add each element of array A to the hashset
        }
        //check if all elements in list2 are present in baseSet 
        for(int i = 0; i < list2.length; i++){ //loop through each element of array B (list2)
            if(!baseSet.contains(list2[i])){ //if any element in array A does not contain an element in array B, then return false
                return false; 
            }
        }
        //if all elements of array B are found in array A, return true
        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * 1st step is to arrage Array A in descending order (from largest to smallest)
     * This would result in: [34, 10, 8, 7, 5, 3, 1]
     * 
     * The 2nd step is returning the k-th max. element in the array which will be k-1 (bc indices start at 0)
     * The integer k was 4 --> 4-1 = 3 and the third element of the array is 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        // ADD YOUR CODE HERE

        return 0;
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * This method 
     * 1) joins array A & B into a single array, 
     * 2) sorts the single array in ascending order (from smallest to largerst) 
     * 3) returns the sorted array
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {

        // ADD YOU CODE HERE

        return null;
    }

}
