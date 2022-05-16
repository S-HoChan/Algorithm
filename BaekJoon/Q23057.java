package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q23057 {   // 도전 숫자왕
    static Set<Integer> set = new HashSet<>();
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            m += arr[i];
        }

        dfs(0, 0);
        System.out.println(m - set.size() + 1);
    }

    static void dfs(int idx, int sum) {
        if (idx == n) return;

        set.add(sum);
        dfs(idx + 1, sum);
        set.add(sum + arr[idx]);
        dfs(idx + 1, sum + arr[idx]);
    }
}
