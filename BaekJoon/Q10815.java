package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10815 {   // 숫자 카드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int left = 0, right = n - 1;
            boolean flag = false;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr1[mid] == arr2[i]) {
                    flag = true;
                    break;
                } else if (arr1[mid] > arr2[i]) {
                    right = mid - 1;
                } else left = mid + 1;
            }
            if (flag) sb.append(1);
            else sb.append(0);
            sb.append(' ');
        }
        System.out.println(sb);
    }
}
