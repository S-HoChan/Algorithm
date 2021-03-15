package ProgrammersLevel2;

public class NextBigNumber {
    public int solution(int n) {
        int cnt = 0;
        int nn = n;
        while (nn > 0) {
            if (nn % 2 == 1) cnt++;
            nn /= 2;
        }

        for (int i = n + 1; i <= 1000000; i++) {
            int cnt2 = 0;
            int num = i;
            while (num > 0) {
                if (num % 2 == 1) cnt2++;
                if (cnt2 > cnt) break;
                num /= 2;
            }

            if (cnt == cnt2) return i;
        }
        return 0;
    }
}
