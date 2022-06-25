package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1092 {    // 배
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> cranes = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            cranes.add(Integer.parseInt(st.nextToken()));
        int m = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>(m);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++)
            boxes.add(Integer.parseInt(st.nextToken()));

        cranes.sort(Comparator.reverseOrder());
        boxes.sort(Comparator.reverseOrder());
        if (cranes.get(0) < boxes.get(0)) System.out.println(-1);
        else {
            int answer = 0;
            while (!boxes.isEmpty()) {
                int craneIdx = 0, boxIdx = 0;
                while (boxIdx < boxes.size() && craneIdx < cranes.size()) {
                    if (cranes.get(craneIdx) >= boxes.get(boxIdx)) {
                        boxes.remove(boxIdx);
                        craneIdx++;
                    } else boxIdx++;
                }
                answer++;
            }
            System.out.println(answer);
        }
    }
}
