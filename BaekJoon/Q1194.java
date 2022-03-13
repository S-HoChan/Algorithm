package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1194 {    // 달이 차오른다, 가자.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        int startY = -1, startX = -1;
        for (int y = 0; y < n; y++) {
            String temp = br.readLine();
            for (int x = 0; x < m; x++) {
                map[y][x] = temp.charAt(x);
                if (map[y][x] == '0') {
                    startY = y;
                    startX = x;
                }
            }
        }

        boolean[][][] visited = new boolean[n][m][64];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX, 0, 0}); // y, x, count, hasKey
        visited[startY][startX][0] = true;
        while (!queue.isEmpty()) {  // BFS
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];
            int count = now[2];
            int hasKey = now[3];

            if (map[y][x] == '1') {
                System.out.println(count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m ||
                        map[ny][nx] == '#' || visited[ny][nx][hasKey]) continue;

                if (map[ny][nx] - 'a' >= 0 && map[ny][nx] - 'a' < 6) {    // key
                    int tempKey = (1 << (map[ny][nx] - 'a')) | hasKey;  // key get
                    if (!visited[ny][nx][tempKey]) {
                        visited[ny][nx][hasKey] = true;
                        visited[ny][nx][tempKey] = true;
                        queue.add(new int[]{ny, nx, count + 1, tempKey});
                    }
                } else if (map[ny][nx] - 'A' >= 0 && map[ny][nx] - 'A' < 6) {    // door
                    int check = (1 << (map[ny][nx] - 'A')) & hasKey;
                    if (check > 0) {  // isCorrect
                        visited[ny][nx][hasKey] = true;
                        queue.add(new int[]{ny, nx, count + 1, hasKey});
                    }   // door pass
                } else {
                    visited[ny][nx][hasKey] = true;
                    queue.add(new int[]{ny, nx, count + 1, hasKey});
                }
            }
        }
        System.out.println(-1); // can't escape
    }
}
