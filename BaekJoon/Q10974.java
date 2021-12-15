package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10974 {   // 모든 순열
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] origin;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        origin = new int[n];
        for (int i = 0; i < n; i++) {
            origin[i] = i + 1;
        }
        visited = new boolean[n];
        int[] temp = new int[n];
        perm(0, temp);

        System.out.println(sb);
    }

    static void perm(int depth, int[] output) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = origin[i];
                perm(depth + 1, output);
                visited[i] = false;
            }
        }
    }
}
