package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10867 {   // 중복 빼고 정렬하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int last = -1, idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < n) {
            if (last != arr[idx]) {
                last = arr[idx];
                sb.append(last).append(' ');
            }
            idx++;
        }
        System.out.println(sb);
    }
}
