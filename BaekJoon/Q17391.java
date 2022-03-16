package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q17391 {   // 무한부스터
    public static void main(String[] args) throws IOException {
        int[] dy = {1, 0};
        int[] dx = {0, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = n * m + 1;   // MAX_VALUE
            }
        }

        LinkedList<int[]> queue = new LinkedList<>();   // y, x, cnt
        queue.add(new int[]{0, 0});
        dp[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];
            for (int i = 0; i < 2; i++) {
                for (int move = 1; move <= map[y][x]; move++) {
                    int ny = y + move * dy[i];
                    int nx = x + move * dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                    if (dp[ny][nx] > dp[y][x] + 1) {
                        dp[ny][nx] = dp[y][x] + 1;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }
}
