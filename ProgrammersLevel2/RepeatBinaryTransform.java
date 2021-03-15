package ProgrammersLevel2;

public class RepeatBinaryTransform {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int res1 = 0;
        int cnt1 = 0, cnt0 = 0;

        while (!s.equals("1")) {
            res1++;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') cnt0++;
                else cnt1++;
            }

            s = "";
            while (cnt1 > 0) {
                if (cnt1 % 2 == 0) s = "0" + s;
                else s = "1" + s;
                cnt1 /= 2;
            }
        }

        answer[0] = res1;
        answer[1] = cnt0;
        return answer;
    }
}
