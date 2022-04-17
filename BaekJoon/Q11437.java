package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q11437 {   // LCA
    static List<List<Integer>> tree;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tree = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) tree.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            tree.get(first).add(second);
            tree.get(second).add(first);
        }

        parent = new int[n + 1];
        depth = new int[n + 1];
        dfs(1, 1);  // root : 1

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            sb.append(solve(first, depth[first], second, depth[second])).append('\n');
        }
        System.out.println(sb);
    }

    static int solve(int a, int depthA, int b, int depthB) {
        if (depthA > depthB) {
            while (depthA != depthB) {
                depthA--;
                a = parent[a];
            }
        } else if (depthA < depthB) {
            while (depthA != depthB) {
                depthB--;
                b = parent[b];
            }
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    static void dfs(int from, int cnt) {
        depth[from] = cnt++;
        for (int next : tree.get(from)) {
            if (depth[next] == 0) {    // not visit
                dfs(next, cnt);
                parent[next] = from;
            }
        }
    }
}
