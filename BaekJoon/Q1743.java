package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1743 {    // 음식물 피하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];    // true : trash
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = true;
        }

        int answer = 0;
        boolean[][] visited = new boolean[n][m];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (visited[y][x] || !map[y][x]) continue;

                LinkedList<int[]> queue = new LinkedList<>();
                queue.add(new int[]{y, x});
                visited[y][x] = true;
                int cnt = 1;
                while (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int ny = now[0] + dy[i];
                        int nx = now[1] + dx[i];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= m
                                || visited[ny][nx] || !map[ny][nx]) continue;

                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        cnt++;
                    }
                }
                answer = Math.max(answer, cnt);
            }
        }
        System.out.println(answer);
    }
}
