package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10703 {   // 유성
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][s];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int canDown = r + 1;
        for (int x = 0; x < s; x++) {
            boolean flag = false;   // 유성 유무
            int temp = 0;
            for (int y = 0; y < r; y++) {
                if (map[y][x] == '#') {
                    if (flag)
                        canDown = Math.min(canDown, temp);
                    break;
                } else if (map[y][x] == '.') {
                    temp++;
                } else {    // map[y][x] == 'X'
                    flag = true;
                    temp = 0;
                }
            }
        }

        char[][] after = new char[r][s];
        for (int i = 0; i < r; i++) {
            Arrays.fill(after[i], '.');
        }
        for (int x = 0; x < s; x++) {
            for (int y = 0; y < r; y++) {
                if (map[y][x] == 'X')
                    after[y + canDown][x] = 'X';
                if (map[y][x] == '#')
                    after[y][x] = '#';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < r; y++) {
            for (int x = 0; x < s; x++) {
                sb.append(after[y][x]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
