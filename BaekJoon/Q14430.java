package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14430 {   // 자원 캐기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (y == 0 && x == 0) continue;
                int max = 0;
                if (y == 0) max = map[y][x - 1];
                else if (x == 0) max = map[y - 1][x];
                else max = Math.max(map[y][x - 1], map[y - 1][x]);
                map[y][x] += max;
            }
        }
        System.out.println(map[n - 1][m - 1]);
    }
}
