package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14620 {   // 꽃길
    static int answer = 200 * 5 * 3 + 1;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int n;
    static int[][] map, cost;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int y = 0; y < n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        cost = new int[n][n];
        for (int y = 1; y < n - 1; y++) {
            for (int x = 1; x < n - 1; x++) {
                cost[y][x] = map[y][x] + map[y - 1][x] + map[y + 1][x] + map[y][x - 1] + map[y][x + 1];
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int sum) {
        if (depth == 3) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int y = 1; y < n - 1; y++) {
            for (int x = 1; x < n - 1; x++) {
                if (isOk(y, x)) {
                    visitedCheck(y, x);
                    dfs(depth + 1, sum + cost[y][x]);
                    visitedClear(y, x);

                }
            }
        }
    }

    static boolean isOk(int y, int x) {
        if (visited[y][x]) return false;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (visited[ny][nx]) return false;
        }
        return true;
    }

    static void visitedCheck(int y, int x){
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            visited[ny][nx] = true;
        }
    }

    static void visitedClear(int y, int x) {
        visited[y][x] = false;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            visited[ny][nx] = false;
        }
    }
}
