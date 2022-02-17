package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q20004 {   // 베스킨라빈스 31
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int n = 1; n <= a; n++) {
            if (30 % (n + 1) == 0) sb.append(n).append('\n');
        }
        System.out.println(sb);
    }
}
