import java.util.*;

/**
 * This is the Java version of my solution (Java is my primary language).
 * There is also a PHP version (which I learned on demand as you preferred).
 * Please see solution specifics in README.txt
 */
public class JavaSolution {
    /**
     * An in-place solution -  time: O(n) , space: O(1).
     * Swap the desired words to the front of the input array, and return the ending index.
     * @param words
     * @return
     */
    public static int findDuplicate(String[] words) {
        // Corner case
        if (words == null || words.length < 2) {
            return -1;
        }
        int slow = -1;
        int fast = 0;
        String duplicate = null; // Keep track of the duplicate pattern
        while (fast < words.length) {
            // Condition#1: the current word is the same as the next (if not reaching the end of array)
            boolean condition1 = fast < words.length - 1 && words[fast].equals(words[fast+1]);
            // Condition#2: reaching the last word of a duplicate pattern
            boolean condition2 = words[fast].equals(duplicate);
            // target pattern: successive duplicate
            if (condition1 || condition2)  {
                duplicate = words[fast];
                swap(words, ++slow, fast);
                // System.out.print(duplicate + " ");
            } else {
                // Reset
                duplicate = null;
            }
            fast++; // drives the loop
        }
        return slow; // result -> [0, slow)
    }

    /**
     * Swap two elements in a string array
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
    =========================
        API for testing
    =========================
     */

    /**
     * Transform the result to a list - For test only
     * @param idx
     * @param words
     * @return
     */
    static List<String> getResult(int idx, String[] words) {
        if (idx <= 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= idx; i++) {
            result.add(words[i]);
        }
        return result;
    }

    /**
     * Unit Tests
     * @param args
     */
    public static void main(String[] args) {
        List<String> passed = new ArrayList<>();
        List<String> failed = new ArrayList<>();

        // Test#1: given by instructions
        String input1 = "one two two three go go go big small big how sample test text to do it default returns string string is is in seconds since what is the end end";
        String[] words1 = input1.split(" ");
        int endingIdx1 = findDuplicate(words1);
        List<String> expected1 = Arrays.asList("two", "two", "go", "go", "go", "string", "string", "is", "is", "end", "end");
        List<String> actual1 = getResult(endingIdx1, words1);
        if (endingIdx1 == 10 && expected1.equals(actual1)) {
            passed.add("Test case given by the instruction");
        } else {
            failed.add("Test case given by the instruction");
        }

        // Test#2: No-duplicate
        String input2 = "one two three four five";
        String[] words2 = input2.split(" ");
        if (findDuplicate(words2) == -1) {
            passed.add("No-duplicate");
        } else {
            failed.add("No-duplicate");
        }

        // Test#3: All-duplciate
        String input3 = "one one one one one";
        String[] words3 = input3.split(" ");
        int endingIdx3 = findDuplicate(words3);
        List<String> expected3 = Arrays.asList("one", "one", "one", "one", "one");
        List<String> actual3 = getResult(endingIdx3, words3);
        if (endingIdx3 == 4 && expected3.equals(actual3)) {
            passed.add("All-duplicate");
        } else {
            failed.add("All-duplicate");
        }
        
        // Test#4: Null input array
        String[] words4 = null;
        if (findDuplicate(words4) == -1) {
            passed.add("Null input");
        } else {
            failed.add("Null input");
        }

        // Test#5: Empty input array
        String[] words5 = null;
        if (findDuplicate(words5) == -1) {
            passed.add("Empty input");
        } else {
            failed.add("Empty input");
        }

        // Summary
        System.out.println();
        System.out.println("========= Test results =========");
        System.out.println("Test cases passed: " + passed.size());
        for (String str : passed) {
            System.out.println("    " + str);
        }
        System.out.println("Test cases failed: " + failed.size());
        for (String str : failed) {
            System.out.println("    " + str);
        }
        System.out.println("================================");
        System.out.println();
    }
}

