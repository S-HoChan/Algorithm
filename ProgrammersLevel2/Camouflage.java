package ProgrammersLevel2;

import java.util.LinkedList;

public class Camouflage {
    public static void main(String[] args) {

    }

    public int solution(String[][] clothes) {
        int answer = 1;
        LinkedList<Cloth> clothes_type = new LinkedList<>();

        for (String[] cloth : clothes) {
            int chk = 0;
            for (int i = 0; i < clothes_type.size(); i++) {
                if (cloth[1].equals(clothes_type.get(i).type)) {
                    clothes_type.get(i).num++;
                    chk++;
                    break;
                }
            }
            if (chk == 0) clothes_type.add(new Cloth(1,cloth[1]));
        }

        for(int i =0;i<clothes_type.size();i++){
            answer *= clothes_type.get(i).num + 1;
        }

        return answer - 1;
    }

    class Cloth {
        int num;
        String type;

        public Cloth(int x, String y) {
            num = x;
            type = y;
        }
    }
}
