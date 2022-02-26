package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q8979 {    // 올림픽
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Country[] arr = new Country[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Country(num, g, s, b);
        }

        Arrays.sort(arr, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                if (o1.gold > o2.gold) return -1;
                else if (o1.gold < o2.gold) return 1;
                else {
                    if (o1.silver > o2.silver) return -1;
                    else if (o1.silver < o2.silver) return 1;
                    else {
                        if (o1.bronze > o2.bronze) return -1;
                        else if (o1.bronze < o2.bronze) return 1;
                        else return 0;
                    }
                }
            }
        });

        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i].num == k) {
                answer = i;
                for (int j = i - 1; j >= 0; j--) {
                    if (isSame(arr[i], arr[j])) {
                        answer = j;
                    } else break;
                }
                System.out.println(answer + 1); // 인덱스 + 1 => 등수
                return;
            }
        }
    }

    static boolean isSame(Country c1, Country c2) {
        return c1.gold == c2.gold && c1.silver == c2.silver && c1.bronze == c2.bronze;
    }

    static class Country {
        int num;
        int gold;
        int silver;
        int bronze;

        Country(int n, int g, int s, int b) {
            this.num = n;
            this.gold = g;
            this.silver = s;
            this.bronze = b;
        }
    }
}
