package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1707 {    // 이분 그래프
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            boolean[][] map = new boolean[v][v];
            while(e-- > 0){
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                map[first][second] = true;
                map[second][first] = true;
            }

            // todo.
        }
    }
}
