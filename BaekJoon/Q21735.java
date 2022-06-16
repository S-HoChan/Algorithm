package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q21735 {   // 눈덩이 굴리기
    static int n, m;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dfs(-1, 0, 1);
        System.out.println(answer);
    }

    static void dfs(int idx, int depth, int size) {
        if (depth > m) return;

        answer = Math.max(answer, size);
        if (idx + 1 < n) dfs(idx + 1, depth + 1, size + arr[idx + 1]);
        if (idx + 2 < n) dfs(idx + 2, depth + 1, size / 2 + arr[idx + 2]);
    }
}
