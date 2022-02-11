package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11561 {   // 징검다리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            int answer = (int) Math.floor((-1 + Math.sqrt(1 + 8 * n)) / 2); // 근의 공식
            /*
            long left = 0, right = n;
            long answer = 0;
            while (left <= right) {
                long mid = (left + right) / 2;
                if (mid * (mid + 1) <= n * 2) { // 등차수열의 합 n(n+1)/2
                    answer = Math.max(answer, mid);
                    left = mid + 1;
                } else right = mid - 1;

            }
             */
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
