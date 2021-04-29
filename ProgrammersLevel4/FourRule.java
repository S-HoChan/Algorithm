package ProgrammersLevel4;

public class FourRule {
    int[][] dp;

    public int solution(String arr[]) {
        int n = arr.length;
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
            if (i % 2 == 0) dp[i][i] = Integer.parseInt(arr[i]);
        }

        return solve(arr, 0, n - 1);
    }

    public int solve(String[] arr, int i, int j) {   // i ~ j 연산
        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        if (i - 1 >= 1 && arr[i - 1].equals("-")) { // - 연산
            int result = Integer.MAX_VALUE;
            for (int k = i; k < j; k += 2) {
                if (arr[k + 1].equals("-"))
                    result = Math.min(result, solve(arr, i, k) - solve(arr, k + 2, j));
                else result = Math.min(result, solve(arr, i, k) + solve(arr, k + 2, j));
            }
            dp[i][j] = result;
        } else { // + 연산
            int result = Integer.MIN_VALUE;
            for (int k = i; k < j; k += 2) {
                if (arr[k + 1].equals("-"))
                    result = Math.max(result, solve(arr, i, k) - solve(arr, k + 2, j));
                else result = Math.max(result, solve(arr, i, k) + solve(arr, k + 2, j));
            }
            dp[i][j] = result;
        }
        return dp[i][j];
    }
}
