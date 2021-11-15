package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String string = br.readLine();
        char[] arr = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            arr[i] = string.charAt(i);
        }

        while (n-- > 1) {
            String next = br.readLine();
            for (int i = 0; i < string.length(); i++) {
                if (arr[i] == '?') continue;

                if (arr[i] != next.charAt(i)) {
                    arr[i] = '?';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
