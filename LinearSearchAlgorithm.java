import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinearSearchAlgorithm {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.println("Enter integers separated by spaces:");
            String numbersLine = reader.readLine();
            String[] numbersStr = numbersLine.trim().split("\\s+");
            int[] numbers = new int[numbersStr.length];
            for (int i = 0; i < numbersStr.length; i++) {
                numbers[i] = Integer.parseInt(numbersStr[i]);
            }
            
            System.out.println("Enter the target value:");
            int target = Integer.parseInt(reader.readLine().trim());
            
            int index = linearSearch(numbers, target);

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
    
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  
            }
        }
        return -1;  
    }
}
