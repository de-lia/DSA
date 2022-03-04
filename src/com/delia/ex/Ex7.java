package com.delia.ex;

import java.util.Scanner;

public class Ex7 {

    int numberArray[];
    int arrayLimit;

    public static void run(String[] args) {
        Ex7 findProductOfArrayDistinctElements = new Ex7();
        findProductOfArrayDistinctElements.initializeArray();
        System.out.println("Does the given array contain a pair of distinct elements whose product is even? " + findProductOfArrayDistinctElements.isEvenProduct());
    }

    public void initializeArray(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many numbers you want to store in an array");
        arrayLimit = scanner.nextInt();
        numberArray = new int[arrayLimit];
        for (int i = 0; i < numberArray.length; i++) {
            System.out.println("enter the number");
            numberArray[i] = scanner.nextInt();
        }
        scanner.close();
    }

    public boolean isEvenProduct(){
        boolean isEvenProduct = false;
        for (int i = 0; i < numberArray.length; i++) {
            for (int j = 1; j < numberArray.length; j++) {
                if(numberArray[i] != numberArray[j] && ((numberArray[i] * numberArray[j]) % 2 == 0)){
                    isEvenProduct = true;
                }
            }
        }
        return isEvenProduct;
    }


}
