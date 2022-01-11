package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13251 {   // 조약돌 꺼내기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = 0;
        int[] arr = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            n += arr[i];
        }
        int k = Integer.parseInt(br.readLine());

        double answer = 0;
        for (int i = 0; i < m; i++) {
            if (arr[i] < k) continue;

            double percent = (double) arr[i] / n;
            for (int j = 1; j < k; j++) {
                percent *= (double) (arr[i] - j) / (n - j);
            }

            answer += percent;
        }
        System.out.println(answer);
    }
}
