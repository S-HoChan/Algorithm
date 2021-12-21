package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5347 {    // LCM
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int m = Math.max(a, b);
            int n = Math.min(a, b);
            while (n > 0) {
                int temp = n;
                n = m % n;
                m = temp;
            }
            long answer = (long) a * b / m;
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
