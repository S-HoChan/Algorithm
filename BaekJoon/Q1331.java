package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1331 {    // 나이트 투어
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] first = br.readLine().toCharArray();
        boolean[][] visited = new boolean[6][6];
        int row = first[0] - 'A';
        int col = first[1] - '1';
        visited[row][col] = true;
        for (int i = 1; i < 36; i++) {
            char[] arr = br.readLine().toCharArray();
            int nrow = arr[0] - 'A';
            int ncol = arr[1] - '1';
            if (visited[nrow][ncol] || Math.abs((row - nrow) * (col - ncol)) != 2) {
                System.out.println("Invalid");
                return;
            }
            row = nrow;
            col = ncol;
            visited[row][col] = true;
        }
        if (Math.abs((row - (first[0] - 'A')) * (col - (first[1] - '1'))) != 2) System.out.println("Invalid");
        else System.out.println("Valid");
    }
}
