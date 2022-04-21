package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q18224 {   // 미로에 갇힌 건우
    static int m;

    public static void main(String[] args) throws IOException {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n][n];    // true : wall
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        boolean[][][][] visited = new boolean[n][n][2][m];   // y, x, isNoon, cnt2
        LinkedList<int[]> queue = new LinkedList<>();   // y, x, cnt
        queue.add(new int[]{0, 0, 0});
        visited[0][0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int y = now[0], x = now[1], cnt = now[2];
            int isNoon = isSun(cnt) ? 0 : 1;    // 0 : sun, 1 : moon
            int cnt2 = cnt % m; // 날짜 바뀌고 몇 번째 움직임인지
            if (y == n - 1 && x == n - 1) {
                int day = cnt / (2 * m) + 1;
                String sunOrMoon = isNoon == 0 ? " sun" : " moon";
                System.out.println(day + sunOrMoon);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n || visited[ny][nx][isNoon][cnt2]) continue;
                if (map[ny][nx] && !isSun(cnt)) {
                    while (true) {
                        ny += dy[i];
                        nx += dx[i];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= n || visited[ny][nx][isNoon][cnt2]) break;
                        if (!map[ny][nx]) {
                            queue.add(new int[]{ny, nx, cnt + 1});
                            visited[ny][nx][isNoon][cnt2] = true;
                            break;
                        }
                    }
                } else if (!map[ny][nx]) {
                    queue.add(new int[]{ny, nx, cnt + 1});
                    visited[ny][nx][isNoon][cnt2] = true;
                }
            }
        }
        System.out.println(-1);
    }

    static boolean isSun(int cnt) {
        return (cnt / m) % 2 == 0;
    }
}
