package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17427 {   // 약수의 합 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 0;

        for (int i = 1; i <= n; i++)
            answer += (long) i * (n / i);
        System.out.println(answer);
    }
}
