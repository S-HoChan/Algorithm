package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14889 {   // 스타트와 링크
    private static int[][] map;
    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    private static void dfs(int idx, int depth) {
        if (depth == n / 2) {
            diff();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void diff() {    // 차이 계산
        int startSum = 0, linkSum = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) startSum += map[i][j] + map[j][i];
                else if (!visited[i] && !visited[j]) linkSum += map[i][j] + map[j][i];
            }
        }

        int diff = Math.abs(startSum - linkSum);
        if (diff == 0) {
            System.out.println(diff);
            System.exit(0);
        } else min = Math.min(min, diff);
    }
}
