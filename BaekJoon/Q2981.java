package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2981 {    // 검문
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        int gcdVal = arr[1] - arr[0];   // 양수
        for (int i = 2; i < n; i++) {
            gcdVal = gcd(gcdVal, arr[i] - arr[i - 1]);
        }

        for (int i = 2; i <= gcdVal / 2; i++) {
            if (gcdVal % i == 0)
                sb.append(i + " ");
        }
        sb.append(gcdVal);

        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
