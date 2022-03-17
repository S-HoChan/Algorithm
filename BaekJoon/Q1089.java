package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1089 {    // 스타트링크 타워
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[5][4 * n - 1];
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        List<List<Integer>> list = new ArrayList<>(n);
        int count = 1;
        for (int i = 0; i < 4 * n - 1; i += 4) {
            list.add(new ArrayList<>(10));
            if (map[1][i + 1] == '#' || map[3][i + 1] == '#') {
                System.out.println(-1);
                return;
            }

            for (int num = 0; num <= 9; num++) {
                if (isOk(i, num)) {
                    list.get(i / 4).add(num);
                }
            }

            count *= list.get(i / 4).size();
        }

        if (count == 0) {
            System.out.println(-1);
            return;
        }

        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                sum += list.get(i).get(j) * (count / list.get(i).size()) * (long) Math.pow(10, list.size() - 1 - i);
            }
        }
        System.out.println((double) sum / count);
    }

    static boolean isOk(int i, int num) {
        if (num == 0) {
            return map[2][i + 1] == '.';
        } else if (num == 1) {
            for (int y = 0; y < 5; y++) {
                for (int x = i; x < i + 2; x++) {
                    if (map[y][x] == '#') return false;
                }
            }
            return true;
        } else if (num == 2) {
            return map[1][i] == '.' && map[3][i + 2] == '.';
        } else if (num == 3) {
            return map[1][i] == '.' && map[3][i] == '.';
        } else if (num == 4) {
            return map[0][i + 1] == '.' && map[3][i] == '.'
                    && map[4][i] == '.' && map[4][i + 1] == '.';
        } else if (num == 5) {
            return map[1][i + 2] == '.' && map[3][i] == '.';
        } else if (num == 6) {
            return map[1][i + 2] == '.';
        } else if (num == 7) {
            for (int y = 1; y < 5; y++) {
                for (int x = i; x < i + 2; x++) {
                    if (map[y][x] == '#') return false;
                }
            }
            return true;
        } else if (num == 8) return true;
        else {  // num == 9
            return map[3][i] == '.';
        }
    }
}
