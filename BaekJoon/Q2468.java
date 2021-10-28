package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2468 {    // 안전 영역
    static int n;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int minHeight = 101;
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, map[i][j]);
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int answer = 0;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        for (int height = minHeight - 1; height <= maxHeight; height++) {
            int count = 0;
            visited = new boolean[n][n];
            while (true) {
                int[] start = choice(height);
                if (start[0] == -1) break;
                count++;
                LinkedList<int[]> queue = new LinkedList<>();
                queue.add(start);
                visited[start[0]][start[1]] = true;
                while (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int ny = now[0] + dy[i];
                        int nx = now[1] + dx[i];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= n || map[ny][nx] <= height || visited[ny][nx]) continue;

                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    static int[] choice(int height) {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x] > height && !visited[y][x]) {
                    return new int[]{y, x};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
