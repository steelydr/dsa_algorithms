import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JumpSearchAlgorithm {
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
            
            int index = jumpSearch(numbers, target);
            
            if(index != -1) {
                System.out.println("Target " + target + " found at index: " + index);
            } else {
                System.out.println("Target " + target + " not found in the array.");
            }
        } catch(IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int)Math.sqrt(n);
        int prev = 0;
        
        // Jump until the value at index is greater than or equal to target
        while(prev < n && arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int)Math.sqrt(n);
            if(prev >= n) return -1;
        }
        
        // Linear search within the block
        while(prev < Math.min(step, n)) {
            if(arr[prev] == target)
                return prev;
            prev++;
        }
        return -1;
    }
}
