package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10989 {   // 수 정렬하기 3
    public static void main(String[] args) throws IOException {
        int[] cnt = new int[10001]; // 수 범위 : 0 ~ 10000

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            cnt[Integer.parseInt(br.readLine())]++; // 해당 인덱스의 값을 증가
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) { // 입력범위 1 ~ 10000
            while (cnt[i] > 0) {
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }

        System.out.println(sb);
    }
}
