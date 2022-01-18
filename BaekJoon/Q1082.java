package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1082 {    // 방 번호
    // 예제? 문제?가 좀 이상하다 (질문하기 참조 풀이)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int minCost = 51;
        int idx = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (minCost >= arr[i]) {
                minCost = arr[i];
                idx = i;
            }
        }

        int m = Integer.parseInt(br.readLine());
        char[] digit = new char[51];
        int cnt = 0;
        while (m >= minCost) {
            digit[cnt++] = (char) (idx + '0');
            m -= minCost;
        }

        int start = 0;
        for (int i = 0; i < cnt; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j] <= m + minCost) {    // 더 큰 숫자로 대신 산다.
                    digit[i] = (char) (j + '0');
                    m += minCost - arr[j];
                    break;
                }
            }

            if (digit[start] == '0') {    // 더 큰 숫자를 살 수 없다.
                start++;
                m += minCost;
            }   // 자릿수 1개를 포기하고 minCost만큼을 돌려받는다.
        }

        if (start == cnt) System.out.println(0);
        else {
            String answer = "";
            for (int i = start; i < cnt; i++) answer += digit[i];
            System.out.println(answer);
        }
    }
}
