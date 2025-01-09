import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SentinelSearchAlgorithm {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter integers separated by spaces:");
            String numbersLine = reader.readLine();
            String[] numbersStr = numbersLine.trim().split("\\s+");
            int n = numbersStr.length;
            int[] numbers = new int[n + 1]; 
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(numbersStr[i]);
            }
            
            System.out.println("Enter the target value:");
            int target = Integer.parseInt(reader.readLine().trim());
            
            int index = sentinelSearch(numbers, n, target);
            
            if (index != -1) {
                System.out.println("Target " + target + " found at index: " + index);
            } else {
                System.out.println("Target " + target + " not found in the array.");
            }
        } catch (IOException e) {
            System.err.println("An input/output error occurred.");
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format entered.");
        }
    }
    
    public static int sentinelSearch(int[] arr, int n, int target) {
        int last = arr[n-1];
        arr[n-1] = target; 
        int i = 0;
        while(arr[i] != target) {
            i++;
        }
        arr[n-1] = last;
        if(i < n-1 || arr[n-1] == target) {
            return i;
        }
        return -1;
    }
}
