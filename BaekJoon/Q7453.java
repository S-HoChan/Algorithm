package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q7453 {    // 합이 0인 네 정수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        int[] arrC = new int[n];
        int[] arrD = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrA[i] = Integer.parseInt(st.nextToken());
            arrB[i] = Integer.parseInt(st.nextToken());
            arrC[i] = Integer.parseInt(st.nextToken());
            arrD[i] = Integer.parseInt(st.nextToken());
        }

        int[] arrAB = new int[n * n];
        int[] arrCD = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrAB[idx] = arrA[i] + arrB[j];
                arrCD[idx] = arrC[i] + arrD[j];
                idx++;
            }
        }
        Arrays.sort(arrCD);

        long ans = 0;
        for (int find : arrAB) {
            int upper = upperBound(arrCD, -find);
            int lower = lowerBound(arrCD, -find);
            ans += (upper - lower);
        }
        System.out.println(ans);
    }

    static int upperBound(int[] arr, int find) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= find) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    static int lowerBound(int[] arr, int find) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < find) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
