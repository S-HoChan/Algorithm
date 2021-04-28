package ProgrammersLevel4;

public class FourthTreble {
    public int solution(int n) {
        return count(n-2,2);
    }

    public int count(int n, int p) { // n은 현재 값, p는 plus의 개수
        if (n == 3 && p == 2) return 1; // 가능한 경우이므로 +1
        else if (n < 3 || Math.log(n) / Math.log(3) * 2 < p) return 0;
        else if (n == 3 && p == 3) return 0;

        return count(n - 1, p + 1) + (n % 3 == 0 && p > 1 ? count(n / 3, p - 2) : 0);
    }
}
