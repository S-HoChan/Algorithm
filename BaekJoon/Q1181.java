package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1181 {    // 단어 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            else return o1.length() - o2.length();
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i].equals(arr[i - 1])) continue;

            sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);
    }
}