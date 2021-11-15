package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1049 {    // 기타줄
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 6개의 값, 1개의 값
        int var6 = 1001;
        int var1 = 1001;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            var6 = Math.min(var6, Integer.parseInt(st.nextToken()));
            var1 = Math.min(var1, Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        if (var6 < var1 * 6) {
            answer += (n / 6) * var6;
            n %= 6;
            answer += Math.min(var6, n * var1);
        } else {
            answer = var1 * n;
        }

        System.out.println(answer);
    }
}
