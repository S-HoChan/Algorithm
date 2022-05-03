package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1074 {    // Z
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int answer = 0;
        while (n-- > 0) {
            int temp = (int) Math.pow(2, n);
            if (r >= temp) {
                answer += temp * temp * 2;
                r -= temp;
            }
            if (c >= temp) {
                answer += temp * temp;
                c -= temp;
            }
        }
        System.out.println(answer);
    }
}
