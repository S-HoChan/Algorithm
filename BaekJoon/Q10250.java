package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int row = n % height == 0 ? height : n % height;    // 층수
            int col = n % height == 0 ? n / height : n / height + 1;   // 호수
            System.out.println(String.format("%d%02d", row, col));
        }
    }
}
