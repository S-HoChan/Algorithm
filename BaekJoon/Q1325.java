package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// todo. 시간초과
public class Q1325 {    // 효율적인 해킹
    static List<Integer>[] list;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            dfs(i, i);
        }

        StringBuilder sb = new StringBuilder();
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            maxCount = Math.max(maxCount, arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == maxCount) {
                sb.append(i + 1).append(' ');
            }
        }
        System.out.println(sb);
    }

    static void dfs(int start, int now) {
        for (int num : list[now]) {
            if (!visited[num]) {
                dfs(start, num);
                arr[start]++;
            }
        }
    }
}
