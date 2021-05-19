package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q10828 {   // 스택
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("push")){
                stack.add(Integer.parseInt(st.nextToken()));
            } else if (order.equals("top")){
                if(stack.isEmpty()) sb.append("-1").append('\n');
                else sb.append(stack.peek()).append('\n');
            } else if (order.equals("pop")){
                if(stack.isEmpty()) sb.append("-1").append('\n');
                else sb.append(stack.pop()).append('\n');
            } else if (order.equals("size")){
                sb.append(stack.size()).append('\n');
            } else if (order.equals("empty")){
                if(stack.isEmpty()) sb.append("1").append('\n');
                else sb.append("0").append('\n');
            }
        }
        System.out.println(sb);
    }
}
