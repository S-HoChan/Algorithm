package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1740 {    // 거듭제곱
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringBuilder nTo2 = new StringBuilder();
        while (n > 0) {
            nTo2.append(n % 2);
            n /= 2;
        }
        char[] temp = nTo2.toString().toCharArray();
        long answer = 0, now = 1;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == '1')
                answer += now;
            now *= 3;
        }
        System.out.println(answer);
    }
}
