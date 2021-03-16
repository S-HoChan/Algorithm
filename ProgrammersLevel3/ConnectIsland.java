package ProgrammersLevel3;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectIsland {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                Integer a = o1[2];
                Integer b = o2[2];
                return a.compareTo(b);
            }
        });

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] cost : costs) {
            int firstIsland = find(cost[0]);
            int secondIsland = find(cost[1]);
            if (firstIsland != secondIsland) {
                parent[secondIsland] = firstIsland;
                answer += cost[2];
            }
        }

        return answer;
    }

    public static int find(int child) {
        if (parent[child] == child) return child;
        return parent[child] = find(parent[child]);
    }
}
