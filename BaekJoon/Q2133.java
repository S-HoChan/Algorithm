package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2133 {    // 타일 채우기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 1) {
            System.out.println(0);
            return;
        }
        n /= 2;
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 3;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] * 3;
            for (int j = i - 2; j >= 0; j--) {
                arr[i] += arr[j] * 2;
            }
        }
        System.out.println(arr[n]);
    }
}
