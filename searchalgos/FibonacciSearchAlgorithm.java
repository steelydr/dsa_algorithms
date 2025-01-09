package searchalgos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciSearchAlgorithm {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter sorted integers separated by spaces:");
            String numbersLine = reader.readLine();
            String[] numbersStr = numbersLine.trim().split("\\s+");
            int[] arr = new int[numbersStr.length];
            for(int i = 0; i < numbersStr.length; i++) {
                arr[i] = Integer.parseInt(numbersStr[i]);
            }
            
            System.out.println("Enter the target value:");
            int target = Integer.parseInt(reader.readLine().trim());
            
            int index = fibonacciSearch(arr, target);
            if(index != -1) {
                System.out.println("Target " + target + " found at index: " + index);
            } else {
                System.out.println("Target " + target + " not found in the array.");
            }
        } catch(IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public static int fibonacciSearch(int[] arr, int target) {
        int n = arr.length;
        
        // Initialize fibonacci numbers
        int fibMMm2 = 0; // (m-2)'th Fibonacci number
        int fibMMm1 = 1; // (m-1)'th Fibonacci number
        int fibM = fibMMm2 + fibMMm1; // m'th Fibonacci number
        
        // fibM is going to store the smallest Fibonacci number greater than or equal to n
        while(fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM  = fibMMm2 + fibMMm1;
        }
        
        int offset = -1;
        
        while(fibM > 1) {
            int i = Math.min(offset + fibMMm2, n - 1);
            if(arr[i] < target) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            } else if(arr[i] > target) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            } else {
                return i;
            }
        }
        
        if(fibMMm1 == 1 && offset + 1 < n && arr[offset + 1] == target)
            return offset + 1;
        
        return -1;
    }
}
