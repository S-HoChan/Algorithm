package ProgrammersLevel4;

import java.util.*;

public class CaveExploration {
    ArrayList<ArrayList<Integer>> map;
    int[] before;
    int[] savePoint;
    boolean[] visited;

    public boolean solution(int n, int[][] path, int[][] order) {
        map = new ArrayList<ArrayList<Integer>>();
        before = new int[n];
        savePoint = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) map.add(new ArrayList<>());
        for (int i = 0; i < path.length; i++) {   // 그래프 생성
            map.get(path[i][0]).add(path[i][1]);
            map.get(path[i][1]).add(path[i][0]);
        }

        for (int i = 0; i < order.length; i++) before[order[i][1]] = order[i][0];    // 탐험 순서 저장
        if (before[0] != 0) return false;    // 0이 먼저 들려야 하는 곳이 있을 경우 불가능하다

        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();  // bfs
        for (int i : map.get(0)) queue.add(i);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (visited[now]) continue;

            if (!visited[before[now]]) {
                savePoint[before[now]] = now;
                continue;
            }

            visited[now] = true;
            for (int i : map.get(now)) queue.add(i);
            queue.add(savePoint[now]);
        }

        for (int i = 0; i < n; i++)
            if (!visited[i]) return false;
        return true;
    }
}
