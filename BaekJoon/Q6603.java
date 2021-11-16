package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6603 {    // 로또
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] checked;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isFirst = true;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            arr = new int[k];
            checked = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if (!isFirst) sb.append('\n');
            else isFirst = false;

            dfs(0, 0);
        }

        System.out.println(sb);
    }

    static void dfs(int depth, int idx) {
        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if (checked[i]) {
                    sb.append(arr[i]).append(' ');
                }
            }
            sb.append('\n');
        } else if (6 - depth <= k - idx) {
            checked[idx] = true;
            dfs(depth + 1, idx + 1);
            checked[idx] = false;
            dfs(depth, idx + 1);
        }
    }
}
