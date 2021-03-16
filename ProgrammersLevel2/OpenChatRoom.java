package ProgrammersLevel2;

import java.util.HashMap;

public class OpenChatRoom {
    public String[] solution(String[] record) {
        HashMap<String, String> hashMap = new HashMap<>();  // id, nickname
        String[] user = new String[record.length];
        String[] actvit = new String[record.length];
        int cnt = 0;

        for (int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");
            String activity = temp[0];
            String userId = temp[1];

            user[i] = userId;
            if (activity.equals("Enter")) {
                actvit[i] = "들어왔습니다.";
                cnt++;
            } else if (activity.equals("Leave")) {
                actvit[i] = "나갔습니다.";
                cnt++;
            } else {
                actvit[i] = ".";
            }

            if (activity.equals("Enter") || activity.equals("Change")) {
                String userNickname = temp[2];
                hashMap.put(userId, userNickname);
            }
        }

        String[] answer = new String[cnt];

        int j = 0;
        for (int i = 0; i < record.length; i++) {
            if (actvit[i].equals(".")) continue;
            answer[j++] = hashMap.get(user[i]) + "님이 " + actvit[i];
        }

        return answer;
    }
}
