package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q7576 {    // 토마토
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j, map[i][j]});
                }
            }
        }

        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];

                if (y < 0 || y >= n || x < 0 || x >= m || map[y][x] != 0) continue;

                map[y][x] = now[2] + 1;
                queue.add(new int[]{y, x, map[y][x]});
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                ans = Math.max(ans, map[i][j]);
            }
        }

        System.out.println(ans - 1);
    }
}
