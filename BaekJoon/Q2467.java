package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2467 {    // 용액
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        int ansLeft = n, ansRight = -1;
        int left = 0, right = n - 1;
        while (left < right) {
            int temp = arr[left] + arr[right];
            if (Math.abs(temp) < minDiff) {
                minDiff = Math.abs(temp);
                ansLeft = left;
                ansRight = right;
            }

            if (temp < 0) left++;
            else if (temp > 0) right--;
            else break;
        }
        System.out.println(arr[ansLeft] + " " + arr[ansRight]);
    }
}
