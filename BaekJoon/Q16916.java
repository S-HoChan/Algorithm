package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16916 {   // 부분 문자열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String p = br.readLine();   // parent
        String s = br.readLine();   // pattern

        // KMP
        int[] table = new int[s.length()];
        int idx = 0;
        for (int i = 1; i < s.length(); i++) {
            while (idx > 0 && s.charAt(i) != s.charAt(idx)) // 일치하는 문자가 있고 더이상 일치되지 않으면
                idx = table[idx - 1];

            if (s.charAt(i) == s.charAt(idx)) {
                idx += 1;
                table[i] = idx;
            }
        }

        idx = 0;
        for (int i = 0; i < p.length(); i++) {
            while (idx > 0 && p.charAt(i) != s.charAt(idx))
                idx = table[idx - 1];

            if (p.charAt(i) == s.charAt(idx)) {
                if (idx == s.length() - 1) {
                    System.out.println(1);
                    return;
                } else idx++;
            }
        }

        System.out.println(0);
    }
}
