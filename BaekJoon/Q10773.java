package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10773 {   // 제로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < k; i++){
            int now = Integer.parseInt(br.readLine());
            if(now == 0) stack.pop();
            else stack.add(now);
        }

        int ans = 0;
        while(!stack.isEmpty())
            ans += stack.pop();

        System.out.println(ans);
    }
}
