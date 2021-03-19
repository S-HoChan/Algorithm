package ProgrammersLevel3;

public class Change {
    public int solution(int n, int[] money) {
        int[] ans = new int[n + 1];
        ans[0] = 1;
        for (int now : money) {
            for (int i = now; i <= n; i++) {
                ans[i] += ans[i - now] % 1000000007;
            }
        }

        return ans[n] % 1000000007;
    }
}
