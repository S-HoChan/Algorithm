package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q2146 {    // 다리 만들기
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[n][n];    // true : land
        for (int y = 0; y < n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        boolean[][] visited = new boolean[n][n];

        int landNum = 0;
        int[][] check = new int[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (visited[y][x] || !map[y][x]) continue;
                visited[y][x] = true;
                check[y][x] = ++landNum;
                LinkedList<int[]> queue = new LinkedList<>();
                queue.add(new int[]{y, x});
                while (!queue.isEmpty()) {
                    int[] now = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int ny = now[0] + dy[i];
                        int nx = now[1] + dx[i];
                        if (isIn(ny, nx) && !visited[ny][nx] && map[ny][nx]) {
                            check[ny][nx] = landNum;
                            visited[ny][nx] = true;
                            queue.add(new int[]{ny, nx});
                        }
                    }
                }
            }
        }

        int answer = n * n + 1;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x]) continue;

                visited = new boolean[n][n];
                visited[y][x] = true;
                LinkedList<int[]> queue = new LinkedList<>();
                queue.add(new int[]{y, x, 1});
                int firstNum = -1;
                int distance = -1;
                boolean flag = false;
                while (!queue.isEmpty() && !flag) {
                    int[] now = queue.poll();
                    for (int i = 0; i < 4; i++) {
                        int ny = now[0] + dy[i];
                        int nx = now[1] + dx[i];
                        if (isIn(ny, nx) && !visited[ny][nx]) {
                            visited[ny][nx] = true;
                            if (map[ny][nx] && check[ny][nx] != firstNum) {
                                if (firstNum == -1) {
                                    firstNum = check[ny][nx];
                                    distance = now[2];
                                } else {
                                    answer = Math.min(answer, distance + now[2] - 1);
                                    flag = true;
                                    break;
                                }
                            } else {
                                queue.add(new int[]{ny, nx, now[2] + 1});
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static boolean isIn(int y, int x) {
        return !(y < 0 || y >= n || x < 0 || x >= n);
    }
}
