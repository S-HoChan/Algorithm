package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1052 {    // 물병
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;
        while (true) {
            char[] binary = Integer.toBinaryString(n).toCharArray();
            int cnt = 0;

            for (int i = 0; i < binary.length; i++) {
                if (binary[i] == '1') cnt++;
            }

            if (cnt <= k) {
                System.out.println(answer);
                break;
            }

            n++;
            answer++;
        }
    }
}
