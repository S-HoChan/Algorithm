package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1769 {    // 3의 배수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        int count = 0;
        while (x.length() > 1) {
            count++;
            int total = 0;
            for (int i = 0; i < x.length(); i++)
                total += x.charAt(i) - '0';
            x = String.valueOf(total);
        }
        System.out.println(count);
        System.out.println(Integer.parseInt(x) % 3 == 0 ? "YES" : "NO");
    }
}
