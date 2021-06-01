package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1992 {    // 쿼드트리
    private static int[][] map;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        partition(0,0,n);

        System.out.println(sb);
    }

    private static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            sb.append(map[row][col]);
            return;
        }

        sb.append('(');
        partition(row, col, size / 2);
        partition(row, col + size / 2, size / 2);
        partition(row + size / 2, col, size / 2);
        partition(row + size / 2, col + size / 2, size / 2);
        sb.append(')');
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
