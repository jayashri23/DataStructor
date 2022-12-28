package com.datastructor;

public class InsertionSort {
    public static void main(String[] args){
        System.out.println("Insertion Sort Implementation");
        String[] arr ={"Mumbai","Delhi","Ward","Chennai","Pune","Nagpur","Aurangabad","Beed"};
        String sortedArray[] = insertionSort(arr, arr.length);
        for(int i=0;i<sortedArray.length;i++){
            System.out.println(sortedArray[i]);
        }
    }

    public static String[] insertionSort(String array[], int f){
        String temp="";
        for(int i=0;i<f;i++){
            for(int j=i+1;j<f;j++){
                if(array[i].compareToIgnoreCase(array[j])>0){
                    temp = array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }
}
