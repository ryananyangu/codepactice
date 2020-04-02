/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cellulant.hackeranck;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 *
 * @author ranyangu
 */
public class Main {

    static int formingMagicSquare(int[][] s) {
        for (int[] row : s) {
            int[] available_digits = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            Arrays.sort(row);
            int row_sum = row[0] + row[1] + row[2];

            if (row_sum == 15) {
                for (int i_row = 0; i_row < row.length; ++row_sum) {
                    IntStream.range(0, available_digits.length).filter(i -> i != i_row).map(i -> available_digits[i])
                            .toArray();
                }

                // pop the values
            } else {
                // make sure the sumation of larget and extra is less than 9
                // addition amount and pop
            }

        }
        return 1;
    }

    public static int getUmbrellas(int people, List<Integer> sizes) {
        Collections.sort(sizes);
        int len = sizes.size() - 1;
        int total_umbrellas_used = 0;
        int unallocated_people = people;

        // Part of best case
        for (int i = 0; i <= len; i++) {
            unallocated_people = people % sizes.get(len - i);
            if (unallocated_people == 0) {
                total_umbrellas_used = people / sizes.get(len - i);
                return total_umbrellas_used;
            }
        }

        // worst case
        for (int i = 0; i < len; i++) {
            unallocated_people = unallocated_people % sizes.get(len - i);
            total_umbrellas_used += unallocated_people / sizes.get(len - i);
            if (unallocated_people == 0) {
                return total_umbrellas_used;
            }
        }
        return -1;
    }

