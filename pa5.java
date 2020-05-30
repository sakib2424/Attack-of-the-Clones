import java.io.*;
import java.util.*;

public class pa5 {
    static int[][] array;
    static String[] s;
    static String t;

    public static void main(String[] args) throws Exception {
        // main
        Scanner scanner = new Scanner(System.in);
        BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(System.out, "ASCII"), 4096);

        t = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());

        s = new String[k + 1];
        s[0] = "placeholder";

        for (int i = 1; i < (k + 1); i++) {
            s[i] = scanner.nextLine();
        }

        scanner.close();

        // Create 2D array
        array = new int[k + 1][t.length() + 1];

        // Initialize with -1
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = -1;
            }
        }

        // Fill 2D array
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = opt(i, j);
            }
        }

        // Print solution
        if (array[k][t.length()] >= 9999) {
            buffer.write("0\n");
        } else { 
            // Build solution
            ArrayList<Integer> output = new ArrayList<>();
            int count = 0;
            int size = t.length();
            int last_index = Integer.MAX_VALUE;
            int current_min = Integer.MAX_VALUE;

            while (size != 0) {
                for (int i = array.length - 1; i > 0; i--) {
                    if (array[i][size] != array[i - 1][size] && last_index > i && current_min > array[i][size]) {
                        current_min = array[i][size];
                        last_index = i;
                        count++;
                        size -= s[i].length();
                        output.add(i);
                    }
                }
            }

            buffer.write(count + " ");
            for (int i = output.size() - 1; i >= 0; i--) {
                buffer.write(output.get(i) + " ");
            }
        }

        buffer.close();
    }

    // Optimal # of tiles among s1,...,si that cover t[0,...j)
    static int opt(int i, int j) {
        // Check if value exists in table
        if (array[i][j] != -1) {
            return array[i][j];
        }

        if (i == 0 && j == 0) {
            return 0;
        } else if (i == 0 && j > 0) {
            return 9999; // inf
        } else if (i > 0 && t.regionMatches(false, (j - s[i].length()), s[i], 0, s[i].length()) == false) {
            return opt(i - 1, j);
        } else {
            return Math.min(opt(i - 1, j), 1 + opt(i - 1, j - s[i].length()));
        }
    }

}
