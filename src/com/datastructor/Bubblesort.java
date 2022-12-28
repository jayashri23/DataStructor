package com.datastructor;

public class Bubblesort {
    static void bubbleSort(int array[]) {
        int len = array.length; // calculating the length of array
        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - i - 1; j++)
                if (array[j] > array[j + 1]) //comparing the pair of elements
                {
                    // swapping a[j+1] and a[i]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }
    static void printArray(int array[]) {
        int len = array.length;
        for (int i = 0; i < len; i++)
            System.out.print(array[i] + " "); //printing the sorted array

        System.out.println();
    }

    public static void main(String args[]) {
        System.out.println("Bubble Sort Implementation");
        int arr[] = {55, 34, 20, 32, 22, 90, 11};
        bubbleSort(arr);//calling the bubbleSort function
        System.out.println("Sorted array");
        printArray(arr); //calling the printArray function
    }
}
