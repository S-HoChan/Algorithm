package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q3009 {    // 네 번째 점
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> widthList = new ArrayList<>();
        ArrayList<Integer> heightList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            if (widthList.contains(width)) widthList.remove(new Integer(width));
            else widthList.add(width);
            if (heightList.contains(height)) heightList.remove(new Integer(height));
            else heightList.add(height);
        }
        System.out.println(widthList.get(0) + " " + heightList.get(0));
    }
}
