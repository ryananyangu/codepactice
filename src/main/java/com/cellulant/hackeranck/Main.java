/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellulant.hackeranck;


import java.util.Arrays;


/**
 *
 * @author ranyangu
 */
public class Main {

    static void KCBQ1(int[] a){

        Arrays.sort(a);

        int previous = 0;

        for (int i=0;i < a.length; i++){
            if(a[i] == previous){
                // previous = a[i];
                continue;
            }
            previous = a[i];
            System.out.println(a[i]); 
        }

    }

    public static void main(String[] args) {

        // int[] h1 = { 3, 2, 1, 1, 1 };
        // int[] h2 = { 4, 3, 2 };
        // int[] h3 = { 1, 1, 4, 1 };
        // int result = Main.equalStacks(h1, h2, h3);
        int[] a = {1, 12, 7, 3, 6, 9, 7, 15, 1, 8, 4, 3, 9, 4, 5};
        KCBQ1(a);
    }
}
