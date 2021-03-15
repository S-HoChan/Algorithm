package ProgrammersLevel2;

public class CountingAfterQuadCompression {
    static int cnt0 = 0;
    static int cnt1 = 0;
    static int[][] dp;

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        dp = arr;
        dfs(arr.length, 0, 0);
        answer[0] = cnt0;
        answer[1] = cnt1;
        return answer;
    }

    public static void dfs(int n, int y, int x) {
        // 크기가 1인 경우
        if (n == 1) {
            if (dp[y][x] == 1) cnt1++;
            else cnt0++;
            return;
        }

        // 합칠 수 있는지 판단
        if (isSame(n, y, x)) {
            if (dp[y][x] == 1) cnt1++;
            else cnt0++;
            return;
        }

        // 합칠 수 없을경우 분할
        n /= 2;
        dfs(n, y, x);
        dfs(n, y + n, x);
        dfs(n, y, x + n);
        dfs(n, y + n, x + n);
    }

    public static boolean isSame(int n, int y, int x) {
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (dp[i][j] != dp[y][x]) return false;
            }
        }
        return true;
    }
}
