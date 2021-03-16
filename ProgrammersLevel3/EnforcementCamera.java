package ProgrammersLevel3;

import java.util.Arrays;
import java.util.Comparator;

public class EnforcementCamera {
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int min = routes[0][0];
        int max = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            int in = routes[i][0];
            int out = routes[i][1];

            if (in > max || out < min) {
                answer++;
                max = out;
                min = in;
            } else {
                min = Math.max(in, min);
                max = Math.min(out, max);
            }
        }

        return answer;
    }
}
