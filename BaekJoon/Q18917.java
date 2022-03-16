package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18917 {   // 수열과 쿼리 38
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        long sum = 0;
        long xor = 0;
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            if (query == 3) sb.append(sum).append('\n');
            else if (query == 4) sb.append(xor).append('\n');
            else {
                int num = Integer.parseInt(st.nextToken());
                sum += query == 1 ? num : -num;
                xor ^= num;
            }
        }
        System.out.println(sb);
    }
}
