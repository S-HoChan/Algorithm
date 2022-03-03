package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2961 {    // 도영이가 만든 맛있는 음식
    static int n;
    static int[] s, b;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n];   // product
        b = new int[n];   // sum
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int idx) {
        if (idx == n) {
            int value1 = 1;
            int value2 = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    value1 *= s[i];
                    value2 += b[i];
                }
            }
            if (value1 == 1 && value2 == 0) return;
            answer = Math.min(answer, Math.abs(value1 - value2));
        } else {
            visited[idx] = true;
            dfs(idx + 1);
            visited[idx] = false;
            dfs(idx + 1);
        }
    }
}
