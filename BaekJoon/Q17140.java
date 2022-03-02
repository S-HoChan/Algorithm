package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17140 {   // 이차원 배열과 연산
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        List<List<Integer>> arrA = new LinkedList<>();
        for (int y = 0; y < 3; y++) {
            st = new StringTokenizer(br.readLine());
            arrA.add(new LinkedList<>());
            for (int x = 0; x < 3; x++) {
                arrA.get(y).add(Integer.parseInt(st.nextToken()));
            }
        }

        int answer = 0;
        int maxRow = 3, maxCol = 3;
        while (answer <= 100) {
            if (maxRow > r && maxCol > c && arrA.get(r).get(c) == k) break;

            if (maxRow >= maxCol) {   // R연산
                for (int y = 0; y < maxRow; y++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int x = 0; x < arrA.get(y).size(); x++) {
                        int now = arrA.get(y).get(x);
                        if (now == 0) continue;

                        if (map.containsKey(now)) {
                            map.put(now, map.get(now) + 1);
                        } else {
                            map.put(now, 1);
                        }
                    }

                    List<Integer> list = mySort(map);
                    arrA.set(y, list);
                    maxCol = Math.max(maxCol, list.size());
                }

                for (int y = 0; y < maxRow; y++) {
                    while (arrA.get(y).size() < maxCol) {
                        arrA.get(y).add(0);
                    }
                }
            } else { // C연산
                List<List<Integer>> temp = new ArrayList<>();
                int maxY = maxRow;
                for (int x = 0; x < maxCol; x++) {
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int y = 0; y < maxY; y++) {
                        if (arrA.get(y).size() <= x) continue;
                        int now = arrA.get(y).get(x);
                        if (now == 0) continue;

                        if (map.containsKey(now)) {
                            map.put(now, map.get(now) + 1);
                        } else {
                            map.put(now, 1);
                        }
                    }

                    List<Integer> list = mySort(map);
                    temp.add(list);
                    maxRow = Math.max(maxRow, list.size());
                }

                int[][] tempArr = new int[maxRow][maxCol];
                for (int i = 0; i < maxRow; i++) {
                    Arrays.fill(tempArr[i], 0);
                }

                for (int x = 0; x < maxCol; x++) {
                    for (int y = 0; y < temp.get(x).size(); y++) {
                        tempArr[y][x] = temp.get(x).get(y);
                    }
                }

                arrA = new LinkedList<>();
                for (int y = 0; y < maxRow; y++) {
                    arrA.add(new LinkedList<>());
                    for (int x = 0; x < maxCol; x++) {
                        arrA.get(y).add(tempArr[y][x]);
                    }
                }
            }
            answer++;
        }

        System.out.println(answer <= 100 ? answer : -1);
    }

    static List<Integer> mySort(Map<Integer, Integer> map) {
        List<int[]> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(new int[]{key, map.get(key)});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        List<Integer> temp = new LinkedList<>();
        while (!list.isEmpty()) {
            int[] now = list.remove(0);
            temp.add(now[0]);
            temp.add(now[1]);
            if (temp.size() == 100) break;
        }

        return temp;
    }
}
