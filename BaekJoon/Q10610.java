package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q10610 {   // 30
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = 0; i < n.length(); i++) {
            int now = n.charAt(i) - '0';
            count += now;
            if (map.containsKey(now)) {
                map.put(now, map.get(now) + 1);
            } else {
                map.put(now, 1);
            }
        }

        if (count % 3 != 0 || !map.containsKey(0)){
            sb.append(-1);
        } else{
            for(int num = 9; num >= 0; num--){
                if(!map.containsKey(num)) continue;
                for(int cnt = 0; cnt < map.get(num); cnt++){
                    sb.append(num);
                }
            }
        }
        System.out.println(sb);
    }
}
