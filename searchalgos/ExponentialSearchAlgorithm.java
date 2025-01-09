package searchalgos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExponentialSearchAlgorithm {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter sorted integers separated by spaces:");
            String numbersLine = reader.readLine();
            String[] numbersStr = numbersLine.trim().split("\\s+");
            int[] numbers = new int[numbersStr.length];
            for (int i = 0; i < numbersStr.length; i++) {
                numbers[i] = Integer.parseInt(numbersStr[i]);
            }
            
            System.out.println("Enter the target value:");
            int target = Integer.parseInt(reader.readLine().trim());
            
            int index = exponentialSearch(numbers, target);
            
            if(index != -1) {
                System.out.println("Target " + target + " found at index: " + index);
            } else {
                System.out.println("Target " + target + " not found in the array.");
            }
        } catch(IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;
        if(n == 0) return -1;
        if(arr[0] == target) return 0;
        
        int bound = 1;
        while(bound < n && arr[bound] < target) {
            bound *= 2;
        }
        
        // Use binary search for the found range
        int low = bound / 2;
        int high = Math.min(bound, n - 1);
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) return mid;
            if(arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