    public static List<Integer> arrayAdd(List<Integer> a, List<Integer> b) {
        int asum = 0;
        int bsum = 0;

        List<Integer> output = new LinkedList<>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == b.get(i)) {
            } else {
                if (a.get(i) > b.get(i)) {
                    asum += 1;
                    // continue;
                } else {
                    bsum += 1;
                }

            }
        }

        output.add(asum);
        output.add(bsum);

        return output;
    }

    static long aVeryBigSum(long[] ar) {
        long sum = 0;
        for (long item : ar) {
            sum = Long.sum(sum, item);
        }
        return sum;
        // return ar.stream().mapToInt(Long::intValue).sum();
    }

    static String repeat(int times, String with) {
        return new String(new char[times]).replace("\0", with);
    }

    static void staircase2(int n) { // Java 10 and below
        String space = " ";
        String edge = "#";
        for (int i = 1; i <= n; i++) {
            String s_space = repeat(n - i, space);
            String s_edge = repeat(i, edge);
            System.out.println(s_space + s_edge);
        }
    }

    static void staircase(int n) { // Java 11 and above
        String space = " ";
        String edge = "#";
        for (int i = 0; i <= n; i++) {
            String s_space = space.repeat(n - i);
            String s_edge = edge.repeat(i);
            System.out.println(s_space + s_edge);
        }
    }

    static void plusMinus(int[] arr) {
        int positive_count = 0;
        int zero_count = 0;
        int negative_count = 0;

        int size = arr.length;

        for (int i : arr) {
            if (i > 0) {
                positive_count++;
            } else if (i < 0) {
                negative_count++;
            } else {
                zero_count++;
            }
        }

        System.out.println((double) positive_count / size);
        System.out.println((double) negative_count / size);
        System.out.println((double) zero_count / size);

    }

    static int sockMerchant(int n, int[] ar) {
        Arrays.sort(ar);
        // int mini_count = 0;
        int main_count = 0;
        n -= 1;
        for (int x = 0; x < n; x++) {
            if (ar[x] == ar[x + 1]) {
                main_count++;
                x++;
            }
        }
        return main_count;
    }

    static int countingValleys(int n, String s) {
        char[] ch = s.toCharArray();

        int alt = 0;
        int valley_count = 0;
        for (char c : ch) {
            if (c == 'D') {
                alt -= 1;
                continue;
            } else {
                alt += 1;
            }

            if (alt == 0) {
                valley_count++;
            }
        }

        return valley_count;

    }

    static int birthdayCakeCandles(int[] ar) {
        Arrays.sort(ar); // get all the highest
        int size = ar.length - 1;
        int current_high = 0;
        int result = 0;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                current_high = ar[size];
                result++;
                continue; // set the first highest value to compare
            }
            if (current_high == ar[size - i]) {
                result++; // Increment the same highest occurance
            } else {
                break; // Total highest found break out of the loop
            }

        }
        return result;
    }

    static void miniMaxSum(int[] arr) {
        int size = arr.length;
        Arrays.sort(arr);

        long max_sum = 0;
        long min_sum = 0;
        for (int i = 1; i < size; i++) {
            max_sum += arr[size - i];
            min_sum += arr[i - 1];

        }
        System.out.println(min_sum + " " + max_sum);
    }

    static int jumpingOnClouds(int[] c) {

        int clouds_hoped = 0;
        for (int i = 0; i < c.length; i++) {
            if (i == 0) {
                System.out.println("Hoped on cloud : " + i);
                clouds_hoped++;
                continue;
            }
            if (c[i] == 0) {
                if (i + 2 >= c.length) {
                    continue;
                }
                if (c[i + 1] == 0 && c[i + 2] == 0) {
                    i += 2;
                    clouds_hoped++;
                    System.out.println("Hoped on cloud : " + i);
                    continue;
                }
            }

            if (c[i] == 0 && c[i + 1] == 1) {
                clouds_hoped++;
                System.out.println("Hoped on cloud : " + i);
                continue;
            }
            if (c[i] == 1 && c[i + 1] == 0) {
                i += 1;
                clouds_hoped++;
                System.out.println("Hoped on cloud : " + i);
            }

        }

        return clouds_hoped;

    }

    static long repeatedString(String s, long n) {

        char[] sc = s.toCharArray();

        int size = sc.length;

        int a_count = 0;

        int a_sub_count = 0;

        long remainder = n % size;

        long divisible = n / size;

        if (remainder > 0) {
            char[] rem = Arrays.copyOfRange(sc, 0, (int) remainder);
            // System.out.println("Test : "+rem.toString());
            for (char ch : rem) {
                if (ch == 'a') {
                    a_sub_count++;
                }
            }
        }

        for (char c : sc) {
            if (c == 'a') {
                a_count++;
            }
        }

        long first_count = a_count * divisible;
        return first_count + a_sub_count;
    }

    public static int Solution(int[] A) {

        Arrays.sort(A);
        int len = A.length;
        if (A[len - 1] < 0) {
            return 1;
        }
        int firstvalue = A[0];
        for (int i : A) {
            if (i == firstvalue - 1) {
                continue;
            }
            if (i != firstvalue) {
                return firstvalue;
            }
            firstvalue += 1;

        }

        return firstvalue;
    }

    public static int Solution2(int n) {
        String strNo = n + "";
        String zero_string = "000000000";
        char[] number = strNo.toCharArray();
        if (number.length == 1) {
            return 0;
        }
        String result = "1" + zero_string.substring(1, number.length);
        return Integer.parseInt(result);
    }

    public static int Solution3(String s) {
        // int base_ten = Integer.parseInt(s, 2);
        long base_ten = new BigInteger(s, 2).longValue();
        int count = 0;
        while (base_ten != 0) {
            count++;
            if (base_ten % 2 == 0) {
                base_ten = base_ten / 2;
            } else {
                base_ten -= 1;
            }
        }
        return count;
    }

    public static int Solution4(int[] A) {

        HashMap<Integer, Integer> common = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (common.containsKey(A[i])) {
                Integer tmp = common.get(A[i]) + 1;
                common.put(A[i], tmp);
            } else {
                common.put(A[i], 1);
            }
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> it : common.entrySet()) {
            int count = it.getValue();
            ans += (count * (count - 1) / 2);

        }

        return ans;
    }

    public static void LeftRotation(int[] a, int d, int n) {
        int c, q;

        q = n % d;

        String result = "";

        if (q == 0) {
            c = n / d;
        } else {
            c = (n / d) + 1;
        }

        while (c > 0) {
            q = n % d;
            // System.out.println(q);
            System.out.println(c);
            if (q == 0) {
                n -= d;
                int[] sub = Arrays.copyOfRange(a, n, n + d);
                // int[] sub = IntStream.range(n, n+d).map(i -> a[i]).toArray();
                result += Arrays.toString(sub);
                System.out.println(result);
                n -= d;
                c--;
            } else {
                n -= q;
                int[] sub = Arrays.copyOfRange(a, n, n + q);
                // int[] sub = IntStream.range(n, n+q).map(i -> a[i]).toArray();
                result += Arrays.toString(sub);
                System.out.println(result);
                c--;
            }

        }

        System.out.println(result);

    }

    static int compare(int[] arr, int[] arr2) {
        int sum1 = Arrays.stream(arr).sum();
        int sum2 = Arrays.stream(arr2).sum();
        
        Arrays.asList(arr2);
        if (sum1 != sum2) {
            if (sum1 < sum2) {
                arr2 = Arrays.copyOfRange(arr2, 1, arr2.length);
            } else {
                arr = Arrays.copyOfRange(arr, 1, arr.length);
            }
            return compare(arr, arr2);

        } else {
            return sum1;
        }

    }

    static int equalStacks(int[] h1, int[] h2, int[] h3) {

        /*
         * Write your code here.
         */



        int compare1 = compare(h1, h2);
        int compare2 = compare(h2, h3);
        if(compare1 != compare2){
            if(compare1 > compare2){

            }else{

            }
            return 0;
        }else{
            return compare1;
        }

    }

    public static void main(String[] args) {

        int[] h1 = { 3, 2, 1, 1, 1 };
        int[] h2 = { 4, 3, 2 };
        int[] h3 = { 1, 1, 4, 1 };
        int result = Main.equalStacks(h1, h2, h3);
        System.out.println(result);

    }
}
