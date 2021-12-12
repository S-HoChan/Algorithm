package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2776 {    // 암기왕
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] note1 = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                note1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(note1);
            int m = Integer.parseInt(br.readLine());
            int[] note2 = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                note2[i] = Integer.parseInt(st.nextToken());
            }

            for (int num : note2) {
                if (isContain(note1, num)) {
                    sb.append(1).append('\n');
                } else sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    static boolean isContain(int[] arr, int find) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == find) return true;

            if (arr[mid] < find) {
                left = mid + 1;
            } else right = mid;
        }
        return false;
    }
}
