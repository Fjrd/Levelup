package homework.lesson03.bubbleSort;

import java.util.Arrays;
import java.util.Random;

public class bubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[15];
        fillArrayWithRandomValues(arr);
        System.out.println("Generated unsorted array:");
        printArray(arr);
        sortArrayUsingBubbleSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }

    private static void fillArrayWithRandomValues(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 + new Random().nextInt(arr.length);
        }
    }

    private static void printArray(int arr[]) {
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArrayUsingBubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
