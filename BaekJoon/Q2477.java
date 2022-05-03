package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2477 {    // 참외밭
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] direct = new int[6];
        int[] distance = new int[6];
        int maxY = 0, minY = 0, maxX = 0, minX = 0;
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            direct[i] = Integer.parseInt(st.nextToken());
            distance[i] = Integer.parseInt(st.nextToken());
            if (direct[i] == 1 || direct[i] == 2)
                maxX = Math.max(maxX, distance[i]);
            else maxY = Math.max(maxY, distance[i]);
        }

        for (int i = 0; i < 6; i++) {
            int before = (i + 5) % 6;
            int next = (i + 1) % 6;
            if (direct[before] == direct[next]) {
                if (direct[i] == 1 || direct[i] == 2)
                    minX = distance[i];
                else minY = distance[i];
            }
        }

        System.out.println(k * (maxY * maxX - minY * minX));
    }
}
