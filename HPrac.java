/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hprac;

import java.util.Scanner;

/**
 *
 * @author Faisal
 */
public class HPrac {

    /**
     * @param args the command line arguments
     */
    public static int[] toCut = new int[1000];
    public static int finalIndex = 0;
    static int[] cutTheSticks(int[] arr) {
        int shortestNum = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                shortestNum = arr[i];
                index = i;
                break;
            }
        }
        //int i = 0;
        
        int sum = 0;
        int sum2 = 0;
        for (int j = index+1; j < arr.length; j++) {
            if (arr[j] != 0 && arr[j] < shortestNum) {
                shortestNum = arr[j];
            }
        }
        System.out.println("Shortest: "+shortestNum);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                sum2++;
            }
        }
        System.out.println("Length to cut: " +sum2);
        toCut[finalIndex] = sum2;
        finalIndex++;
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] >= shortestNum) {
                arr[k] = arr[k] - shortestNum;
            }
            
        }
        System.out.println("now the array looks like: ");
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]+" ");
            sum = sum + arr[k];
        }
        System.out.println();
        if (sum != 0) {
            cutTheSticks(arr);
        }
        //toCut[finalIndex] = 0;
        //System.out.println(toCut[finalIndex]);
        
        return toCut;

    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
         int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];
        

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] result = cutTheSticks(arr);
        
        for (int i = 0; i < finalIndex; i++) {
            System.out.println(result[i]);

            if (i != finalIndex) {
                System.out.println();
            }
        }

        

        scanner.close();
    }
    
}
