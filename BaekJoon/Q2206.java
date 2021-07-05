package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2206 {    // 벽 부수고 이동하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
                visited[i][j] = m * n + 1;
            }
        }

        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        LinkedList<int[]> queue = new LinkedList<>();   // {x, y, cnt, drill}
        queue.add(new int[]{0, 0, 1, 0});
        visited[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == n - 1 && now[1] == m - 1) {
                System.out.println(now[2]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];
                if (y < 0 || y >= n || x < 0 || x >= m || visited[y][x] <= now[3]) continue;

                if (map[y][x] == 0) visited[y][x] = now[3];
                else if (now[3] == 0) visited[y][x] = now[3] + 1;
                queue.add(new int[]{y, x, now[2] + 1, visited[y][x]});
            }
        }
        System.out.println(-1);
    }
}
