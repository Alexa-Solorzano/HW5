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
import java.util.PriorityQueue;

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
     *
     * As we learned in class, most Priority Queues are implemented as min-heap, where where smaller numbers represent higher prirorities
     * The root of a min-heap is always the smallest element in the heap. 
     * When you remove the root --> through .poll(), you are removing the smallest element. 
     * To find the k-th largest element, we maintain a min-heap of size k.
     * After adding all the elements, the root of the min-heap will contain the k-th largest element, since the heap will contain the k largest elements & the smallest one of them will be at the root.
     *
     * Pseudocode: 
     * Initialize a new minHeap with the size of k
     * 
     * for each element in the array{
     * add the element into the minHeap
     *
     * In order to maintain the heap size we have to check the size of the heap:
     * if the size of the minHeap exceeds k
     * remove the smallest element (.poll()) to ensure the heap only contains the largest k elements
     *
     * After it process all the array elements, the root of the minHeap will be the k-th largest element 
     */

    public int findKthLargest(int[] array, int k) {
        //initialize minHeap to store the k largest elements 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        //iterate over the array
        for(int i = 0; i < array.length; i++){
            minHeap.add(array[i]); //add the current element into the heap
            //if the heap size exceeds k,
            if(minHeap.size() > k) {
                minHeap.poll(); //remove the smallest element 
            }
        }

        return minHeap.peek(); //return the root of the minheap 
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
     *
     * Using the same logic as findKthLargest method, 
     * Pseudocode:
     * Initialize a new minHeap to store elements of both arrays in ascending order
     * Add elements from array 1 to minheap
     * Add elements from array 2 to minheap
     * Initialize empty array which will hold the sorted combined arrays
     * 
     * while the minheap is not empty, 
     * poll the smallest element from the min-heap
     * add the smallest element to sorted array
     * 
     * return sorted array 
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < array1.length; i++)(
            minHeap.add(array1[i]);
        }
    
        for(int i = 0; i < array2.length; i++){
            minHeap.add(array2[i]);
        }

        int[] sortedArray = new int[array1.length + array2.length];
        int index = 0; 

        while(!minHeap.isEmpty()){ //while the min-Heap is NOT EMPTY
            sortedArray[index++] = minHeap.poll(); //poll the smallest element from the min-heap & add the smallest element to sortedArray
        } //the order in which we remove the smallest element of the min-heap and add onto the array will ensure the array is in sorted order (smallest to largest)

        return sortedArray;
    }

}
