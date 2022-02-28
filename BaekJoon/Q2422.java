package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2422 { // 한윤정이 이탈리아에 가서 아이스크림을 사먹는데
    static int n;
    static boolean[][] isCant;
    static boolean[] visited;
    static int answer = 0;
    static int[] now = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        isCant = new boolean[n][n];
        visited = new boolean[n];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            isCant[first][second] = true;
            isCant[second][first] = true;
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int idx) {
        if (depth == 3) {
            int n1 = now[0];
            int n2 = now[1];
            int n3 = now[2];
            if (!isCant[n1][n2] && !isCant[n2][n3] && !isCant[n3][n1]) {
                answer++;
            }
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                now[depth] = i;
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
