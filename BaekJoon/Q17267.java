package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q17267 {   // 상남자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];    // true : wall
        int startY = -1, startX = -1;
        for (int y = 0; y < n; y++) {
            char[] temp = br.readLine().toCharArray();
            for (int x = 0; x < m; x++) {
                map[y][x] = temp[x] == '1';
                if (temp[x] == '2') {
                    startY = y;
                    startX = x;
                }
            }
        }

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX, l, r});
        boolean[][] visited = new boolean[n][m];
        visited[startY][startX] = true;
        int answer = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();   // y, x, l, r
            int y = now[0];
            int x = now[1];

            for (int i = 1; i <= n; i++) {    // up
                int ny = y - i;
                if (ny < 0 || map[ny][x] || visited[ny][x]) break;

                visited[ny][x] = true;
                queue.add(new int[]{ny, x, now[2], now[3]});
                answer++;
            }
            for (int i = 1; i <= n; i++) {  // down
                int ny = y + i;
                if (ny >= n || map[ny][x] || visited[ny][x]) break;

                visited[ny][x] = true;
                queue.add(new int[]{ny, x, now[2], now[3]});
                answer++;
            }
            int nx = x - 1;  // left
            if (now[2] > 0 && !(nx < 0 || map[y][nx] || visited[y][nx])) {
                visited[y][nx] = true;
                queue.add(new int[]{y, nx, now[2] - 1, now[3]});
                answer++;
            }
            nx = x + 1; // right
            if (now[3] > 0 && !(nx >= m || map[y][nx] || visited[y][nx])) {
                visited[y][nx] = true;
                queue.add(new int[]{y, nx, now[2], now[3] - 1});
                answer++;
            }
        }
        System.out.println(answer);
    }
}
