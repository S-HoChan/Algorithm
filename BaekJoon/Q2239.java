package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2239 {    // 스도쿠
    static int[][] map = new int[9][9];
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int y = 0; y < 9; y++) {
            char[] temp = br.readLine().toCharArray();
            for (int x = 0; x < 9; x++) {
                map[y][x] = temp[x] - '0';

                if (map[y][x] == 0) list.add(new int[]{y, x});
            }
        }

        sudoku(0);
    }

    static void sudoku(int idx) {
        if (idx == list.size()) {
            StringBuilder sb = new StringBuilder();
            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    sb.append(map[y][x]);
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        int y = list.get(idx)[0];
        int x = list.get(idx)[1];

        boolean[] visited = new boolean[10];

        for (int i = 0; i < 9; i++) {
            visited[map[i][x]] = true;
        }
        for (int i = 0; i < 9; i++) {
            visited[map[y][i]] = true;
        }
        for (int i = y / 3 * 3; i < y / 3 * 3 + 3; i++) {
            for (int j = x / 3 * 3; j < x / 3 * 3 + 3; j++) {
                visited[map[i][j]] = true;
            }
        }

        for (int n = 1; n <= 9; n++) {
            if (!visited[n]) {
                map[y][x] = n;
                sudoku(idx + 1);
                map[y][x] = 0;
            }
        }
    }
}
