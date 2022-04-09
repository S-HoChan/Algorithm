package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14405 {   // 피카츄
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int idx = 0;
        while (idx < s.length()) {
            if (idx + 3 <= s.length() && s.startsWith("chu", idx)) idx += 3;
            else if (idx + 2 <= s.length() && (s.startsWith("pi", idx) || s.startsWith("ka", idx))) idx += 2;
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
