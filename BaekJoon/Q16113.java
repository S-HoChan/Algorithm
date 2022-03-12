package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q16113 {   // 시그널
    static char[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine()) / 5;
        String signal = br.readLine();
        map = new char[5][n];
        for (int i = 0; i < 5; i++) {
            map[i] = signal.substring(n * i, n * (i + 1)).toCharArray();
        }
        int idx = 0;
        while (idx < n) {
            int num = getNum(idx);
            if (num > 1 || num == 0) {
                sb.append(num);
                idx += 3;
                continue;
            } else if (num == 1) {
                sb.append(num);
            }
            idx++;
        }
        System.out.println(sb);
    }

    static int getNum(int x) {
        if (map[0][x] == '.') return -1; // blank

        if (map[1][x] == '.') {   // 2, 3, 7
            if (map[2][x] == '.') return 7;
            if (map[3][x] == '#') return 2;
            return 3;
        } else if (x >= n - 2)
            return 1;
        else if (map[0][x + 1] == '.') {   // 1, 4
            if (map[3][x] == '#') return 1;
            return 4;
        } else if (map[1][x + 2] == '.') {   // 5, 6
            if (map[3][x] == '#') return 6;
            return 5;
        } else if (map[2][x + 1] == '.')
            return 0;
        else if (map[3][x] == '#')
            return 8;
        return 9;
    }
}
