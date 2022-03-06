package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q16964 {   // DFS 스페셜 저지
    static boolean[] visited;
    static int[] arr;
    static int[] parent;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            list.get(first).add(second);
            list.get(second).add(first);
        }

        visited = new boolean[n];
        parent = new int[n];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        if (arr[0] != 0) {
            System.out.println(0);
            return;
        }

        dfs(0, 0);
        System.out.println(1);
    }

    static void dfs(int now, int idx) {
        visited[now] = true;

        int count = 0;
        for (int child : list.get(now)) {
            if (!visited[child]) {
                visited[child] = true;
                parent[child] = now;
                count++;
            }
        }

        if (count == 0) return;
        int next = arr[idx + 1];
        if (parent[next] != now) {
            System.out.println(0);
            System.exit(0);
        }
        dfs(next, idx + 1);
    }
}
