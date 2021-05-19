package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2004 {    // 조합 0의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt5 = sol5(n) - sol5(n - m) - sol5(m);
        int cnt2 = sol2(n) - sol2(n - m) - sol2(m);
        System.out.println(Math.min(cnt5, cnt2));
    }

    private static int sol5(int n) {
        int ans = 0;
        while (n >= 5) {
            ans += n / 5;
            n /= 5;
        }
        return ans;
    }

    private static int sol2(int n) {
        int ans = 0;
        while (n >= 2) {
            ans += n / 2;
            n /= 2;
        }
        return ans;
    }
}
