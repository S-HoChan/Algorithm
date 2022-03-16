package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1393 {    // 음하철도 구구팔
    static int xs, ys;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        xs = Integer.parseInt(st.nextToken());
        ys = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int xe = Integer.parseInt(st.nextToken());  // nowX
        int ye = Integer.parseInt(st.nextToken());  // nowY
        int nowDist = getDist(xe, ye);

        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());
        int gcd = gcd(dx, dy);
        dx /= gcd;
        dy /= gcd;

        int nextDist = getDist(xe + dx, ye + dy);
        while (nowDist > nextDist) {
            nowDist = nextDist;
            xe += dx;
            ye += dy;
            nextDist = getDist(xe + dx, ye + dy);
        }
        System.out.println(xe + " " + ye);
    }

    static int getDist(int x, int y) {
        return (int) Math.pow(xs - x, 2) + (int) Math.pow(ys - y, 2);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
