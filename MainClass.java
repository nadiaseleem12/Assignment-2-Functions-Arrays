package functionsAssignment;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3};
        System.out.println(getSummation(arr));
        System.out.println(getNumOfElements(arr));
        System.out.println(getMax(arr));
        System.out.println(getMin(arr));
        calculateEven(arr);
        System.out.println(count2(arr));

        countGeneral3(arr);
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("value is found at index: " + binarySearch(sortedArr, 4));
        int[] array = {4, 5, 6, 7, 3, 2, 1};
        selectionSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static int getSummation(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int getNumOfElements(int[] arr) {
        if (arr == null)
            return -1;
        return arr.length;
    }

    public static int getMax(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }

    public static int getMin(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        int min = arr[0];
        for (int num : arr)
            if (min > num)
                min = num;

        return min;
    }

    public static void calculateEven(int[] arr) {
        int numOfEven = 0;
        int sumOfEven = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] % 2 == 0) {
                numOfEven++;
                sumOfEven += arr[i];
            }
        System.out.println("Sum of even numbers = " + sumOfEven);
        System.out.println("Number of even numbers = " + numOfEven);
    }

    public static int count2(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        int count = 0;
        for (int num : arr) {
            if (num == 2)
                count++;
        }

        return count;
    }
    //1,2,3,1,2,3
    //1.sorting: 1,1,2,2,3,3
    //2.count adjacent equal numbers until a difference
    //if found a difference make a new count

    public static void countGeneral(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        Arrays.sort(arr);
        int number = arr[0];
        int count = 0;

        for (int i = 0; i < arr.length; i++)
            if (number == arr[i])
                count++;
            else {
                System.out.println(number + " -> " + count);
                number = arr[i];
                count = 1;
            }

        System.out.println(number + " -> " + count);

    }
    //1,     2,    3,     1,    2,   3,   1
    //false,false,false,true,true,true,true

    public static void countGeneral1(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        boolean[] alreadyCountedArray = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                    alreadyCountedArray[j] = true;
                }
            }
            if (!alreadyCountedArray[i])
                System.out.println(arr[i] + " -> " + count);

        }

    }

    public static void countGeneral2(int[] arr) {
        if (arr == null || arr.length == 0)
            return;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : arr)
            if (!hashMap.containsKey(num))
                hashMap.put(num, 1);
            else
                hashMap.put(num, hashMap.get(num) + 1);

        for (int key : hashMap.keySet())
            System.out.println(key + " ->" + hashMap.get(key));

//        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet())
//            System.out.println(entry.getKey() + " -> " + entry.getValue());

    }

    public static void countGeneral3(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
//        int[] uniqueArr = Arrays.stream(arr).distinct().toArray();
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        System.out.println(set);
        Integer[] uniqueArr = set.toArray(new Integer[0]);

        for (int i = 0; i < uniqueArr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++)
                if (uniqueArr[i] == arr[j])
                    count++;
            System.out.println(uniqueArr[i] + " -> " + count);
        }

    }


    public static void selectionSort(int[] arr) {
        if (arr == null)
            return;

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j])
                    minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static int[] selectionSort2(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        for (int i = 0; i < arr.length; i++) {
            int minIndex = getMinValueIndex(arr, i);
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
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


    public static int binarySearch(int[] arr, int value) {
        if (arr == null || arr.length == 0)
            return -1;

        Arrays.sort(arr);

        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int med = (low + high) / 2;
            if (arr[med] == value)
                return med;
            else if (arr[med] > value)
                high = med - 1;
            else
                low = med + 1;
        }

        return -1;
    }

}
