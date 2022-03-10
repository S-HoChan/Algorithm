package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q16198 {   // 에너지 모으기
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        dfs(list , 0);
        System.out.println(answer);
    }

    static void dfs(List<Integer> list, int sum){
        if(list.size() < 3){
            answer = Math.max(answer, sum);
            return;
        }

        for(int i = 1; i < list.size() - 1; i++){
            int temp = list.get(i);
            list.remove(i);
            dfs(list, sum+list.get(i-1) * list.get(i));
            list.add(i, temp);
        }
    }
}
