package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2108 {    // 통계학
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    // n은 홀수
        int sum = 0;    // 산술평균을 위한 합계
        int[] cnt = new int[8001]; // 카운팅 배열
        int min = 4001, max = -4001;    // 범위를 위한 최소값, 최대값
        int median = 0, mode = 0;   // 중앙값, 최빈값
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            cnt[num + 4000]++;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int count = 0;  // 중앙값 빈도 누적 수
        int modeMax = 0;    // 최빈값의 최대값
        boolean flag = false;   // 최빈값이 1번만 등장한 경우 true
        for (int i = min + 4000; i <= max + 4000; i++) {
            if (cnt[i] > 0) {
                if (count < (n + 1) / 2) {  // 중앙값 찾기
                    count += cnt[i];
                    median = i - 4000;
                }

                if (modeMax < cnt[i]) { // 이전 빈도수보다 더 많은 경우
                    modeMax = cnt[i];
                    mode = i - 4000;
                    flag = true;
                } else if (modeMax == cnt[i] && flag) {  // 두 번째로 작은 최빈값
                    mode = i - 4000;
                    flag = false;
                }
            }
        }

        System.out.println((int) Math.round((double) sum / n));  // 산술평균
        System.out.println(median); // 중앙값 출력
        System.out.println(mode);   // 최빈값 출력
        System.out.println(max - min);  // 범위 출력
    }
}