package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q9322 {    // 철벽 보안 알고리즘
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());  // 1st public key
            for (int i = 0; i < n; i++) {
                map.put(st.nextToken(), i);
            }
            st = new StringTokenizer(br.readLine()); // 2nd public key
            for (int i = 0; i < n; i++) {
                arr[i] = map.get(st.nextToken());
            }
            String[] temp = new String[n];
            st = new StringTokenizer(br.readLine());    // cryptogram
            for (int i = 0; i < n; i++) {
                temp[arr[i]] = st.nextToken();
            }
            for (String now : temp)
                sb.append(now).append(' ');
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
