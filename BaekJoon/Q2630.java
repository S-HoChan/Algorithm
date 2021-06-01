package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2630 {    // 색종이 만들기
    private static int white = 0;
    private static int blue = 0;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void solution(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (board[row][col] == 0) white++;
            else blue++;
            return;
        }

        solution(row, col, size / 2);
        solution(row, col + size / 2, size / 2);
        solution(row + size / 2, col, size / 2);
        solution(row + size / 2, col + size / 2, size / 2);
    }

    private static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) return false;
            }
        }

        return true;
    }
}
