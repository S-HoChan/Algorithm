package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2470 {    // 두 용액
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int first = Integer.MAX_VALUE, second = Integer.MIN_VALUE;
        int last = Integer.MAX_VALUE;
        int left = 0, right = n - 1;
        while (left < right) {
            int temp = arr[left] + arr[right];
            if (Math.abs(temp) < last) {
                first = arr[left];
                second = arr[right];
                last = Math.abs(temp);
            }

            if (temp > 0) right--;
            else left++;
        }

        System.out.println(first + " " + second);
    }
}
