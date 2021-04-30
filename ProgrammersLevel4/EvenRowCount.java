package ProgrammersLevel4;

public class EvenRowCount {
    int MOD = 10000019;

    int comb(int n, int r) {
        if (n < r || n == r || n == 1) return 1;
        else if (r == 1) return n;
        return (comb(n - 1, r) + comb(n - 1, r - 1)) % MOD;
    }

    public int solution(int[][] a) {    // todo. solution
        int answer = 0;
        int[] colCount = new int[a[0].length];
        int[][] dp = new int[a.length][a[0].length];

        for (int[] aRow : a) {
            for (int i = 0; i < colCount.length; i++) {
                colCount[i] += aRow[i];
            }
        }

        for (int i = 0; i < a.length; i++) {
            int temp = 1;

        }

        return answer;
    }
}
