package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q6593 {    // 상범 빌딩
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dy = {-1, 1, 0, 0, 0, 0};
        int[] dx = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (l == 0 && r == 0 && c == 0) break;

            char[][][] map = new char[l][r][c];
            boolean[][][] visited = new boolean[l][r][c];
            LinkedList<int[]> queue = new LinkedList<>();   // z, y, x, cnt
            for (int z = 0; z < l; z++) {
                for (int y = 0; y < r; y++) {
                    char[] arr = br.readLine().toCharArray();
                    for (int x = 0; x < c; x++) {
                        map[z][y][x] = arr[x];
                        if (arr[x] == 'S') {
                            queue.add(new int[]{z, y, x, 0});
                            visited[z][y][x] = true;
                        }
                    }
                }
                br.readLine();  // 층 간 공백입력 처리
            }

            boolean flag = false;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                int z = now[0], y = now[1], x = now[2], cnt = now[3];
                if (map[z][y][x] == 'E') {
                    sb.append("Escaped in ").append(cnt).append(" minute(s).\n");
                    flag = true;
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int nz = z + dz[i];
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (nz < 0 || nz >= l || ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                    if (visited[nz][ny][nx] || map[nz][ny][nx] == '#') continue;
                    visited[nz][ny][nx] = true;
                    queue.add(new int[]{nz, ny, nx, cnt + 1});
                }
            }
            if (!flag) sb.append("Trapped!\n");
        }
        System.out.println(sb);
    }
}
