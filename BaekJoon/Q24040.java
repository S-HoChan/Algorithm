package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24040 {   // 예쁜 케이크
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            sb.append(n % 9 == 0 || n % 3 == 2 ? "TAK" : "NIE").append('\n');
        }
        System.out.println(sb);
    }
}
