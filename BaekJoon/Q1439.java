package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1439 {    // 뒤집기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        char last = s[0];
        int cnt0 = 0, cnt1 = 0;
        for (int i = 1; i < s.length; i++) {
            if (last != s[i]) {
                if (last == '0') cnt0++;
                else cnt1++;
                last = s[i];
            }
        }

        if (last == '0') cnt0++;
        else cnt1++;
        System.out.println(Math.min(cnt0, cnt1));
    }
}
