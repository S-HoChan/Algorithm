package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1063 {    // 킹
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] kingLocate = st.nextToken().toCharArray();
        int kingY = kingLocate[1] - '1';
        int kingX = kingLocate[0] - 'A';
        char[] rockLocate = st.nextToken().toCharArray();
        int rockY = rockLocate[1] - '1';
        int rockX = rockLocate[0] - 'A';
        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            int move = stringToInt(br.readLine());
            int nky = kingY + dy[move];
            int nkx = kingX + dx[move];
            if (nky < 0 || nky >= 8 || nkx < 0 || nkx >= 8) continue;

            if (nky == rockY && nkx == rockX) {
                int nry = rockY + dy[move];
                int nrx = rockX + dx[move];
                if (nry < 0 || nry >= 8 || nrx < 0 || nrx >= 8) continue;

                rockY = nry;
                rockX = nrx;
            }
            kingY = nky;
            kingX = nkx;
        }
        char kx = (char) (kingX + 'A');
        char rx = (char) (rockX + 'A');
        StringBuilder sb = new StringBuilder();
        sb.append(kx).append(kingY + 1).append('\n');
        sb.append(rx).append(rockY + 1);
        System.out.println(sb);
    }

    static int stringToInt(String s) {
        if (s.equals("T")) return 0;
        else if (s.equals("RT")) return 1;
        else if (s.equals("R")) return 2;
        else if (s.equals("RB")) return 3;
        else if (s.equals("B")) return 4;
        else if (s.equals("LB")) return 5;
        else if (s.equals("L")) return 6;
        else return 7;  // LT
    }
}
