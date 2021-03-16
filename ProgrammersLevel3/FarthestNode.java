package ProgrammersLevel3;

import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[][] map = new boolean[n][n];
        boolean[] visited = new boolean[n];

        for (int[] e : edge) {
            int first = e[0] - 1;
            int second = e[1] - 1;
            map[first][second] = true;
            map[second][first] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for(int i = 0; i < qSize; i++){
                int now = queue.poll();
                for (int j = 1; j < n; j++) {
                    if (!visited[j] && map[j][now]) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
            answer = qSize;
        }

        return answer;
    }
}
