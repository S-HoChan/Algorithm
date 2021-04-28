package ProgrammersLevel4;

public class Thievery {
    public int solution(int[] money) {
        int[][] tot = new int[money.length][2]; // 첫 집을 턴다, 안 턴다
        tot[0][0] = money[0];   // 첫 집을 턴 경우
        tot[1][0] = money[0];
        tot[0][1] = 0;
        tot[1][1] = money[1];

        for (int i = 2; i < money.length - 1; i++) {
            tot[i][0] = Math.max(tot[i - 2][0] + money[i], tot[i - 1][0]);
            tot[i][1] = Math.max(tot[i - 2][1] + money[i], tot[i - 1][1]);
        }
        tot[money.length - 1][0] = tot[money.length - 2][0];
        tot[money.length - 1][1] = Math.max(tot[money.length - 3][1] + money[money.length - 1], tot[money.length - 2][1]);

        return Math.max(tot[money.length - 1][0], tot[money.length - 1][1]);
    }
}
