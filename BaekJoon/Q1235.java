package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q1235 {    // 학생 번호
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++)
            numbers[i] = br.readLine();

        int len = numbers[0].length();
        for (int k = 1; k <= len; k++) {
            Set<String> set = new HashSet<>();
            for (String number : numbers) {
                set.add(number.substring(len - k));
            }
            if (set.size() == n) {
                System.out.println(k);
                return;
            }
        }
        System.out.println(len);
    }
}
