package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q20551 {   // Sort 마스터 배지훈의 후계자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            set.add(arr[i]);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int answer = -1;
        while (m-- > 0) {
            int now = Integer.parseInt(br.readLine());
            if (!set.contains(now)) {
                sb.append(-1).append('\n');
                continue;
            }
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] < now) {
                    left = mid + 1;
                } else {
                    answer = mid;
                    right = mid - 1;
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
