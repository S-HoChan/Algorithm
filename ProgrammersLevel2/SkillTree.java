package ProgrammersLevel2;

public class SkillTree {
    public static void main(String[] args) {

    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] ski = new char[skill.length()];

        for (int i = 0; i < skill.length(); i++) {
            ski[i] = skill.charAt(i);
        }

        for (String skill_tree : skill_trees) {  // 스킬 트리 문자열 접근
            int poi = 0;
            char[] queue = new char[skill.length()];
            for (int j = 0; j < skill_tree.length(); j++) { // 문자열 개별 접근
                for (char c : ski) {    // 스킬트리와 관련된 스킬만 큐에 삽입
                    if (c == skill_tree.charAt(j)) {
                        queue[poi++] = skill_tree.charAt(j);
                    }
                }
            }

            int chk = 0;
            for(int i = 0; i < poi; i++){
                if(ski[i] == queue[i]) chk++;
                else break;
            }
            if (chk == poi) answer++;
        }

        return answer;
    }
}
