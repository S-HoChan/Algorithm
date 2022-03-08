package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q16505 {   // 별
    static char[][] map = new char[4][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println("*");
            return;
        } else if (n == 1) {
            System.out.println("**");
            System.out.println("*");
            return;
        }

        map[0] = "****".toCharArray();
        map[1] = "* *".toCharArray();
        map[2] = "**".toCharArray();
        map[3] = "*".toCharArray();

        while (n-- > 2) {
            int m = map.length;
            char[][] temp = new char[m * 2][m * 2];
            for (int y = 0; y < m; y++) {
                Arrays.fill(temp[y], ' ');
                for (int x = 0; x < m - y; x++) {
                    temp[y][x] = map[y][x];
                    temp[y + m][x] = map[y][x];
                    temp[y][x + m] = map[y][x];
                }
            }
            map = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length - y; x++) {
                sb.append(map[y][x]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
