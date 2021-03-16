package ProgrammersLevel3;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public int solution(int n, int[][] computers) {
        int answer = 1;
        int[] connect = new int[n];
        boolean[][] map = new boolean[n][n];

        for (int y = 0; y < computers.length; y++) {
            for (int x = 0; x < computers[0].length; x++) {
                if (computers[y][x] == 1) map[y][x] = true;
            }
        }

        for (int i = 0; i < computers.length; i++) {
            if (connect[i] != 0) continue;
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while (!queue.isEmpty()) {
                int now = queue.poll();
                if (visited[now]) continue;

                for (int j = 0; j < n; j++) {
                    if (map[j][now]) {
                        queue.add(j);
                    }
                }
                visited[now] = true;
            }

            int cnt = 0;
            for (int k = 0; k < n; k++) {
                if (visited[k]) {
                    connect[k] = answer;
                    cnt++;
                }
            }
            if (cnt != 0) answer++;
        }

        return answer - 1;
    }
}
