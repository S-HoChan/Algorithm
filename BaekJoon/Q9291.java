package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9291 {    // 스도쿠 채점
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int x = 1; x <= t; x++) {
            int[][] map = new int[9][9];
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Case ").append(x).append(": ");
            if (isOk(map)) sb.append("CORRECT");
            else sb.append("INCORRECT");
            sb.append('\n');
            if (x < t) {
                String temp = br.readLine();
            }
        }
        System.out.println(sb);
    }

    static boolean isOk(int[][] map) {
        boolean[] checked;
        for (int y = 0; y < 9; y++) {
            checked = new boolean[10];
            for (int x = 0; x < 9; x++) {
                if (checked[map[y][x]]) return false;
                checked[map[y][x]] = true;
            }
        }

        for (int x = 0; x < 9; x++) {
            checked = new boolean[10];
            for (int y = 0; y < 9; y++) {
                if (checked[map[y][x]]) return false;
                checked[map[y][x]] = true;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checked = new boolean[10];
                for (int y = 3 * i; y < 3 * i + 3; y++) {
                    for (int x = 3 * i; x < 3 * i + 3; x++) {
                        if (checked[map[y][x]]) return false;
                        checked[map[y][x]] = true;
                    }
                }
            }
        }
        return true;
    }
}
