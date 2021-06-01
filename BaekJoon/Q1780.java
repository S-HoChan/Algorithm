package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1780 {    // 종이의 개수
    private static int[][] map;
    private static int minus = 0;
    private static int zero = 0;
    private static int plus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, n);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    private static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            if (map[row][col] == -1) minus++;
            else if (map[row][col] == 0) zero++;
            else if (map[row][col] == 1) plus++;
        } else {
            int newSize = size / 3;
            partition(row, col, newSize);
            partition(row, col + newSize, newSize);
            partition(row, col + newSize * 2, newSize);
            partition(row + newSize, col, newSize);
            partition(row + newSize, col + newSize, newSize);
            partition(row + newSize, col + newSize * 2, newSize);
            partition(row + newSize * 2, col, newSize);
            partition(row + newSize * 2, col + newSize, newSize);
            partition(row + newSize * 2, col + newSize * 2, newSize);
        }
    }

    private static boolean check(int row, int col, int size) {
        int now = map[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != now) return false;
            }
        }
        return true;
    }
}
