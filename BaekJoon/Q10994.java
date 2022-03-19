package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10994 {   // 별 찍기 - 19
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] star = new boolean[4 * n - 3][4 * n - 3];
        for (int i = 0; i < n; i++) {
            int left = 2 * (n - 1 - i), right = 2 * (n - 1 + i);
            for (int y = left; y <= right; y++) {
                for (int x = left; x <= right; x++) {
                    if (y == left || y == right || x == left || x == right) star[y][x] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < 4 * n - 3; y++) {
            for (int x = 0; x < 4 * n - 3; x++) {
                sb.append(star[y][x] ? '*' : ' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
