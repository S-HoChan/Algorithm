package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1476 {    // 날짜 계산
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());   // 1 ~ 15
        int s = Integer.parseInt(st.nextToken());   // 1 ~ 28
        int m = Integer.parseInt(st.nextToken());   // 1 ~ 19
        e = e == 15 ? 0 : e;
        s = s == 28 ? 0 : s;
        m = m == 19 ? 0 : m;

        int answer = 0;
        while (answer++ < 15 * 28 * 19 + 1) {
            if (answer % 15 == e && answer % 28 == s && answer % 19 == m) {
                System.out.println(answer);
                break;
            }
        }
    }
}
