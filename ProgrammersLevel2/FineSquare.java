package ProgrammersLevel2;

public class FineSquare {
    public static void main(String[] args) {

    }

    public long solution(int w, int h) {
        int M = w > h ? w : h;  // Max
        int m = w < h ? w : h;  // min
        int gcd = 1;    // 최대공약수
        long answer = (long) M * m;

        for (int i = 2; i <= m; i++) {
            if (M % i == 0 && m % i == 0) gcd = i;
        }
        if (gcd == 1) {
            answer -= (M + m - 1);
        } else {
            answer = answer - answer / gcd + solution(M / gcd, m / gcd) * gcd;
        }

        return answer;
    }
}
