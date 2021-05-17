package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11066 {   // 파일 합치기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int _t = 0; _t < t; _t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[n][n];
            int[] sum = new int[n];
            sum[0] = arr[0];
            for (int i = 1; i < n; i++) {
                sum[i] = sum[i - 1] + arr[i];
            }

            for (int i = 0; i < n - 1; i++) {
                dp[i][i + 1] = arr[i] + arr[i + 1]; // 인접한 두 파일의 합 저장
            }

            for (int j = 2; j < n; j++) {   // col
                for (int i = 0; i + j < n; i++) {   // row
                    for (int k = i; k < i + j; k++) {
                        if (dp[i][i + j] == 0)
                            dp[i][i + j] = dp[i][k] + dp[k + 1][i + j] + sumDist(sum, i, i + j);
                        else
                            dp[i][i + j] = Math.min(dp[i][i + j], dp[i][k] + dp[k + 1][i + j] + sumDist(sum, i, i + j));
                    }
                }
            }

            sb.append(dp[0][n - 1]).append('\n');
        }

        System.out.println(sb);
    }

    private static int sumDist(int[] sum, int start, int end) { // start ~ end의 총 합
        if (start == 0) return sum[end];
        else return sum[end] - sum[start - 1];
    }
}
