package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2178 {    // 미로 탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = string.charAt(j) - '0';
            }
        }

        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};

        LinkedList<int[]> queue = new LinkedList<>();   // y, x, cnt
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        int ans = n * m + 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];
                if (y >= 0 && y < n && x >= 0 && x < m && map[y][x] == 1 && !visited[y][x]) {
                    visited[y][x] = true;
                    queue.add(new int[]{y, x, now[2] + 1});
                    if (y == n - 1 && x == m - 1) ans = Math.min(ans, now[2] + 1);
                }
            }
        }

        System.out.println(ans);
    }
}
