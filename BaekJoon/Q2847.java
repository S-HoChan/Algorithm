package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2847 {    // 게임을 만든 동준이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) System.out.println(0);
        else {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            int count = 0;
            for (int i = n - 2; i >= 0; i--) {
                int right = arr[i + 1];
                int left = arr[i];
                if (left >= right) {
                    count += left - (right - 1);
                    arr[i] = right - 1;
                }
            }

            System.out.println(count);
        }
    }
}
