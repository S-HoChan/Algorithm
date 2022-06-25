package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14653 {   // 너의 이름은
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n];
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken()) - 1;
        int[] count = new int[k];
        int[] people = new int[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            count[i] = Integer.parseInt(st.nextToken());
            people[i] = st.nextToken().charAt(0) - 'A';
        }

        if (count[q] == 0) {
            System.out.println(-1);
            return;
        }

        for (int i = k - 1; i >= q; i--)
            visited[people[i]] = true;

        for (int i = q; i > 0; i--) {
            if (count[i] != count[i - 1]) break;
            visited[people[i]] = true;
            visited[people[i - 1]] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            if (!visited[i])
                sb.append((char) (i + 'A')).append(' ');
        }
        System.out.println(sb);
    }
}
