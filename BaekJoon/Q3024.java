package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3024 {    // 마라톤 틱택토
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                char now = map[y][x];
                if (now == '.') continue;
                if (y + 2 < n) {  // 세로
                    if (map[y + 1][x] == now && map[y + 2][x] == now) {
                        System.out.println(now);
                        return;
                    }
                }
                if (x + 2 < n) {    // 가로
                    if (map[y][x + 1] == now && map[y][x + 2] == now) {
                        System.out.println(now);
                        return;
                    }
                }
                if (y + 2 < n && x + 2 < n) {   // 우하단
                    if (map[y + 1][x + 1] == now && map[y + 2][x + 2] == now) {
                        System.out.println(now);
                        return;
                    }
                }
                if (y + 2 < n && x - 2 >= 0) {    // 좌하단
                    if (map[y + 1][x - 1] == now && map[y + 2][x - 2] == now) {
                        System.out.println(now);
                        return;
                    }
                }
            }
        }

        System.out.println("ongoing");
    }
}
