package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1051 {    // 숫자 정사각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int y = 0; y < n; y++) {
            char[] temp = br.readLine().toCharArray();
            for (int x = 0; x < m; x++) {
                map[y][x] = temp[x] - '0';
            }
        }

        int maxLength = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                int now = map[y][x];
                int d = Math.min(n - y - 1, m - x - 1);
                for (int nd = d; nd > maxLength; nd--) {
                    if (now == map[y + nd][x] && now == map[y][x + nd] && now == map[y + nd][x + nd]) {
                        maxLength = nd;
                        break;
                    }
                }
            }
        }
        System.out.println((maxLength + 1) * (maxLength + 1));
    }
}
