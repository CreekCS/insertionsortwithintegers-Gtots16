import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsSortInt {
    public static void main(String[] args) {
        String filePath = "randInts.txt";
        List<Integer> numbers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return;
        }
        insertionSort(numbers);
            System.out.println("Smallest number: " + numbers.get(0));
            System.out.println("Largest number: " + numbers.get(numbers.size() - 1));
    }
    private static void insertionSort(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            Integer key = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }
    }
}
 