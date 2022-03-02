package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16926 {   // 배열 돌리기 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        while (r-- > 0) {
            int nowY = 0, nowX = 0;
            for (int i = 0; nowY < n / 2 && nowX < m / 2; i++) {
                int direct = 0;
                int temp = map[nowY][nowX];
                int y = nowY, x = nowX;
                while (true) {
                    if (y == nowY + 1 && x == nowX) {
                        map[y][x] = temp;
                        break;
                    }

                    int ny = y + dy[direct];
                    int nx = x + dx[direct];
                    if (ny < i || ny >= n - i || nx < i || nx >= m - i) {
                        direct++;
                    } else {
                        map[y][x] = map[ny][nx];
                        y = ny;
                        x = nx;
                    }
                }
                nowY++;
                nowX++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                sb.append(map[y][x]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
