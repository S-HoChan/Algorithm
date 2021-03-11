package ProgrammersLevel2;

public class Joystick {
    public static void main(String[] args) {

    }

    public int solution(String name) {
        int answer = 0;
        int min = name.length() - 1;    // 좌 -> 우

        for (int i = 0; i < name.length(); i++) {   // up, down
            int move = 0;
            if (name.charAt(i) <= 'N') {
                move = name.charAt(i) - 'A';
            } else {
                move = 'Z' - name.charAt(i) + 1;
            }
            if (move == 0) {
                int idx = i;
                while(idx < name.length() && name.charAt(idx) == 'A'){
                    idx++;
                }
                int mCnt = (i-1) * 2 + name.length() - idx;
                min = Math.min(min, mCnt);
            }
            answer += move;
        }
        answer += min;

        return answer;
    }
}
