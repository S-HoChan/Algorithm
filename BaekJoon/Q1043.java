package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1043 {    // 거짓말
    // todo. outOfBoundsException
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] known = new boolean[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= m; i++) parent[i] = i;
        st = new StringTokenizer(br.readLine());
        int knowNum = Integer.parseInt(st.nextToken());
        if (knowNum > 0) {
            for (int i = 0; i < knowNum; i++) {
                known[Integer.parseInt(st.nextToken())] = true;
            }
        }

        List<Integer>[] party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partyPeople = Integer.parseInt(st.nextToken());
            int now, pre = Integer.parseInt(st.nextToken()) - 1;
            party[i].add(pre);
            for (int j = 1; j < partyPeople; j++) {
                now = Integer.parseInt(st.nextToken());
                party[i].add(now);
                union(pre, now);
                pre = now;
            }
        }

        for (int i = 1; i < known.length; i++)
            if (known[i]) known[find(i)] = true;

        int answer = 0;
        for (List<Integer> list : party) {
            if (list.size() > 0 && !known[list.get(0)]) answer++;
        }
        System.out.println(answer);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a > b) parent[a] = b;
            else parent[b] = a;
            return true;
        }
        return false;
    }

    static int find(int x) {
        if (parent[x] == x) return parent[x] = x;
        else return find(parent[x]);
    }
}
