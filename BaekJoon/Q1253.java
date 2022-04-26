package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1253 {    // 좋다
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (isOk(i)) answer++;
        }
        System.out.println(answer);
    }

    static boolean isOk(int i) {
        int left = 0, right = n - 1;
        while (true) {
            if (left == i) left++;
            if (right == i) right--;
            if (left >= right) break;

            int temp = arr[left] + arr[right];
            if (temp < arr[i]) left++;
            else if (temp > arr[i]) right--;
            else return true;   // temp == arr[i]
        }
        return false;
    }
}
