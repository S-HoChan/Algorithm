package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3360 {    // 깡총깡총
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; 3 * i <= n; i++) {
            // 2와 1로 이루어진 개수
            // + 1은 1로만 이루어진 개수
            answer += (n - 3 * i) / 2 + 1;
            answer %= 1_000_000;
        }
        System.out.println(answer % 1_000_000);
    }
}
