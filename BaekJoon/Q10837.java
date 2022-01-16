package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10837 {   // 동전 게임
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        while (c-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int yh = Integer.parseInt(st.nextToken());
            int cs = Integer.parseInt(st.nextToken());
            boolean flag = false;
            int opp = k - Math.max(yh, cs);
            int diff = Math.abs(yh - cs);
            if (yh > cs && diff <= opp + 2) flag = true;
            else if (yh < cs && diff <= opp + 1) flag = true;
            else if (yh == cs) flag = true;
            sb.append(flag ? 1 : 0).append('\n');
        }
        System.out.println(sb);
    }
}
