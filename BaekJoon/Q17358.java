package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17358 {   // 복불복으로 지구 멸망
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 1L;
        while (n > 2) {
            answer *= n - 1;
            n -= 2;
            answer %= 1_000_000_007;
        }
        System.out.println(answer);
    }
}
