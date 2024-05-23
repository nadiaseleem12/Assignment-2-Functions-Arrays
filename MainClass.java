package functionsAssignment;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        int [] arr = {5,5,0,0,0,1,1,3,4,4,4};
        System.out.println(getArraySum(arr));
        System.out.println(getNoOfElements(arr));
        System.out.println(getArrayMinElement(arr));
        System.out.println(getArrayMaxElement(arr));
        calculateEven(arr);
        countGeneral(arr);
        int [] sortedArr = {1,2,3,4,5,6,7};
        System.out.println("value is found at index: "+binarySearch(sortedArr,4));
        int [] array = {4,5,6,7,3,2,1};
        System.out.println(Arrays.toString(selectionSort(array)));


    }

    public static int getArraySum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int getNoOfElements(int[] arr) {
        return arr.length;
    }

    public static int getArrayMaxElement(int[] arr) {
        if (arr.length == 0)
            return -1;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }

    public static int getArrayMinElement(int[] arr) {
        if (arr.length == 0)
            return -1;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        return min;
    }

    public static void calculateEven(int[] arr) {
        int numOfEven = 0;
        int sumOfEven = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                numOfEven++;
                sumOfEven += arr[i];
            }
        }
        System.out.println("Sum of even numbers = " + sumOfEven);
        System.out.println("Number of even numbers = " + numOfEven);

    }

    public static void countGeneral(int[] arr) {
        if (arr.length == 0)
            return;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            if (!hashMap.containsKey(arr[i]))
                hashMap.put(arr[i], 1);
            else
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet())
            System.out.println(entry.getKey() + " -> " + entry.getValue());

    }

    public static int binarySearch(int[] arr, int value) {
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int med = (start + end) / 2;
            if (arr[med] == value) {
                return med;
            } else if (value > arr[med]) {
                start = med + 1;
            } else {
                end = med - 1;
            }
        }
        return -1;
    }

    public static int getMinValueIndex(int[] arr, int start) {
        if (arr.length == 0)
            return -1;
        int minIndex = start;
        for (int i = start; i < arr.length; i++)
            if (arr[minIndex] > arr[i])
                minIndex = i;
        return minIndex;
    }

    public static int[] selectionSort(int[] arr) {
        if (arr.length == 0)
            return null;

        for (int i = 0; i < arr.length; i++) {
            int minIndex = getMinValueIndex(arr, i);
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }


}
