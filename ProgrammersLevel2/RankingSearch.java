package ProgrammersLevel2;

public class RankingSearch {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        String[][] _query = new String[query.length][5];
        for (int i = 0; i < query.length; i++) {
            String[] temp = query[i].split(" ");
            _query[i][0] = temp[0];
            _query[i][1] = temp[2];
            _query[i][2] = temp[4];
            _query[i][3] = temp[6];
            _query[i][4] = temp[7];
        }

        for (String _info : info) {
            String[] information = _info.split(" ");
            // 언어, 직군, 경력, 소울푸드, 점수
            for (int j = 0; j < query.length; j++) {    // j번째 query문
                int chk = 0;
                for (int i = 0; i < 4; i++) {
                    if (!(_query[j][i].equals("-") || information[i].equals(_query[j][i]))) break;
                    if (i == 3) chk++;
                }

                if (chk == 0) continue;
                int info_score = Integer.parseInt(information[4]);
                int query_score = Integer.parseInt(_query[j][4]);
                if (info_score >= query_score) answer[j]++;
            }
        }

        return answer;
    }
}
