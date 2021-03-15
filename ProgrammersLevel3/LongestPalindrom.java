package ProgrammersLevel3;

public class LongestPalindrom {
    public static void main(String[] args) {

    }

    public int solution(String s) {
        for (int lng = s.length(); lng > 1; lng--) {
            // 시작 인덱스
            for (int start = 0; start + lng <= s.length(); start++) {
                boolean check = true;

                for (int i = 0; i < lng / 2; i++) { // check
                    if (s.charAt(start + i) != s.charAt(start + lng - 1 - i)) {
                        check = false;
                        break;
                    }
                }
                if (check) return lng;
            }
        }

        return 1;
    }

}
