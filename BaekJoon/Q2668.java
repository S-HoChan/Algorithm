package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2668 {    // 숫자고르기
    static List<Integer> list = new LinkedList<>();
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        System.out.println(list.size());
        list.sort(null);
        for (int num : list) {
            System.out.println(num);
        }
    }

    static void dfs(int start, int target) {
        int next = arr[start];
        if (next == target) {
            list.add(target);
            return;
        }
        if (visited[next]) return;

        visited[next] = true;
        dfs(next, target);
        visited[next] = false;
    }
}
