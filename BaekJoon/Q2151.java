package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q2151 {    // 거울 설치
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        boolean[][][] visited = new boolean[n][n][4];
        int startY = -1, startX = -1;
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '#') {
                    startY = i;
                    startX = j;
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[3] - o2[3];
            }
        });

        for (int i = 0; i < 4; i++) {
            visited[startY][startX][i] = true;
            pq.add(new int[]{startY, startX, i, 0});   // y, x, dir, cnt
        }

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int dir = now[2];
            int ny = now[0] + dy[dir];
            int nx = now[1] + dx[dir];
            int cnt = now[3];
            if (ny < 0 || ny >= n || nx < 0 || nx >= n || map[ny][nx] == '*' || visited[ny][nx][dir]) continue;
            if (map[ny][nx] == '#') {
                System.out.println(cnt);
                return;
            }

            visited[ny][nx][dir] = true;
            pq.add(new int[]{ny, nx, dir, cnt});    // on straight
            if (map[ny][nx] == '!') {
                pq.add(new int[]{ny, nx, (dir + 1) % 4, cnt + 1});  // on right
                pq.add(new int[]{ny, nx, (dir + 3) % 4, cnt + 1});    // on left
            }
        }
    }
}
