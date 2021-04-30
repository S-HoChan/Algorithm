package ProgrammersLevel4;

import java.util.*;

public class TrioMedian {
    public int solution(int n, int[][] edges) {
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<Integer>();
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }

        int start = 1, max = 0, cnt = 0;
        int[] result = bfs(list, start, n); // 1에서 가장 먼 노드를 찾는다.
        for (int i = 2; i <= n; i++)
            if (result[i] > result[start]) start = i;

        result = bfs(list, start, n);   // 가장 먼 노드에서 각 노드까지의 값을 찾는다. ( 지름 )
        start = 1;
        for (int i = 1; i <= n; i++)
            if (result[i] > result[start]) start = i;
        for (int i : result) max = Math.max(max, i);
        for (int i : result) if (max == i) cnt++;
        if (cnt >= 2) return result[start];  // 가장 먼 노드가 2개 이상인 경우 이를 선택

        max = 0;
        cnt = 0;
        result = bfs(list, start, n); // 가장 먼 노드를 기준으로 각 노드까지의 값을 찾는다.
        for (int i : result) max = Math.max(max, i);
        for (int i : result) if (max == i) cnt++;
        if (cnt >= 2) return max;
        else return max - 1;
    }

    private int[] bfs(ArrayList<Integer>[] list, int s, int n) {
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : list[now]) {
                if (i == now || visited[i]) continue;
                visited[i] = true;
                queue.add(i);
                dist[i] = dist[now] + 1;
            }
        }
        return dist;
    }
}
