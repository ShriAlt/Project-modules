package com.xworkz.test.runner;

import java.util.HashSet;

public class MainRunner {

    public static String hasPair(int[] arr, int tar){
//        for(int i =0; i < arr.length; i++){
//            for(int j=i+1; j < arr.length; j++){
//                if(arr[i] + arr[j] == tar){
//                    return "yes";
//                }
//            }
//        }
//        return "No";

        HashSet<Integer> integers = new HashSet<>();
        for(int num : arr){
            int com = tar - num;

            if(integers.contains(com)){
                return "yes";
            }
            integers.add(num);
        }
        return "No";
    }
    public static void main(String[] args) {
// Array: [3, 5, 1, 7, 9], Target: 10
        int arr[] = {3,5,1,7,9};
        int tar = 10;
        System.out.println(hasPair(arr,tar));
    }
}
