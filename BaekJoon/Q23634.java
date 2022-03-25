package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q23634 {   // 미안하다 이거 보여주려고 어그로 끌었다
    // todo. 시간초과 해결
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> firstFireLocate = new ArrayList<>();  // y, x
    static List<int[]> areaFirst = new ArrayList<>();   // y, x

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];    // 0 : fire, 1 : tree, 2 : rock
        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp[j] - '0';
                if (map[i][j] == 0) firstFireLocate.add(new int[]{i, j});
            }
        }

        visited = new boolean[n][m];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (visited[y][x]) continue;

                visited[y][x] = true;
                if (map[y][x] == 0) {
                    areaFirst.add(new int[]{y, x});
                    LinkedList<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{y, x});
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        for (int i = 0; i < 4; i++) {
                            int ny = now[0] + dy[i];
                            int nx = now[1] + dx[i];
                            if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] || map[ny][nx] == 2) continue;

                            queue.add(new int[]{ny, nx});
                            visited[ny][nx] = true;
                        }
                    }
                }
            }
        }

        int day = 0;
        while (!isAllConnect()) {

            map = nextDay();
            day++;
        }
        System.out.println(day + " " + getArea());
    }

    static int[][] nextDay() {
        int[][] temp = new int[n][m];
        for (int y = 0; y < n; y++) {
            Arrays.fill(temp[y], 1);
        }
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == 2) temp[y][x] = 2;
                else if (map[y][x] == 0) {
                    temp[y][x] = 0;
                    for (int i = 0; i < 4; i++) {
                        int ny = y + dy[i];
                        int nx = x + dx[i];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == 2) continue;
                        temp[ny][nx] = 0;
                    }
                }
            }
        }

        return temp;
    }

    static boolean isAllConnect() {
        if (areaFirst.isEmpty()) return true;

        visited = new boolean[n][m];
        for (int[] ints : areaFirst) {
            LinkedList<int[]> queue = new LinkedList<>();
            visited[ints[0]][ints[1]] = true;
            queue.add(ints);
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = now[0] + dy[i];
                    int nx = now[1] + dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] || map[ny][nx] != 0) continue;
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }

        for (int[] first : firstFireLocate) {
            if (!visited[first[0]][first[1]]) return false;
        }
        return true;
    }

    static int getArea() {
        int temp = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == 0) temp++;
            }
        }
        return temp;
    }
}
