package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10158 {   // 개미
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        int dx = (t + p) % w;
        int dy = (t + q) % h;
        int x = ((t + p) / w) % 2 == 0 ? dx : w - dx;
        int y = ((t + q) / h) % 2 == 0 ? dy : h - dy;
        sb.append(x).append(" ").append(y);
        System.out.println(sb);
    }
}
