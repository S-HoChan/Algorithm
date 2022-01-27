package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10453 {   // 문자열 변환
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] a = st.nextToken().toCharArray();
            char[] b = st.nextToken().toCharArray();
            int n = a.length;
            if (b.length != n) {
                sb.append(-1).append('\n');
                continue;
            }
            int answer = 0;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] == b[i]) continue;

                for (int j = i + 1; j < n; j++) {
                    if (a[j] == b[i]) {
                        char temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        answer += j - i;
                        break;
                    }
                }
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
}
