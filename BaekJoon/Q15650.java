package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15650 {   // N과 M (2)
    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        dfs(n, m, 0, 1);
        System.out.println(sb);
    }

    private static void dfs(int n, int m, int depth, int at) {
        if (depth == m) {
            for (int num : arr) sb.append(num).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = at; i <= n; i++) {
            arr[depth] = i;
            dfs(n, m, depth + 1, i + 1);
        }
    }
}