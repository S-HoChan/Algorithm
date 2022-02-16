package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15927 {   // 회문은 회문아니야!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        if (isPalin(string)) {
            char first = string.charAt(0);
            for (int i = 1; i < string.length(); i++) {
                if (string.charAt(i) != first) {
                    System.out.println(string.length() - 1);
                    return;
                }
            }
            System.out.println(-1);
        } else System.out.println(string.length());
    }

    static boolean isPalin(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
