package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1334 {    // 다음 팰린드롬 수
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = s.length();

        boolean allNine = true;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '9') {
                allNine = false;
                break;
            }
        }
        if (allNine) {
            StringBuilder answer = new StringBuilder("1");
            while (n-- > 1) {
                answer.append("0");
            }
            answer.append("1");
            System.out.println(answer);
            return;
        }

        char[] arr = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            arr[n - 1 - i] = arr[i];
        }
        if (!isBigger(s, arr)) {
            for (int i = n / 2 - 1 + n % 2; i >= 0; i--) {
                if (arr[i] == '9') {
                    arr[i] = '0';
                    arr[n - i - 1] = '0';
                } else {
                    arr[i]++;
                    arr[n - i - 1] = arr[i];
                    break;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (char c : arr) answer.append(c);
        System.out.println(answer);
    }

    static boolean isBigger(String s, char[] arr) {
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != arr[i])
                return arr[i] > s.charAt(i);
        }
        return false;
    }
}
