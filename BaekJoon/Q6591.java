package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6591 {    // 이항 쇼다운
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if (n == 0 && k == 0) break;
            if (n == 0 || k == 0) {
                sb.append(1).append('\n');
                continue;
            }

            long answer = 1;
            if (k > n - k) k = n - k;
            for (int i = 0; i < k; i++) {
                answer *= (n - i);
                answer /= (i + 1);
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
