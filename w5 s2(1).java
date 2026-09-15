import java.io.*;
import java.util.*;

public class Solution {

    public static List<Integer> maxSubarray(List<Integer> arr) {

        int currentSum = arr.get(0);
        int maxSubarray = arr.get(0);

        int maxSubsequence = 0;
        int maxElement = arr.get(0);

        for (int i = 0; i < arr.size(); i++) {

            int value = arr.get(i);

            // Maximum element
            if (value > maxElement) {
                maxElement = value;
            }

            // Maximum subarray
            if (i > 0) {
                currentSum = Math.max(value, currentSum + value);
                maxSubarray = Math.max(maxSubarray, currentSum);
            }

            // Maximum subsequence
            if (value > 0) {
                maxSubsequence += value;
            }
        }

        // If all elements are negative or zero
        if (maxSubsequence == 0) {
            maxSubsequence = maxElement;
        }

        return Arrays.asList(maxSubarray, maxSubsequence);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            String[] input = br.readLine().split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(Integer.parseInt(input[i]));
            }

            List<Integer> result = maxSubarray(arr);

            System.out.println(
                result.get(0) + " " + result.get(1)
            );
        }
    }
}
