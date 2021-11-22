package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6064 {    // 카잉 달력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int z = Integer.parseInt(br.readLine());
        while (z-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = m * n / gcd(m, n);
            int ans = -1;
            for (int i = 0; i * m < lcm; i++) {
                if ((i * m + x - y) % n == 0) {
                    ans = i * m + x;
                    break;
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static int gcd(int n1, int n2) {
        if (n2 == 0) return n1;
        return gcd(n2, n1 % n2);
    }
}
