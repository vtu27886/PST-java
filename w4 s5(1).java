import java.io.*;
import java.util.*;

public class Solution {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        int rows = matrix.size();
        int cols = matrix.get(0).size();

        int layers = Math.min(rows, cols) / 2;

        for (int layer = 0; layer < layers; layer++) {

            int top = layer;
            int bottom = rows - 1 - layer;
            int left = layer;
            int right = cols - 1 - layer;

            List<Integer> ring = new ArrayList<>();

            // Top row
            for (int j = left; j <= right; j++) {
                ring.add(matrix.get(top).get(j));
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                ring.add(matrix.get(i).get(right));
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                ring.add(matrix.get(bottom).get(j));
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                ring.add(matrix.get(i).get(left));
            }

            int len = ring.size();
            int shift = r % len;

            // Anti-clockwise rotation
            List<Integer> rotated = new ArrayList<>();

            for (int i = shift; i < len; i++) {
                rotated.add(ring.get(i));
            }

            for (int i = 0; i < shift; i++) {
                rotated.add(ring.get(i));
            }

            int index = 0;

            // Put rotated values back

            // Top row
            for (int j = left; j <= right; j++) {
                matrix.get(top).set(j, rotated.get(index++));
            }

            // Right column
            for (int i = top + 1; i <= bottom; i++) {
                matrix.get(i).set(right, rotated.get(index++));
            }

            // Bottom row
            for (int j = right - 1; j >= left; j--) {
                matrix.get(bottom).set(j, rotated.get(index++));
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                matrix.get(i).set(left, rotated.get(index++));
            }
        }

        // Print
        for (List<Integer> row : matrix) {
            for (int j = 0; j < row.size(); j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.print(row.get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }

            matrix.add(row);
        }

        matrixRotation(matrix, r);

        sc.close();
    }
}
