package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1706 {    // 크로스워드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] arr = new char[r][c];
        for (int y = 0; y < r; y++) {
            arr[y] = br.readLine().toCharArray();
        }

        PriorityQueue<String> pq = new PriorityQueue<>();
        StringBuilder sb;
        for (int y = 0; y < r; y++) {
            sb = new StringBuilder();
            for (int x = 0; x < c; x++) {
                if (arr[y][x] != '#') sb.append(arr[y][x]);
                else {
                    if (sb.length() > 1) pq.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if (sb.length() > 1) pq.add(sb.toString());
        }

        for (int x = 0; x < c; x++) {
            sb = new StringBuilder();
            for (int y = 0; y < r; y++) {
                if (arr[y][x] != '#') sb.append(arr[y][x]);
                else {
                    if (sb.length() > 1) pq.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if (sb.length() > 1) pq.add(sb.toString());
        }

        System.out.println(pq.poll());
    }
}
