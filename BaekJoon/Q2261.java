package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2261 {    // 가장 가까운 두 점 // todo. 정확성 실패
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][2];    // (x, y)
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        System.out.println(divCon(0, n - 1));
    }

    private static int divCon(int left, int right) {
        if (right - left + 1 <= 3) return bruteForce(left, right);  // size <= 3

        int mid = (left + right) / 2;
        int minDist = Math.min(divCon(left, mid), divCon(mid + 1, right));

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = left; i <= right; i++) { // mid를 걸친 점에 대한 처리
            int xDist = arr[i][0] - arr[mid][0];
            if (xDist * xDist < minDist) list.add(arr[i]);
        }

        Collections.sort(list, Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int yDist = list.get(j)[1] - list.get(i)[1];
                if (yDist * yDist < minDist) {
                    Math.min(minDist, getDistance(list.get(i), list.get(j)));
                }
            }
        }
        return minDist;
    }

    private static int bruteForce(int left, int right) { // 무차별 대입
        int min = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            for (int j = i + 1; j <= right; j++) {
                min = Math.min(min, getDistance(arr[i], arr[j]));
            }
        }
        return min;
    }

    private static int getDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
