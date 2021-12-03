package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1783 {    // 병든 나이트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int ans = 0;
        if (n == 1) {   // n이 1일 경우 이동 불가
            ans = 1;
        } else if (n == 2) {    // 2, 3번 방향으로만 이동 가능
            ans = Math.min((m + 1) / 2, 4); // 최대값은 4
        } else {
            if (m < 7) {    // m == 7 부터 4방향 이동 가능
                ans = Math.min(m, 4);
            } else ans = m - 2;
        }
        System.out.println(ans);
    }
}
