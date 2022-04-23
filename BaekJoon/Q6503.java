package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q6503 {    // 망가진 키보드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int m = Integer.parseInt(br.readLine());
            if (m == 0) break;

            int[] check = new int[128];
            char[] arr = br.readLine().toCharArray();
            int left = -1, right = -1, cnt = 0, answer = 0;
            while (left <= right) {
                if (cnt < m || (cnt == m && check[arr[right + 1]] > 0)) {
                    right++;
                    check[arr[right]]++;
                    if (check[arr[right]] == 1) cnt++;
                } else {
                    check[arr[++left]]--;
                    if (check[arr[left]] == 0) cnt--;
                }
                answer = Math.max(answer, right - left);
                if (right == arr.length - 1) break;
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
