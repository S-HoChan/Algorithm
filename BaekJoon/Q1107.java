package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1107 {    // 리모컨
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int answer = Math.abs(n - 100); // 상하이동 횟수
        for (int i = 0; i <= 999999; i++) {  // 6자리
            int temp = cal(i);  // 숫자버튼 누르는 횟수
            if (temp > 0) {
                answer = Math.min(answer, temp + Math.abs(n - i));
            }
        }
        System.out.println(answer);
    }

    static int cal(int n) {
        if (n == 0) {
            if (broken[0]) return 0;
            else return 1;
        } else {
            int cnt = 0;
            while (n > 0) {
                if (broken[n % 10]) return 0;
                n /= 10;
                cnt += 1;
            }
            return cnt;
        }
    }
}
