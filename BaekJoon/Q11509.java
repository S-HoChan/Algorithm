package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q11509 {   // 풍선 맞추기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int now = arr[i];
            if (list.contains(now)) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == now) {
                        if (list.get(j) == 1) {
                            answer++;
                            list.remove(j);
                        } else {
                            list.set(j, now - 1);
                        }
                        break;
                    }
                }
            } else {
                list.add(now - 1);
            }
        }
        answer += list.size();
        System.out.println(answer);
    }
}
