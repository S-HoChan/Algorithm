package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16946 {   // 벽 부수고 이동하기 4
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[n][m];    // true : wall
        for (int y = 0; y < n; y++) {
            char[] temp = br.readLine().toCharArray();
            for (int x = 0; x < m; x++) {
                map[y][x] = temp[x] == '1';
            }
        }

        Map<Integer, Integer> area = new HashMap<>();    // key, area
        int[][] visited = new int[n][m];
        int key = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] || visited[y][x] > 0) continue;

                int temp = 1;
                visited[y][x] = ++key;
                LinkedList<int[]> queue = new LinkedList<>();
                queue.add(new int[]{y, x});
                while (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int ny = now[0] + dy[i];
                        int nx = now[1] + dx[i];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                        if (map[ny][nx] || visited[ny][nx] > 0) continue;

                        queue.add(new int[]{ny, nx});
                        visited[ny][nx] = key;
                        temp++;
                    }
                }
                area.put(key, temp);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (!map[y][x]) sb.append(0);
                else {
                    Set<Integer> set = new HashSet<>();
                    int sum = 1;
                    for (int i = 0; i < 4; i++) {
                        int ny = y + dy[i];
                        int nx = x + dx[i];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx]) continue;

                        if (!set.contains(visited[ny][nx])) {
                            set.add(visited[ny][nx]);
                            sum += area.get(visited[ny][nx]);
                        }
                    }
                    sb.append(sum % 10);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
