package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1913 {    // 달팽이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int y = n / 2, x = n / 2;
        int direct = -1;
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int dist = 0;   // 같은 방향으로 이동할 거리
        int cnt = 0;    // 같은 방향으로 이동한 거리
        boolean flag = true;   // dist 증가시키는 조건
        int ky = -1, kx = -1;
        for (int num = 1; num <= n * n; num++) {
            if (num == k) {
                ky = y;
                kx = x;
            }

            map[y][x] = num;
            cnt++;
            if (cnt >= dist) {
                direct = (direct + 1) % 4;
                cnt = 0;
                if (flag) dist++;   // 같은거리 2번 후 +1
                flag = !flag;
            }
            y = y + dy[direct]; // next y
            x = x + dx[direct]; // next x
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        sb.append(ky + 1).append(' ').append(kx + 1);
        System.out.println(sb);
    }
}
