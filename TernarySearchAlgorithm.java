import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TernarySearchAlgorithm {
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
            
            int index = ternarySearch(arr, 0, arr.length - 1, target);
            if(index != -1) {
                System.out.println("Target " + target + " found at index: " + index);
            } else {
                System.out.println("Target " + target + " not found in the array.");
            }
        } catch(IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public static int ternarySearch(int[] arr, int left, int right, int target) {
        if(right < left) return -1;
        
        int third = (right - left) / 3;
        int mid1 = left + third;
        int mid2 = right - third;
        
        if(arr[mid1] == target) return mid1;
        if(arr[mid2] == target) return mid2;
        
        if(target < arr[mid1])
            return ternarySearch(arr, left, mid1 - 1, target);
        else if(target > arr[mid2])
            return ternarySearch(arr, mid2 + 1, right, target);
        else
            return ternarySearch(arr, mid1 + 1, mid2 - 1, target);
    }
}
