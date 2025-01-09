package searchalgos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterpolationSearchAlgorithm {
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
            
            int index = interpolationSearch(numbers, target);
            
            if (index != -1) {
                System.out.println("Target " + target + " found at index: " + index);
            } else {
                System.out.println("Target " + target + " not found in the array.");
            }
        } catch(IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        while(low <= high && target >= arr[low] && target <= arr[high]) {
            if(low == high) {
                if(arr[low] == target) return low;
                return -1;
            }
            // Estimate mid using interpolation formula
            int mid = low + (int)(((double)(high - low) / (arr[high] - arr[low])) * (target - arr[low]));
            if(arr[mid] == target)
                return mid;
            if(arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
