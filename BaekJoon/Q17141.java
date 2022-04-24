package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q17141 {   // 연구소 2
    static boolean[][] map;
    static boolean[][] visited;
    static int n, m;
    static int answer = 2501;   // 50 * 50 + 1
    static List<int[]> list = new ArrayList<>();
    static List<int[]> setting = new ArrayList<>();

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][n]; // wall : true
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1) map[y][x] = true;
                else if (temp == 2) list.add(new int[]{y, x});
            }
        }

        setVirus(0, 0);
        System.out.println(answer == 2501 ? -1 : answer);
    }

    static void setVirus(int depth, int idx) {  // dfs
        if (depth == m) {
            visited = new boolean[n][n];    // bfs
            LinkedList<int[]> queue = new LinkedList<>();
            for (int[] now : setting) {
                int y = now[0], x = now[1];
                queue.add(new int[]{y, x, 0});  // int[2] : time
                visited[y][x] = true;
            }

            int max = 0;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                int y = now[0], x = now[1], cnt = now[2];
                max = cnt;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                    if (map[ny][nx] || visited[ny][nx]) continue;

                    queue.add(new int[]{ny, nx, cnt + 1});
                    visited[ny][nx] = true;
                }
            }

            if (isOk()) {
                answer = Math.min(answer, max);
            }
            return;
        }
        if (idx == list.size()) return;

        int[] now = list.get(idx);
        setting.add(new int[]{now[0], now[1]});
        setVirus(depth + 1, idx + 1);
        setting.remove(depth);
        setVirus(depth, idx + 1);
    }

    static boolean isOk() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!map[y][x] && !visited[y][x]) return false;
            }
        }
        return true;
    }
}
