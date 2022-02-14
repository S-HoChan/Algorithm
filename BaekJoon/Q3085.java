package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3085 {    // 사탕 게임
    static char[][] map;
    static int answer = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (x + 1 < n) {    // Right
                    swap(y, x, y, x + 1);
                    check();
                    swap(y, x, y, x + 1);
                }
                if (y + 1 < n) { // Right
                    swap(y, x, y + 1, x);
                    check();
                    swap(y, x, y + 1, x);
                }
            }
        }

        System.out.println(answer);
    }

    static void check() {
        // Right
        for (int y = 0; y < n; y++) {
            int count = 1;
            for (int x = 0; x < n - 1; x++) {
                if (map[y][x] == map[y][x + 1]) count++;
                else count = 1;
                answer = Math.max(answer, count);
            }
        }

        // Down
        for (int x = 0; x < n; x++) {
            int count = 1;
            for (int y = 0; y < n - 1; y++) {
                if (map[y][x] == map[y + 1][x]) count++;
                else count = 1;
                answer = Math.max(answer, count);
            }
        }
    }

    static void swap(int y1, int x1, int y2, int x2) {
        char temp = map[y1][x1];
        map[y1][x1] = map[y2][x2];
        map[y2][x2] = temp;
    }
}
