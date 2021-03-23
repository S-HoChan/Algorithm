package ProgrammersLevel3;

import java.util.Arrays;

public class GPS {  // todo. 해결하지 못한 문제
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < edge_list.length; i++) {
            int start = edge_list[i][0] - 1;
            int end = edge_list[i][1] - 1;
            map[start][end] = true;
            map[end][start] = true;
        }

        int[][] dp = new int[k][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], k + 1);  // k + 1 : 불가능
        }
        dp[0][gps_log[0] - 1] = 0;

        for (int i = 1; i < k; i++) {   // i 번째 이동
            for (int j = 0; j < n; j++) {   // j 위치로
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);

                for (int l = 0; l < n; l++) {
                    if (map[j][l]) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][l]);
                    }
                }

                if (gps_log[i] == j) dp[i][j] += 1;
            }
        }

        if (dp[k - 1][gps_log[k - 1] - 1] >= k + 1) return -1;
        return dp[k-1][gps_log[k-1] - 1];
    }
}
