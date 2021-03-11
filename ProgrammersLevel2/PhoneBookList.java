package ProgrammersLevel2;

import java.util.Arrays;

public class PhoneBookList {
    public static void main(String[] args) {

    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        for (String phone : phone_book) {
            for (String p_phone : phone_book) {
                if (phone.length() > p_phone.length() || phone.equals(p_phone)) continue;
                if (phone.equals(p_phone.substring(0, phone.length()))) {
                    answer = false;
                    return answer;
                }
            }
        }

        return answer;
    }
}
