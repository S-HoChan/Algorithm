package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15651 {   // N과 M (3)
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(n, m, 0);
        System.out.println(sb);
    }

    private static void dfs(int n, int m, int depth) {
        if(m == depth){
            for(int num : arr) sb.append(num).append(' ');
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= n; i++){
            arr[depth] = i;
            dfs(n,m,depth + 1);
        }
    }
}
